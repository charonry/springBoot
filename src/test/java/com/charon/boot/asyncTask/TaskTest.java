package com.charon.boot.asyncTask;

import com.charon.boot.config.asyncTask.AsyncCallBackTask;
import com.charon.boot.config.asyncTask.AsyncTask;
import com.charon.boot.config.asyncTask.SyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setOut;
import static java.lang.Thread.sleep;

/**
 * @description: 测试异步任务
 * @author: charon
 * @create: 2020-01-14 14:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {
    @Resource
    private SyncTask syncTask;

    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private AsyncCallBackTask asyncCallBackTask;

    @Test
    public void testSyncTasks() throws Exception {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }

    @Test
    public void testAsyncTasks() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }

    @Test
    public void testAsyncCallbackTask() throws Exception {
        long start = currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.doTaskOneCallback();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallback();
        Future<String> task3 = asyncCallBackTask.doTaskThreeCallback();

        // 三个任务都调用完成，退出循环等待
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            sleep(1000);
        }

        long end = currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void test()throws Exception{
        int i = 0;
        System.out.println("开始");
        long start = currentTimeMillis();
        while (i==0) {
            sleep(1000);
        }
        long end = currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}
