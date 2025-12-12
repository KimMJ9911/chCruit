package com.recruit.chCruit.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class CloudFrontConfig {
    //cloudfront 방식으로 설정해야 하므로 별도 추가 로직 필요
}
