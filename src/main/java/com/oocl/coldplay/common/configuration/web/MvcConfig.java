package com.oocl.coldplay.common.configuration.web;

import com.oocl.coldplay.common.interceptor.LoginInterceptor;
import com.oocl.coldplay.common.interceptor.RefreshInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(
                "/login",
                "/register",
                // 其他不需要登陆的接口 todo
                ""
        ).order(1);
        registry.addInterceptor(new RefreshInterceptor(redisTemplate)).addPathPatterns("/**").order(0);
    }
}