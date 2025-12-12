package com.recruit.chCruit.infra.entity.memberPackage;

import com.recruit.chCruit.infra.Enums.MemberRole;
import com.recruit.chCruit.infra.Enums.MemberStatus;
import com.recruit.chCruit.infra.embed.BaseTime;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "member_status")
public class Status extends BaseTime {
    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_status" , nullable = false)
    private MemberStatus memberStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_role" , nullable = false)
    private MemberRole memberRole;

    @ManyToOne
    private Member member;

}
