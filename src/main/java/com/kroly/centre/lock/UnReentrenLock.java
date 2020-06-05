package com.kroly.centre.lock;

/**
 * @ClassName UnReentrenLock
 * @Description 不可重入锁
 * @Author kang.ouyang
 * @Date 2020-06-05 11:11
 **/
public class UnReentrenLock {

    private boolean isLock;

    public synchronized void lock() throws InterruptedException {
        if (isLock) {
            wait();
        }
        isLock = true;
    }

    public synchronized void unlock() {
        isLock = false;
        notify();
    }
}
