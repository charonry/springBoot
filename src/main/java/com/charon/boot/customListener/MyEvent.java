package com.charon.boot.customListener;

import org.springframework.context.ApplicationEvent;

/**
 * @description: 自定义一个事件
 * @author: charon
 * @create: 2020-01-12 14:05
 **/
@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
