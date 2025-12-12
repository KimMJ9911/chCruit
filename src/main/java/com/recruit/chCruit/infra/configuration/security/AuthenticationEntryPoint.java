package com.recruit.chCruit.infra.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruit.chCruit.infra.DTO.GenericApiResponse;
import com.recruit.chCruit.infra.Enums.ErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Object exception = request.getAttribute("exception");

        ErrorCode errorCode;

        if (exception instanceof ErrorCode) {
            errorCode = (ErrorCode) exception;
        } else {
            errorCode = ErrorCode.UNAUTHORIZED;
        }

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        GenericApiResponse<Void> apiResponse = GenericApiResponse.fail(errorCode.getMessage());
        String jsonResponse = objectMapper.writeValueAsString(apiResponse);

        //클라이언트 전송
        response.getWriter().write(jsonResponse);
    }
}
