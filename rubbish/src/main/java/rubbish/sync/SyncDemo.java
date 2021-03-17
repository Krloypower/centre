package rubbish.sync;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SyncDemo
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/2/24
 * @Version 1.0
 **/
public class SyncDemo implements Runnable {
    @Override
    public void run() {
        test4();
    }

    private void test1() {
        System.out.println(Thread.currentThread().getName() + "_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        // 对象锁
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + "_start_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000 * 4);
                System.out.println(Thread.currentThread().getName() + "_end_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Author ouyangkang
     * @Description 同一个对象锁  和 test1 效果一样 但是 test1 更加灵活
     * @Date 2021/3/16
     * @return: void
     **/
    private synchronized void test2() {
        System.out.println(Thread.currentThread().getName() + "_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_start_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000 * 4);
            System.out.println(Thread.currentThread().getName() + "_end_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author ouyangkang
     * @Description 类锁
     * @Date 2021/3/16
     * @return: void
     **/
    private void test3(){
        System.out.println(Thread.currentThread().getName() + "_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (SyncDemo.class){
            try {
                System.out.println(Thread.currentThread().getName() + "_start_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000 * 4);
                System.out.println(Thread.currentThread().getName() + "_end_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Author ouyangkang
     * @Description 和 test3效果一样，也是类所，但是 test3更加灵活
     * @Date 2021/3/16
     * @return: void
     **/
    private static synchronized void test4(){
        System.out.println(Thread.currentThread().getName() + "_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_start_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000 * 4);
            System.out.println(Thread.currentThread().getName() + "_end_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        Thread t1 = new Thread(new SyncDemo(), "thread1");
        Thread t2 = new Thread(new SyncDemo(), "thread2");
        Thread t3 = new Thread(syncDemo, "thread3");
        Thread t4 = new Thread(syncDemo, "thread4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
