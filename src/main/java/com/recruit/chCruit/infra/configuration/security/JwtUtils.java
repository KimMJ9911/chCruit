package com.recruit.chCruit.infra.configuration.security;

import com.recruit.chCruit.infra.DTO.JWToken;
import com.recruit.chCruit.infra.Enums.ErrorCode;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
    @Value("${spring.jwt.JWT_SECRET_KEY}")
    private String JWT_SECRET_KEY;

    @Value("${spring.jwt.ACCESS_TOKEN_EXPIRE_TIME}")
    private Long ACCESS_TOKEN_EXPIRE_TIME;

    @Value("${spring.jwt.REFRESH_TOKEN_EXPIRE_TIME}")
    private Long REFRESH_TOKEN_EXPIRE_TIME;

    private final String JWT_PREFIX = "Bearer ";

    //토큰 생성 로직
    public JWToken generateToken(String email , String password) {
        long now = (new Date()).getTime();
        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);

        Date accessTokenExpiryTime = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        String accessToken = Jwts.builder()
                .subject(authentication.getName())
                .issuedAt(new Date())
                .claim("authorities", authentication.getAuthorities())
                .expiration(accessTokenExpiryTime)
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
                .compact();

        Date refreshTokenExpiryTime = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);
        String refreshToken = Jwts.builder()
                .subject(authentication.getName())
                .issuedAt(new Date())
                .expiration(refreshTokenExpiryTime)
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
                .compact();

        return JWToken.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    //만료 여부와 상관없이 토큰에서 꺼내서 security context 에 넣어주기
    //필터 요청
    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);

        //만료되었거나 잘못된 토큰인 경우
        if (claims.get("auth") == null) {
            //추후에 로직 생성
        }

        //토큰에서 권한 정보 불러오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("auth").toString()
                                .split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        UserDetails principal = new User(claims.getSubject() , "" , authorities);
        return new UsernamePasswordAuthenticationToken(principal , "" , authorities);
    }

    //토큰 유효성 검증 로직
    public boolean validateToken(String token , HttpServletRequest request) {
        try {
            Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            //잘못된 토큰
            request.setAttribute("exception", ErrorCode.INVALID_TOKEN);
        } catch (ExpiredJwtException e) {
            //만료된 토큰
            request.setAttribute("exception", ErrorCode.EXPIRED_TOKEN);
        } catch (UnsupportedJwtException e) {
            //지원하는 토큰과 다름
            request.setAttribute("exception", ErrorCode.INVALID_TOKEN);
        } catch (IllegalArgumentException e) {
            //토큰이 잘못됨
            request.setAttribute("exception", ErrorCode.INVALID_TOKEN);
        }

        return false;
    }

    // 5. 토큰 파싱 (내부용)
    // 만료된 토큰이라도 정보를 꺼내야 할 때(재발급 시)를 위해 예외 처리를 분리함
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
                    .build()
                    .parseSignedClaims(accessToken)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            // 만료된 토큰이어도 클레임(정보)은 반환
            return e.getClaims();
        }
    }


}
