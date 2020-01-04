package com.charon.boot.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: bean转换Dozer
 * @author: charon
 * @create: 2020-01-04 15:02
 **/
@Configuration
public class DozerBeanMapperConfigure {

    /**
     * 使用
     * @return
     */
//    @Autowired
//    protected Mapper dozerMapper;

    @Bean
    public DozerBeanMapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }
}
