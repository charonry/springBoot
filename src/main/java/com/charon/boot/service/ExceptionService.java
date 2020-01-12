package com.charon.boot.service;

import java.util.List;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-12 19:58
 **/
public interface ExceptionService {
    // 服务层，模拟系统异常
    public void systemBizError();
    // 服务层，模拟用户输入数据导致的校验异常
    public List<String> userBizError(int input);
}
