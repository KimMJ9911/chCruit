package com.recruit.chCruit.infra.persistance.Member;

import com.recruit.chCruit.infra.entity.memberPackage.Member;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Member findMemberByEmail(String email);
}
