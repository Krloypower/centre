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
        test1();
    }

    private void test1() {
        System.out.println(Thread.currentThread().getName() + "_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName() + "_start_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000 * 4);
                System.out.println(Thread.currentThread().getName() + "_end_: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
