package rubbish.lock;

/**
 * @ClassName ThreadLock
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-05 10:45
 **/
public class ThreadLock implements Runnable {

    private ReentrentLock lock = new ReentrentLock();

    public void test() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread() + "test");
            get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread() + "get");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        test();
    }
}
