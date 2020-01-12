package com.charon.boot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-12 14:49
 **/
@Component
@Slf4j
public class CommandLineStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // CommandLineRunner：参数是字符串数组
        log.info("CommandLineRunner传入参数：{}", Arrays.toString(args));
    }
}
