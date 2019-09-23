package com.kroly.centre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.lang.model.element.Name;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AsyncConfig
 * @Description 给 @Async 注解配置线程池 可以制定
 * @Author ouyangkang
 * @Date 2019-06-17 11:32
 **/
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("taskExecutor")
    public Executor getExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("job-Executor-");
        executor.setMaxPoolSize(100);
        executor.setCorePoolSize(20);
        executor.setKeepAliveSeconds(300);//300秒后核心线程数退出
        // 自动关闭线程池中的核心线程池 默认是false
        executor.setAllowCoreThreadTimeOut(true);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(10);
        executor.setQueueCapacity(200);
        //直接抛弃，不抛出异常
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.initialize();////如果不初始化，导致找到不到执行器
        return executor;
    }

}
