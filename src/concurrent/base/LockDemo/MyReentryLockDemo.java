package concurrent.base.LockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-05 23:09
 */


public class ReentryLockDemo {

    public Lock lock = new MyLock();

    public void methodA() {
        lock.lock();
        System.out.println("进入方法A");
        methodB();
        lock.unlock();
    }

    public void methodB() {
        lock.lock();
        System.out.println("进入方法B");
        lock.unlock();
    }


    public static void main(String[] args) {
        ReentryLockDemo reentryDemo = new ReentryLockDemo();
        reentryDemo.methodA();
    }

}


class MyLock implements Lock {
    private boolean isHoldLock;
    private Thread holdLockThread = null;
    private int reentryCount = 0;

    @Override
    public void lock() {
        if (isHoldLock && Thread.currentThread() != holdLockThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        holdLockThread = Thread.currentThread();  //获取当前对象
        isHoldLock = true;  //标记已经持有锁
        reentryCount++;
    }


    @Override
    public void unlock() {
        //判断当前线程是否是持有锁的线程，是，重入次数减去1，不是就不做处理
        if (Thread.currentThread() == holdLockThread) {
            reentryCount--;
            if (reentryCount == 0) {
                notify();
                isHoldLock = false;
            }
        }
    }









    

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
