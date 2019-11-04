package multithread;

import java.io.IOException;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-10-19 15:04
 */
public class StateDemo {

    public static void main(String[] args) throws InterruptedException {

//        //1,运行
//        Thread thread = new Thread(() -> {
//            try {
//                System.in.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//
//        thread.run();


        //超时等待，阻塞
        Object obj = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized(obj){
                try {
                    Thread.sleep(10000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();

        Thread.sleep(1000L);


        Thread thread2 = new Thread(() -> {
            synchronized(obj){}
        });

        thread2.start();
    }

}
