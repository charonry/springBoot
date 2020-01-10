package com.charon.boot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @description: 设置过滤器的执行顺序
 * @author: charon
 * @create: 2020-01-10 15:08
 **/
@Configuration
public class FilterRegistration {

    @Bean
    public Filter customFilter() {
        return new CustomFilter();
    }

    @Bean
    public Filter customFilter2() {
        return new CustomFilter2();
    }

    /**
     *注入一个过滤器的并设置执行顺序
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 当过滤器有注入其他bean类时，可直接通过@Bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        // 当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        registration.setFilter(customFilter());
        // 过滤器名称
        registration.setName("customFilter");
        // 拦截路径
        registration.addUrlPatterns("/*");
        // 设置顺序
        registration.setOrder(10);
        return registration;
    }

    /**
     *注入一个过滤器的并设置执行顺序
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        registration.setFilter(customFilter2());
        //过滤器名称
        registration.setName("customFilter2");
        //拦截路径
        registration.addUrlPatterns("/*");
        //设置顺序
        registration.setOrder(11);
        return registration;
    }

}
