package algorithm;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-08 16:03
 */
public class recursiveAlgorithm {

    public static void main(String[] args) {

        //1
//        Test t= new Test();
//        t.test(4);

        //2
//        Factorial factorial = new Factorial();
//        int res = factorial.factorial(3);
//        System.out.println(res);

        FiBoNaqiNum fiBoNaqiNum = new FiBoNaqiNum();
        int n = fiBoNaqiNum.fib(5);
        System.out.println(n);
    }
}

/**
 * 1
 */
class Test{
    public void test(int n){
        System.out.println("n前 = " + n);
        if(n > 2){
            test(n - 1);  //被调用的地方的上部分已经执行，而后部分没有被执行
        }

        System.out.println("n后 = " + n);
//        输出：
//        n前 = 4
//        n前 = 3
//        n前 = 2
//        n后 = 2
//        n后 = 3
//        n后 = 4

        //*******************************

//        System.out.println("n前 = " + n);
//        if(n > 2){
//            test(n - 1);  //被调用的地方的上部分已经执行，而后部分没有被执行
//        }else{
//            System.out.println("n后 = " + n);
//        }
//        输出：
//        n前 = 4
//        n前 = 3
//        n前 = 2
//        n后 = 2
    }
}

/**
 * 2
 */
class Factorial{

    public int factorial(int n){
        if (n == 1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
}



class FiBoNaqiNum{

    public int fib(int n){
        if(n == 1 || n == 0){
            return 1;
        }else{
            return fib(n - 2) + fib(n - 1);
        }

    }
}