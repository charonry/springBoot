package com.charon.boot.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @description: 监听器
 * @author: charon
 * @create: 2020-01-10 10:11
 **/
@Slf4j
@WebListener
public class Customlister implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info(" request监听器：销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        log.info(" request监听器：可以在这里记录访问次数哦");
    }
}
