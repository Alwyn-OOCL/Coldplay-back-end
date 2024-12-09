package com.oocl.coldplay.register.controller;

import com.oocl.coldplay.common.model.Result;
import com.oocl.coldplay.register.model.RegisterFormDTO;
import com.oocl.coldplay.register.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping
    public Result register(@RequestBody RegisterFormDTO registerForm) {
        return registerService.register(registerForm);
    }
}
