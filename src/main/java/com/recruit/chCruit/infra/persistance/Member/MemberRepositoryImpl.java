package com.recruit.chCruit.infra.persistance.Member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.recruit.chCruit.infra.DTO.resDTO.QRoleDTO;
import com.recruit.chCruit.infra.DTO.resDTO.RoleDTO;
import com.recruit.chCruit.infra.entity.memberPackage.Member;
import com.recruit.chCruit.infra.entity.memberPackage.QMember;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.recruit.chCruit.infra.entity.memberPackage.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public Member findMemberByEmail(String email) {
//        return null;
        return queryFactory.select(member)
                .from(member)
                .where(member.email.eq(email))
                .fetchOne();
    }
}
