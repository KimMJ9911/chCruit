package com.recruit.chCruit.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class AWSConfig {

    // 1. 업로드용 (S3 직접 접근) - 기존 유지
    @Bean
    public S3Presigner s3Presigner() {
        return S3Presigner.builder()
                .region(Region.AP_EAST_1)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    // 2. 다운로드용 (CloudFront CDN) - 신규 추가 (별도 Bean 없어도 됨, 라이브러리 활용)
    // CloudFront는 credentialsProvider 대신 PrivateKey 파일을 직접 사용하므로
    // 별도의 Client Bean 설정보다는 Service 내부 로직에서 처리하는 경우가 많습니다.
}
