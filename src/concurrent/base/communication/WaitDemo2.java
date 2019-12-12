package concurrent.base.communication;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-06 0:24
 */
public class WaitDemo2 {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Object obj = new Object();

        new Thread(() -> {
            while (!flag) {
                synchronized (obj) {
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("flag is true");
        }).start();

        new Thread(() -> {
            while (!flag) {
                synchronized (obj) {
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("flag is true");
        }).start();

        Thread.sleep(1000L);

        new Thread(() -> {
            flag = true;
            synchronized (obj) {
                obj.notifyAll();
            }
        }).start();
    }
}
