package com.kroly.centre.config;

import org.springframework.scheduling.annotation.AsyncConfigurer;
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
@Component("AsyncConfig")
public class AsyncConfig  implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        return new ThreadPoolExecutor(20,100,60, TimeUnit.SECONDS,new SynchronousQueue<>());
    }
}
