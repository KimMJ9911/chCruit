package com.recruit.chCruit.infra.DTO;

import jakarta.persistence.GeneratedValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JWToken {
    private String accessToken;
    private String refreshToken;
}
