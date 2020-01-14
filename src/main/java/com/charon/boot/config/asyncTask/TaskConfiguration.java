package com.charon.boot.config.asyncTask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 线程池配置类
 * @author: charon
 * @create: 2020-01-14 15:40
 **/
@Configuration
public class TaskConfiguration {
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数:线程池创建时候初始化的线程数
        executor.setCorePoolSize(10);
        // 最大线程数
        executor.setMaxPoolSize(20);
        // 缓冲队列
        executor.setQueueCapacity(200);
        // 允许线程的空闲时间
        executor.setKeepAliveSeconds(60);
        // 线程池名的前缀
        executor.setThreadNamePrefix("taskExecutor-");
        // 线程池对拒绝任务的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        /**
         * 该方法用来设置线程池关闭的时候等待所有任务都完成后，再继续销毁其他的 Bean，
         * 这样这些异步任务的销毁就会先于数据库连接池对象的销毁
         */
        executor.setWaitForTasksToCompleteOnShutdown(true);
        /**
         *设置线程池中任务的等待时间，如果超过这个时间还没有销毁就强制销毁,
         * 以确保应用最后能够被关闭,而不是阻塞住。
         */
        executor.setAwaitTerminationSeconds(60);
        return executor;
    }
}
