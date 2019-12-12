package concurrent.base.SingletonDemo;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-05 22:52
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton(){};


    public static LazySingleton getInstance(){

//        if (null == lazySingleton){
//            lazySingleton = new LazySingleton();  //实例化需要一定的时间，此时可能会线程不安全
//        }


        if (null == lazySingleton){  //为日后进行选择
            //此时可能有多个锁进来了，且都认为lazySingleton为空，下一步还要判断是否为空！双重判断！
            synchronized(LazySingleton.class){
                if(null == lazySingleton){  //针对当前多个认为且都认为lazySingleton == null的线程进行选择
                    lazySingleton = new LazySingleton();  //实例化需要一定的时间，此时可能会线程不安全，synchronized之
                }

            }
        }

        return lazySingleton;
    }
}
