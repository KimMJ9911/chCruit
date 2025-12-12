package com.recruit.chCruit.domain.login.Controller;

import com.recruit.chCruit.domain.login.DTO.LocalLoginInfoDTO;
import com.recruit.chCruit.domain.login.Service.LoginService;
import com.recruit.chCruit.infra.DTO.JWToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final LoginService loginService;
    public JWToken login(@RequestBody LocalLoginInfoDTO info) {
        return null;
    }

    public JWToken signUp(@RequestBody LocalLoginInfoDTO info) {
        return null;
    }
}
