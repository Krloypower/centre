package com.centre.loop.config;

import com.centre.loop.controller.PortController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThrealPoolConfig
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/10
 * @Version 1.0
 **/
@Configuration
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setAllowCoreThreadTimeOut(true);
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("----taskExecutor--");
        // 拒绝策略，会使用主线程执行，导致阻塞主线程
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

   /* // 测试 policy 代码
    private static Logger logger = LoggerFactory.getLogger(ThreadPoolConfig.class);
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1),new ThreadPoolExecutor.CallerRunsPolicy());
        CustomizableThreadFactory factory = new CustomizableThreadFactory();
        factory.setThreadNamePrefix("--kang--");
        executor.setThreadFactory(factory);
        for (int i = 0; i< 10; i++){
            executor.execute(()-> logger.info("111"));
        }
        executor.shutdown();
    }*/
}
