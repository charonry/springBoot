package com.charon.boot.config.asyncTask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description: 异步执行
 * @author: charon
 * @create: 2020-01-14 14:30
 **/
@Component
public class AsyncTask extends AbstractTask{

    @Async
    @Override
    public void doTaskOne() throws Exception {
        super.doTaskOne();
    }

    @Async
    @Override
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
    }

    @Async
    @Override
    public void doTaskThree() throws Exception {
        super.doTaskThree();
    }
}
