package rubbish.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName Mutex
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-08 10:15
 **/
public class Mutex implements Lock {

    private static class Sycn extends AbstractQueuedSynchronizer {

        private static final long serialVersionUID = -4387327721959839431L;

        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 0;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        Condition newCondition() {
            return new ConditionObject();
        }

    }

    private final Sycn sycn = new Sycn();

    @Override
    public void lock() {
        sycn.acquire(1);
    }

    @Override
    public boolean tryLock() {
        return sycn.tryAcquire(1);
    }

    @Override
    public void unlock() {
        sycn.release(1);
    }

    @Override
    public Condition newCondition() {
        return sycn.newCondition();
    }

    public boolean isLocked(){
        return sycn.isHeldExclusively();
    }

    public boolean hasQueueThreads(){
        return sycn.hasQueuedThreads();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sycn.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sycn.tryAcquireNanos(1, unit.toNanos(time));
    }

}
