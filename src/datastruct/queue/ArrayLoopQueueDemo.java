package datastruct.queue;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-06-23 18:23
 */


public class ArrayLoopQueueDemo {

    public static void main(String[] args) {
        ArrayLoopQueue arrayLoopQueue = new ArrayLoopQueue(5);

        //添加
        arrayLoopQueue.addQueue(1);
        arrayLoopQueue.addQueue(2);
        arrayLoopQueue.addQueue(3);

        arrayLoopQueue.showQueue();

        //获取
        int n1 = arrayLoopQueue.getQueue();
        System.out.println("n = " + n1);
        arrayLoopQueue.showQueue();

        int n2 = arrayLoopQueue.getQueue();
        System.out.println("n = " + n2);
        arrayLoopQueue.showQueue();

        int n3 = arrayLoopQueue.getQueue();
        System.out.println("n = " + n3);
        arrayLoopQueue.showQueue();

        arrayLoopQueue.addQueue(4);
    }
}


class ArrayLoopQueue {

    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;


    /**
     * 创建对象的构造器
     * @param arrMaxSize
     */
    public ArrayLoopQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }


    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 添加数据到队列
     * @param n
     */
    public void addQueue(int n){
        //判断队列是否已满
        if(isFull()){
            System.out.printf("队列已满！");
            return;
        }

        rear++;
        arr[rear] = n;
    }

    /**
     * 获取队列
     * @return
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据！"); //后面不用在写代码或return
        }

        front++;
        return arr[front];
    }


    /**
     * 显示队列的所有数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.printf("队列为空，没有数据！");
            return;
        }

        for(int data: arr){
            System.out.println(data);
        }
    }

    public int headQueue(){

        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }

        return arr[front + 1];
    }
}
