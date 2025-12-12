package com.recruit.chCruit.infra.entity.articlePackage;

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
@Table(name = "sample_files")
public class AdditionalSample extends BaseTime {
    @Id @GeneratedValue
    private Integer id;

    @Column(length = 500 , name = "file_path" , nullable = false)
    private String filePath;

    @Column(name = "file_ext" , length = 10 , nullable = false)
    private String fileExt;

    @Column(name = "original_file_name" , nullable = false)
    private String originalFileName;

    @Column(name = "file_size" , nullable = false)
    private Long fileSize;

    @ManyToOne
    private Article article;
}
