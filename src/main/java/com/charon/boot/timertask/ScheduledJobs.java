package com.charon.boot.timertask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 定时任务jobs
 * @author: charon
 * @create: 2020-01-14 17:14
 **/
@Component
public class ScheduledJobs {

   /* // 表示方法执行完成后5秒再开始执行
    @Scheduled(fixedDelay=5000)
    public void fixedDelayJob() throws InterruptedException{
        System.out.println("fixedDelay 开始:" + new Date());
        Thread.sleep(10 * 1000);
        System.out.println("fixedDelay 结束:" + new Date());
    }

    // 每三秒执行一次
    @Scheduled(fixedRate=3000)
    public void fixedRateJob()throws InterruptedException{
        System.out.println("===========fixedRate 开始:" + new Date());
        Thread.sleep(5 * 1000);
        System.out.println("===========fixedRate 结束:" + new Date());
    }


    // 表示每隔10秒执行一次
    @Scheduled(cron="0/10 * * * * ? ")
    public void cronJob(){
        System.out.println("=========================== ...>>cron...." + new Date());
    }*/
}
