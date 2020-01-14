package com.charon.boot.timertask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description: 定时任务单线程运行的处理
 * @author: charon
 * @create: 2020-01-14 17:23
 **/
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(scheduledTaskExecutor());
    }

    @Bean
    public Executor scheduledTaskExecutor() {
        return Executors.newScheduledThreadPool(3);
    }
}
