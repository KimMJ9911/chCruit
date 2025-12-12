package com.recruit.chCruit.domain.article.controller;

import com.recruit.chCruit.domain.article.service.forumService;
import com.recruit.chCruit.domain.article.service.searchArticleService;
import com.recruit.chCruit.domain.article.service.wantedArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/post/forum")
public class freeArticleController {
    private final forumService forumService;
    private final searchArticleService searchArticleService;
    private final wantedArticleService wantedArticleService;


}
