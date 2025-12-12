package com.recruit.chCruit.infra.entity.articlePackage;

import com.recruit.chCruit.infra.Enums.ArticleJobTags;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tags")
public class Tags {
    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ArticleJobTags articleJobTags;

    private String etcDetail;

    @ManyToOne
    private ArticleTag articleTag;
}
