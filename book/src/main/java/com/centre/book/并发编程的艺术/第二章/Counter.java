package com.centre.book.并发编程的艺术.第二章;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Counter
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/3/8
 * @Version 1.0
 **/
public class Counter {
    private int i = 0;

    private AtomicInteger toc = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        Counter counter = new Counter();
        long millis = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    counter.safeCount();
                    counter.notSafe();
                }
            });
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("time=" + (System.currentTimeMillis() - millis));
        System.out.println("i=" + counter.i);
        System.out.println("toc=" + counter.toc.get());
    }


    private void notSafe() {
        i++;
    }


    private void safeCount() {
        while (true) {
            int i = toc.get();
            boolean b = toc.compareAndSet(i, ++i);
            if (b) {
                break;
            }
        }
    }

}
