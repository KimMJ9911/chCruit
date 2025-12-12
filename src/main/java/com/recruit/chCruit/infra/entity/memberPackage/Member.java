package com.recruit.chCruit.infra.entity.memberPackage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recruit.chCruit.infra.Enums.MemberStatus;
import com.recruit.chCruit.infra.Enums.MemberType;
import com.recruit.chCruit.infra.Enums.Provider;
import com.recruit.chCruit.infra.entity.articlePackage.Article;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private Boolean pwExpired;

    @JsonIgnore
    private String lastPassword;

    private LocalDateTime createTime;

    @JsonIgnore
    private String createIp;    //  뒷자리 가리고 저장 , 3개월 저장 후 파기

    @Enumerated(EnumType.STRING)
    private Provider provider;

    private String socialIdentify;

    private String profileImg;
    private String nickname;

    @OneToMany(
            mappedBy = "article" ,
            fetch = FetchType.LAZY
    )
    private List<Article> article;

    @OneToOne(
            mappedBy = "member_status" ,
            fetch = FetchType.EAGER
    )
    private Status memberStatus;
}
