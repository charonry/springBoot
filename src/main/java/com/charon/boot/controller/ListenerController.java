package com.charon.boot.controller;

import com.charon.boot.customListener.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 监听事件的发布
 * @author: charon
 * @create: 2020-01-12 14:16
 **/
@RestController
public class ListenerController {

    @Resource
    ApplicationContext applicationContext;

    /**
     * 发布一个事件
     *
     * @return
     */
    @RequestMapping("/publish")
    public String hello() {
        // Todo 业务处理
        applicationContext.publishEvent(new MyEvent("邮件内容"));
        return "ok";
    }
}
