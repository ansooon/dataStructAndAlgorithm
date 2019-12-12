package concurrent.base.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-06 1:10
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000L);
        return "1111";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo callableDemo = new CallableDemo();

        FutureTask<String> stringFutureTask = new FutureTask<>(callableDemo); //实现了runnable

        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());
    }
}
