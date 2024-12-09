package com.oocl.coldplay.common.interceptor;

import cn.hutool.core.text.CharSequenceUtil;
import com.oocl.coldplay.common.model.user.UserHolder;
import com.oocl.coldplay.common.redis.constants.RedisConstants;
import com.oocl.coldplay.common.model.user.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

@NoArgsConstructor
@AllArgsConstructor
public class RefreshInterceptor implements HandlerInterceptor {

    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取token
        String token = request.getHeader("authorization");
        if (CharSequenceUtil.isBlank(token)) {
            return true;
        }
        // 2.通过token获取user对象
        UserDTO user = (UserDTO) redisTemplate.opsForValue().get(RedisConstants.LOGIN_USER_KEY + token);

        // 3.判断对象是否为空
        if (user == null) {
            return true;
        }

        // 4.将user对象保存到ThreadLocal中
        UserHolder.saveUser(user);
        // 5.刷新token的有效时间
        redisTemplate.expire(RedisConstants.LOGIN_USER_KEY + token, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        // 6.放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}