package multithread;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-10-19 15:27
 */
public class CreateDemo {

    public static void main(String[] args) {
        //方式1
        Thread myThreadByTread = new MyThreadByTread();
        myThreadByTread.setName("线程demo1");
        myThreadByTread.start();

        //方式2
        Thread myThreadByRunnable = new Thread(new MyThreadByRunnable());
        myThreadByRunnable.setName("线程demo2");
        myThreadByRunnable.start();
        myThreadByRunnable.run(); //没有启动线程，还在在主线程里调用run方法，注意！

        //方法3，还可以使用匿名内部类，通过创建抽象类或者接口实现！
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("start by inner abstract class1!");
            }
        }; //是一条语句，因此要加;
        thread1.start();


        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("start by inner abstract class2!");
            }
        });
        thread2.start();


        //方法4，
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();


        //方法5，使用线程池。运行之后程序还没有结束，还可以进行其他操作
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }

}


//方式1
class MyThreadByTread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

//方式2
class MyThreadByRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
