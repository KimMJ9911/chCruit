package com.recruit.chCruit.infra.entity.chatPackage;

import com.recruit.chCruit.infra.embed.BaseTime;
import com.recruit.chCruit.infra.entity.articlePackage.Article;
import com.recruit.chCruit.infra.entity.memberPackage.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "chat_room")
public class ChatRoom {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String message;

    @Column
    private LocalDateTime send_at;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    private Member participant_id1;

    @ManyToOne
    private Member participant_id2;
}
