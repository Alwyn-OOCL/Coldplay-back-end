package com.oocl.coldplay.login.controller;

import com.oocl.coldplay.common.model.Result;
import com.oocl.coldplay.login.model.LoginFormDTO;
import com.oocl.coldplay.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginFormDTO loginFormDTO) {
        return loginService.login(loginFormDTO);
    }
}
