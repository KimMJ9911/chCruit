package com.recruit.chCruit.infra.persistance.Member;

import com.recruit.chCruit.infra.entity.memberPackage.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<UUID, Member> , MemberRepositoryCustom{
}
