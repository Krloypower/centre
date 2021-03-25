package com.centre.book.并发编程的艺术.第三章;

import java.util.concurrent.locks.ReentrantLock;


/**
 * @ClassName ReentrantLockDemo
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/3/18
 * @Version 1.0
 **/
public class ReentrantLockDemo {

    private int i = 0;
    ReentrantLock lock = new ReentrantLock();

    public void write() {
        i++;
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }

    public void read() {
        lock.lock();
        try {
            int a = i;
            System.out.println(a);
        } finally {
            lock.unlock();
        }
    }

}
