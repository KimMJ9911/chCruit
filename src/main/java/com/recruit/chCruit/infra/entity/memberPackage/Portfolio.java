package com.recruit.chCruit.infra.entity.memberPackage;

import com.recruit.chCruit.infra.embed.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "portfolio")
public class Portfolio extends BaseTime {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "file_path" , length = 500 , nullable = false)
    private String filePath;

    @Column(name = "file_ext" , length = 10 , nullable = false)
    private String fileExt;

    @Column(name = "original_file_name" , nullable = false)
    private String originalFileName;

    @Column(name = "file_size" , nullable = false)
    private Long fileSize;

    @ManyToOne
    private Member member;
}
