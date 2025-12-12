package com.recruit.chCruit.infra.configuration.security;

import com.recruit.chCruit.infra.Enums.ErrorCode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticateFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;
    private final RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //헤더에서 토큰 추출
        String token = resolveToken(request);

        if (token != null && jwtUtils.validateToken(token , request)) {
            String key = "BL:" + token;
            //redis 에 저장된 블랙 리스트 명단에 있는지
            if (!redisService.isBlackList(key)) {
                Authentication authentication =
                        jwtUtils.getAuthentication(token);
                //securityContextHolder 에 저장하고 @AuthenticationPrincipal 로 꺼내기 가능
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                //로그아웃으로 사용 못하는 토큰이므로
                request.setAttribute("exception" , ErrorCode.LOGOUT_TOKEN);
            }
        }

        filterChain.doFilter(request , response);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }
}
