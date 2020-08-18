package rubbish.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Reentrenttest
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-05 17:18
 **/
public class Reentrenttest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static ExecutorService executor = Executors.newFixedThreadPool(10);


    public static void main(String[] args) {

        executor.execute(()->{
            lock.lock();
            try {
                System.out.println("rubbish.lock before");
                System.out.println("rubbish.lock reentrant await before size=" + lock.getHoldCount());
                condition.await();
                System.out.println("rubbish.lock reentrant await after size=" + lock.getHoldCount());
                System.out.println("condition.await after");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });


        executor.execute(()->{
            lock.lock();
            try {
                System.out.println("lock1 before");
                System.out.println("lock1 reentrant signal before size=" + lock.getHoldCount());
                condition.signal();
                System.out.println("lock1 reentrant signal after size=" + lock.getHoldCount());
                System.out.println("condition.signal after");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
    }
}
