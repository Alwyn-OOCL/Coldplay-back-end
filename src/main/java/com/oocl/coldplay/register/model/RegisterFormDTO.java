package com.oocl.coldplay.register.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterFormDTO {
    private String email;
    private String userName;
    // md5加密，需解密
    private String password;
}
