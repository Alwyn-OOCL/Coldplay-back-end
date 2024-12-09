package com.oocl.coldplay.login.service;

import static com.oocl.coldplay.common.redis.constants.RedisConstants.LOGIN_USER_KEY;
import static com.oocl.coldplay.common.redis.constants.RedisConstants.LOGIN_USER_TTL;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.oocl.coldplay.common.model.Result;
import com.oocl.coldplay.common.model.user.UserDTO;
import com.oocl.coldplay.common.model.user.UserHolder;
import com.oocl.coldplay.common.redis.service.RedisCacheService;
import com.oocl.coldplay.entity.User;
import com.oocl.coldplay.login.model.LoginFormDTO;
import com.oocl.coldplay.service.UserService;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserService userService;
    private final RedisCacheService redisCacheService;

    public Result login(LoginFormDTO loginForm) {
        // 根据用户名 / 邮箱查询用户
        User user = null;
        if (loginForm.getEmail() != null) {
            user = userService.getUserByEmail(loginForm.getEmail());
        }
        if (loginForm.getUserName() != null) {
            user = userService.getUserByName(loginForm.getUserName());
        }

        // 判断用户是否存在
        if (user == null) {
            return Result.fail("用户不存在");
        }

        // 保存用户信息到ThreadLocal
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        String token = String.valueOf(UUID.randomUUID(true));
        String tokenKey = LOGIN_USER_KEY + token;
        redisCacheService.set(tokenKey, userDTO, LOGIN_USER_TTL, TimeUnit.MINUTES);

        // 保存用户信息到ThreadLocal
        UserHolder.saveUser(userDTO);

        // 返回token给前端
        return Result.ok(token);
    }

}
