package com.charon.boot.timertask;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description: Quartz定时任务
 * @author: charon
 * @create: 2020-01-14 17:54
 **/
public class QuartzSimpleTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz简单的定时任务执行时间："+ LocalDateTime.now());
    }
}
