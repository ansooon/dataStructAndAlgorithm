package concurrent.base;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-05 22:46
 */


//等待synchronized (lock)执行完后才能继续执行
public class SynchronizedDemo {
    private Object lock = new Object();

    public static void main(String[] args) {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        //线程1
        new Thread(
                () -> {
                    synDemo.myOut();
                },
                "线程1"
        ).start();
        //线程2
        new Thread(
                () -> {
                    synDemo.myOut();
                },
                "线程2"
        ).start();
    }


    public void myOut() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
