package com.recruit.chCruit.infra.entity.articlePackage;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "article_tag")
public class ArticleTag {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Article article;
}
