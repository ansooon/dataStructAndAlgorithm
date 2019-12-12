package concurrent.base;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-06 0:21
 */
public class VolatileDemo {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!flag) {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("flag is false");
            }

            System.out.println("flag is true");
        }).start();

        Thread.sleep(3000L);

        //开关
        new Thread(() -> {
            flag = true;
        }).start();
    }
}
