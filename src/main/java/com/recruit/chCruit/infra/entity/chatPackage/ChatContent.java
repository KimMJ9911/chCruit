package com.recruit.chCruit.infra.entity.chatPackage;

import com.recruit.chCruit.infra.Enums.ChatContentType;
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
@Table(name = "chat_content")
public class ChatContent {
    @Id @GeneratedValue
    private Long id;

    /**
     * message 타입에 따라 다르게 나타내야 함
     * TEXT 인 경우 : text 로 저장
     * IMAGE 인 경우 : 미리보기 + S3 저장
     * FILE인 경우 : 파일 정보 + S3 에 저장
     */
    @Column(name = "message" , length = 2000)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "chat_content_type" , nullable = false)
    private ChatContentType chatContentType;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "send_at")
    private LocalDateTime sendAt;

    @ManyToOne
    private ChatRoom chatRoom;

    @ManyToOne
    private Member sender;
}
