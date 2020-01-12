package com.charon.boot.exception;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
// 只能在方法上使用此注解
@Target({ElementType.METHOD})
public @interface ModelView {

}