package com.recruit.chCruit.infra.entity.memberPackage;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "profile")
public class Profile {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "visible", nullable = false)
    private boolean visible;

    @Column(name = "notification_set", nullable = false)
    private boolean notification;

    @OneToOne
    private Member member;
}
