package concurrent.base.communication;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-06 0:30
 */
public class JoinDemo {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束运行");
        }, "线程1");  //此处没有start，而在另外一个线程中启动

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            thread.start(); //在这里开始运行
            try {
                thread.join(); //等待另外一个线程结束再继续
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }, "线程2").start();
    }
}
