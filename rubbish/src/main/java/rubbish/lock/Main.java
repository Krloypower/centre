package rubbish.lock;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Main
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-05 10:52
 **/
public class Main {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 60, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadFactoryMain("kang"));
//    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    private static ReentrentLock lock = new ReentrentLock();
    private static UnReentrenLock ulock = new UnReentrenLock();

    public static int i = 0;


    static class ThreadFactoryMain implements ThreadFactory {
        private String name;

        private final static AtomicInteger num = new AtomicInteger();

        public ThreadFactoryMain(String name) {
            this.name = name;
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, name + num.getAndIncrement());
        }
    }

    public static void main(String[] args) {

        executor.prestartAllCoreThreads();
        executor.execute(() -> {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(i);

        Thread thread = new Thread(new ThreadLock());
        thread.start();
    }

    public static void utest() throws InterruptedException {
        ulock.lock();
        i++;
        System.out.println(i);
        uget();
        ulock.unlock();
    }

    public static void uget() throws InterruptedException {
        ulock.lock();
        i *= 2;
        System.out.println(i);
        ulock.unlock();

    }


    public static void test() throws InterruptedException {
        lock.lock();
        i++;
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(i);
        get();
        lock.unlock();
    }

    public static void get() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getThreadGroup());

        i *= 2;
        System.out.println(i);
        lock.unlock();

    }
}
