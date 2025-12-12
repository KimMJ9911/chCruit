package com.recruit.chCruit.infra.DTO;

import com.recruit.chCruit.infra.Enums.ArticleType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class articleDTO {
    private Long articleId;

    @Enumerated
    private ArticleType articleType;

    @Data
    @NoArgsConstructor
    public static class Articles {
        private String articleDate;
        private String articleTitle;
        private String articleContent;
        private String articleAuthor;
        private String articleImage;
        private String articleLink;
        private List<String> articleCategory;
        private String articleCategoryName;
    }
}
