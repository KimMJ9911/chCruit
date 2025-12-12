package com.recruit.chCruit.domain.login.Service;

import com.recruit.chCruit.infra.DTO.JWToken;
import com.recruit.chCruit.infra.configuration.RedisConfig;
import com.recruit.chCruit.infra.configuration.security.JwtUtils;
import com.recruit.chCruit.infra.persistance.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;
    private final JwtUtils jwtUtils;
    private final RedisConfig redisConfig;

    public JWToken login(String email, String password) {

    }
}
