package com.recruit.chCruit.domain.login.DTO;

import com.querydsl.core.annotations.QueryProjection;
import com.recruit.chCruit.infra.Enums.Provider;
import lombok.Data;

@Data
public class SocialLoginInfoDTO {
    private String email;
    private String socialId;
    private String name;
    private Provider socialType;

    @QueryProjection
    public SocialLoginInfoDTO(String email, String socialId, String name, Provider socialType) {
        this.email = email;
        this.socialId = socialId;
        this.name = name;
        this.socialType = socialType;
    }
}
