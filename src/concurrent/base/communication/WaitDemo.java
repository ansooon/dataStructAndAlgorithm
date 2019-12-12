package concurrent.base.communication;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-05 23:59
 */
public class WaitDemo implements Runnable{
    private static Object waitObj = new Object();

    @Override
    public void run() {
        //持有资源
        synchronized (waitObj) {
            System.out.println(Thread.currentThread().getName()+"占用资源");
            try {
                waitObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"释放资源");
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new WaitDemo(),"对比线程");
        thread.start();

        Thread thread2 = new Thread(new WaitDemo(),"对比线程2");
        thread2.start();
        Thread.sleep(3000L);

        //两个线程都执行到wait方法之前，直到notify才会继续

        synchronized (waitObj) {
            waitObj.notify();
        }

    }
}
