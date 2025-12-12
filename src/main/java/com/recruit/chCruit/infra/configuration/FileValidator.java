package com.recruit.chCruit.infra.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Apache tika 사용해서 파일 종류 검증
 */
@Component
@RequiredArgsConstructor
public class FileValidator {
    private final Tika tika = new Tika();

    public void validate(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            String mimeType = tika.detect(inputStream);
        }

        //파일 검증 방식에 관한 추가 로직 구현 필요
    }
}
