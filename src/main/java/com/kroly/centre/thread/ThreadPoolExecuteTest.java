package com.kroly.centre.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolExecuteTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020-04-13 18:08
 **/
public class ThreadPoolExecuteTest {



    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskExecutor executorService = buildThreadPoolExcute();
        executorService.execute(() -> sayHi("execute"));

        TimeUnit.SECONDS.sleep(10);

        System.out.println("=========");

        Future<?> submit = executorService.submit(() -> sayHi("submit"));
        try {
            submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void sayHi(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name+"】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",我异常啦!哈哈哈!");
    }

    private static ThreadPoolTaskExecutor buildThreadPoolExcute(){

        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();

        poolTaskExecutor.setThreadNamePrefix("---kang--");
        poolTaskExecutor.setCorePoolSize(5);
        poolTaskExecutor.setMaxPoolSize(10);
        poolTaskExecutor.setKeepAliveSeconds(30);
        poolTaskExecutor.setQueueCapacity(1000);
        poolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        poolTaskExecutor.initialize();
        return poolTaskExecutor;
    }
}
