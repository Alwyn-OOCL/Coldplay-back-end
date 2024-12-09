package com.oocl.coldplay.register.service;

import static com.oocl.coldplay.common.redis.constants.RedisConstants.LOGIN_USER_KEY;
import static com.oocl.coldplay.common.redis.constants.RedisConstants.LOGIN_USER_TTL;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.oocl.coldplay.common.model.Result;
import com.oocl.coldplay.common.model.user.UserDTO;
import com.oocl.coldplay.common.model.user.UserHolder;
import com.oocl.coldplay.common.redis.service.RedisCacheService;
import com.oocl.coldplay.common.utils.RegexUtils;
import com.oocl.coldplay.user.model.User;
import com.oocl.coldplay.register.model.RegisterFormDTO;
import com.oocl.coldplay.user.service.UserService;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserService userService;
    private final RedisCacheService redisCacheService;

    public Result register(RegisterFormDTO registerForm) {
        String email = registerForm.getEmail();

        //校验邮箱格式
        boolean emailInvalid = RegexUtils.isEmailInvalid(email);
        if (emailInvalid) {
            return Result.fail("请输入正确的邮箱");
        }

        // 检查用户是否已存在
        User existingUser = userService.getUserByEmail(email);
        if (existingUser != null) {
            return Result.fail("用户已存在");
        }

        // 创建新用户
        User newUser = BeanUtil.copyProperties(registerForm, User.class);
        userService.createUser(newUser);

        // 将新用户信息保存到Redis
        String token = String.valueOf(UUID.randomUUID(true));
        String tokenKey = LOGIN_USER_KEY + token;
        redisCacheService.set(tokenKey, registerForm, LOGIN_USER_TTL, TimeUnit.MINUTES);

        // 保存用户信息到ThreadLocal
        User user = userService.getUserByEmail(email);
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        UserHolder.saveUser(userDTO);

        // 返回token给前端
        return Result.ok(token);
    }

}
