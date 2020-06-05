package com.kroly.centre.lock;

/**
 * @ClassName ReentrentLock
 * @Description 可重入锁
 * @Author kang.ouyang
 * @Date 2020-06-05 10:35
 **/
public class ReentrentLock {

    private Thread current;

    private int count;

    private boolean isLock;

    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();

        if (isLock && current != thread){
            wait();
        }
        isLock = true;
        current = thread;
        count ++;
    }

    public synchronized  void unlock(){
        Thread thread = Thread.currentThread();
        if (current == thread){
            count--;
            if (count == 0){
                isLock = false;
                notify();
            }
        }
    }

}
