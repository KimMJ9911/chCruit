package com.recruit.chCruit.infra.entity.ApplicationPackage;

import com.recruit.chCruit.infra.Enums.ApplicationType;
import com.recruit.chCruit.infra.embed.BaseTime;
import com.recruit.chCruit.infra.entity.articlePackage.Article;
import com.recruit.chCruit.infra.entity.memberPackage.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "application")
public class Application extends BaseTime {
    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ApplicationType applicationType;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Article article;
}
