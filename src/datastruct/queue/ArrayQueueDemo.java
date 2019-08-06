package datastruct.queue;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-06-23 18:23
 */


public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);

        //添加
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);

        arrayQueue.showQueue();

        //获取
        int n1 = arrayQueue.getQueue();
        System.out.println("n = " + n1);
        arrayQueue.showQueue();

        int n2 = arrayQueue.getQueue();
        System.out.println("n = " + n2);
        arrayQueue.showQueue();

        int n3 = arrayQueue.getQueue();
        System.out.println("n = " + n3);
        arrayQueue.showQueue();

        arrayQueue.addQueue(4);
    }
}




class ArrayQueue {

    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;


    /**
     * 创建对象的构造器
     * @param arrMaxSize
     */
    public ArrayQueue(int arrMaxSize){
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
