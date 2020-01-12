package com.charon.boot.service;

import com.charon.boot.exception.CustomException;
import com.charon.boot.exception.CustomExceptionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-12 19:59
 **/
@Service
public class ExceptionServiceImpl implements  ExceptionService {
    @Override
    public void systemBizError() {
        try {
            Class.forName("com.mysql.jdbc.xxxx.Driver");
        } catch (ClassNotFoundException e) {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"在XXX业务，myBiz()方法内，出现ClassNotFoundException");
        }
    }

    @Override
    public List<String> userBizError(int input) {
        // 模拟业务校验失败逻辑
        if(input < 0){
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,"您输入的数据不符合业务逻辑，请确认后重新输入！");
        }else{
            List<String> list = new ArrayList<>();
            list.add("科比");
            list.add("詹姆斯");
            list.add("库里");
            return list;
        }
    }
}
