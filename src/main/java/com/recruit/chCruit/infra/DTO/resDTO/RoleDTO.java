package com.recruit.chCruit.infra.DTO.resDTO;

import com.querydsl.core.annotations.QueryProjection;
import com.recruit.chCruit.infra.Enums.MemberRole;
import lombok.Getter;

@Getter
public class RoleDTO {
    private MemberRole memberRole;

    @QueryProjection
    public RoleDTO(MemberRole memberRole) {
        this.memberRole = memberRole;
    }
}
