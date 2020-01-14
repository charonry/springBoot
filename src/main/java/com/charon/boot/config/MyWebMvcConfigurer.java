package com.charon.boot.config;

import com.charon.boot.config.accessLog.AccessLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 对于拦截器的注册
 * @author: charon
 * @create: 2020-01-14 11:44
 **/
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    // 设置排除路径，spring boot 2.*，注意排除掉静态资源的路径，不然静态资源无法访问
    private final String[] excludePath = {"/static"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessLogInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
