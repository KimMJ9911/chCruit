package com.recruit.chCruit.infra.entity.chatPackage;

import com.recruit.chCruit.infra.entity.memberPackage.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "chat_participant")
public class ChatParticipant {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "joined_at")
    private LocalDateTime joinedAt;

    @Column(name = "is_exit")
    private boolean isExit;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private ChatRoom chatRoom;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private ChatParticipant lastReadContentId;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private Member member;
}
