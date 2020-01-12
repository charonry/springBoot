package com.charon.boot.exception;

/**
 * @description:  自定义异常
 * @author: charon
 * @create: 2020-01-12 17:26
 **/
public class CustomException extends   RuntimeException{
    //异常错误编码
    private int code ;
    //异常信息
    private String message;

    public CustomException(CustomExceptionType exceptionTypeEnum, String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
