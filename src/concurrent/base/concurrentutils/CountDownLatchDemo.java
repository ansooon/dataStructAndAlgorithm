package concurrent.base.utils;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-05 22:38
 */


import java.util.concurrent.CountDownLatch;

/**
 * 该类主要是用来数组，等待所有线程就位后再一起执行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDown = new CountDownLatch(1);
        CountDownLatch await = new CountDownLatch(5);

        // 依次创建并启动处于等待状态的5个MyRunnable线程
        for (int i = 0; i < 5; ++i) {
            new Thread(new MyRunnable(countDown, await)).start();
        }

        System.out.println("用于触发处于等待状态的线程开始工作......");
        System.out.println("用于触发处于等待状态的线程工作完成，等待状态线程开始工作......");
        countDown.countDown(); //减1，此时countDown ==0, 子线程开始工作！
        await.await();  //等待5子线程完成工作！每个子线程减1
        System.out.println("Bingo!");
    }

}


class MyRunnable implements Runnable {

    private final CountDownLatch countDown;
    private final CountDownLatch await;

    public MyRunnable(CountDownLatch countDown, CountDownLatch await) {
        this.countDown = countDown;
        this.await = await;
    }

    public void run() {
        try {
            countDown.await();//等待主线程执行完毕，获得开始执行信号...
            System.out.println("处于等待的线程开始自己预期工作......");
            await.countDown();//完成预期工作，发出完成信号...//每个子线程减1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
