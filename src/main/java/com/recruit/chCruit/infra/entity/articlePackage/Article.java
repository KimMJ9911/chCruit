package com.recruit.chCruit.infra.entity.articlePackage;

import com.recruit.chCruit.infra.Enums.ArticleType;
import com.recruit.chCruit.infra.Enums.ContractDuration;
import com.recruit.chCruit.infra.Enums.WorkLocation;
import com.recruit.chCruit.infra.embed.BaseTime;
import com.recruit.chCruit.infra.entity.chatPackage.ChatRoom;
import com.recruit.chCruit.infra.entity.memberPackage.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "article")
public class Article extends BaseTime {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "article_type")
    private ArticleType articleType;

    @Column(name = "recruit_volume")
    private Integer recruitVolume;

    @Column(nullable = false)
    private String title;

    @Column(
            nullable = false ,
            length = 2000
    )
    private String content;

    @Column(
            nullable = false ,
            length = 1000 ,
            name = "qualificaion_detail"
    )
    private String qualificationDetail;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_duration")
    private ContractDuration contractDuration;

    @Enumerated(EnumType.STRING)
    @Column(name = "work_at")
    private WorkLocation workLocation;

    private String pay;

    @Column(name = "video_source" , length = 1000)
    private String videoSourceUrl;

    private Integer contact;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private Member member;

    @OneToMany(
            mappedBy = "article" ,
            orphanRemoval = true ,
            cascade = CascadeType.REMOVE
    )
    private List<ChatRoom> chatRooms;

    public void closeArticle() {
        this.articleType = ArticleType.EXPIRED;
    }
}
