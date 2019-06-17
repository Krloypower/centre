package com.kroly.centre.httppool;

import javafx.concurrent.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName ThreadPoolTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-14 16:17
 **/
public class ThreadPoolTest {

    private final static AtomicInteger FINSH = new AtomicInteger(0);

    private final static AtomicLong COST = new AtomicLong(0);

    private final static Integer TASK_COUNT = 1000;

    private final static Long TASK = 1000000L;

    @Test
    public void thread(){
        List<Thread> list = new ArrayList<>(TASK_COUNT);
        for (int i = 0 ; i < TASK_COUNT; i++){
            list.add(new Thread(new IncreaseThread()));
        }
        for (Thread t : list){
            t.start();
        }

        for (;;);
    }

    @Test
    public void threadPool(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,100,0, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        for (int i = 0; i < TASK_COUNT; i++){
            executor.submit(new IncreaseThread());
        }
        for (;;);
    }

    private class IncreaseThread implements Runnable{

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();

            AtomicInteger counter = new AtomicInteger();
            for (int i = 0 ; i < TASK; i++){
                counter.incrementAndGet();
            }

            COST.addAndGet(System.currentTimeMillis() - startTime);
            if (FINSH.incrementAndGet() == TASK_COUNT){
                System.out.println("cost: " + COST.get() + "ms");
            }
        }
    }
}
