package com.recruit.chCruit.domain.login.DTO;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class LocalLoginInfoDTO {
    private String email;
    private String password;

    @QueryProjection
    public LocalLoginInfoDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
