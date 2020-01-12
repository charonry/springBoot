package com.charon.boot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-12 14:52
 **/
@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner参数名称: {}", args.getOptionNames());
        log.info("ApplicationRunner参数: {}", args.getSourceArgs());
        log.info("ApplicationRunner参数: {}", args.getOptionValues("name"));
        log.info("ApplicationRunner参数值: {}", args.getOptionValues("age"));
    }
}
