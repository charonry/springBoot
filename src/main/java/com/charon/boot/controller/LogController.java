package com.charon.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 日志打印和生成
 * @author: charon
 * @create: 2020-01-14 09:42
 **/
@RestController
@Slf4j
public class LogController {

    @GetMapping("/logdemo")
    public String log(){
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        return "logok";
    }
}
