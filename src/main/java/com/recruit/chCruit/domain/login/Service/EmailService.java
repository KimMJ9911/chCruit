package com.recruit.chCruit.domain.login.Service;

import com.recruit.chCruit.infra.Enums.ErrorCode;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    // 1. 인증 번호 전송
    public void sendEmail(String toEmail, String authCode) {
        String subject = "회원가입 인증 번호입니다.";
        String text = "<h3>요청하신 인증 번호입니다.</h3>" +
                "<h1>" + authCode + "</h1>" +
                "<h3>인증 번호는 5분간 유효합니다.</h3>";

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");

            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(text, true); // true: HTML 형식 사용

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            log.error("Email sending failed", e);
            throw new RuntimeException("이메일 전송에 실패했습니다.");
        }
    }

    // 2. 랜덤 인증 코드 생성 (6자리)
    public String createCode(HttpServletRequest request) {
        try {
            Random random = SecureRandom.getInstanceStrong();
            int randomInt = random.nextInt(900000) + 100000;
            return String.valueOf(randomInt);
        } catch (NoSuchAlgorithmException e) {
            request.setAttribute("exception", ErrorCode.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
