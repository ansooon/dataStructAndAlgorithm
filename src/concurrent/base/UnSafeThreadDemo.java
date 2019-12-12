package concurrent.base;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-05 22:23
 */
public class UnSafeThreadDemo {

    private static int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    /**
     * 每次调用对num进行++操作
     */
    public static void inCreate() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //每个线程执行完成之后，调用countdownLatch
                countDownLatch.countDown();
            }).start();
        }


//        while (true) {
//            //等待10个线程完成之后再打印总数
//            if (countDownLatch.getCount() == 0) {
//                System.out.println(num);
//                break;
//            }
//        }

        countDownLatch.await();
        System.out.println(num);

    }
}


