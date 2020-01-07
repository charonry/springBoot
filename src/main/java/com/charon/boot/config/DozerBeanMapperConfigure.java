package com.charon.boot.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: bean转换Dozer
 * @author: charon
 * @create: 2020-01-06 23:02
 **/
@Configuration
public class DozerBeanMapperConfigure {
    @Bean
    public DozerBeanMapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }
}