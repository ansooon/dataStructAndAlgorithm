package thread;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-21 23:43
 */
public class Actor extends Thread{

    //重写父类的方法
    public void run(){

        int count = 0;
        boolean keepRunning = true;
        System.out.println(getName() + "是一个演员");

        while (keepRunning){
            System.out.println(getName() + "登台演出" + (++count));
            if (count == 100){
                keepRunning = false;
            }

            if (count % 10 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println(getName() + "演出结束了");
    }


    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actressThread = new Thread(new Actress(), "Ms.Runnable");
        actressThread.start();
    }
}


class Actress implements Runnable{

    @Override
    public void run() {

        int count = 0;
        boolean keepRunning = true;
        System.out.println(Thread.currentThread().getName() + "是一个演员");

        while (keepRunning){
            System.out.println(Thread.currentThread().getName() + "登台演出" + (++count));
            if (count == 100){
                keepRunning = false;
            }

            if (count % 10 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println(Thread.currentThread().getName() + "演出结束了");
    }
}