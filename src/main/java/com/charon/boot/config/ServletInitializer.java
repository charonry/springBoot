package com.charon.boot.config;

import com.charon.boot.BootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @description: 部署到外部坏境
 * @author: charon
 * @create: 2019-01-12 15:52
 **/
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 此处的Application.class为带有@SpringBootApplication注解的启动类
        return builder.sources(BootApplication.class);
    } 
}