package com.charon.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 注入拦截器
 * @author: charon
 * @create: 2020-01-10 16:31
 **/
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public static HandlerInterceptor getHandlerInterceptor() {
        return new CustomHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器 拦截规则
        // 多个拦截器时 以此添加 执行顺序按添加顺序
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
    }

}
