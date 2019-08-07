package datastruct.queue;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-06-23 18:23
 */


public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(1 + 3);

        circleArrayQueue.addQueue(1);
        circleArrayQueue.addQueue(2);
        circleArrayQueue.addQueue(3);
        circleArrayQueue.showQueue();

        System.out.println(circleArrayQueue.getHeadQueue());

        System.out.println(circleArrayQueue.getQueue());
        circleArrayQueue.showQueue();
    }
}


class CircleArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;


    /**
     * 创建对象的构造器
     * @param arrMaxSize
     */
    public CircleArrayQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = 0;  //指向队列第一个元素
        this.rear = 0;  //指向队列最后一个元素的下一个位置
    }

    /**
     * 1,判断是否满
     * @return
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }


    /**
     *2,判断队列是否空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 3,添加数据到队列
     * @param n
     */
    public void addQueue(int n){
        //判断队列是否已满
        if(isFull()){
            System.out.printf("队列已满！");
            return;
        }

        //直接将数据加入
        arr[rear] = n;
        //将rear后移，必须考虑循环（取模）
        rear = (rear + 1) % maxSize;  //已经循环
    }


    /**
     *4，获取队列
     * @return
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据！"); //后面不用在写代码或return
        }

        //这里的front需指向队列的第一个元素
        //1，先把front对应的值保留到一个临时变量
        //2，将front后移，考虑循环取模
        //3，将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize; //已经循环
        return value;
    }

    /**
     *,5，显示队列的所有数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
            return;
        }

        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + getSize(); i++) {
            System.out.println(arr[i % maxSize]);  //注意哈，变量一定要循环
        }
    }

    /**
     * 求出当前队列的有效个数
     * @return
     */
    public int getSize(){
        return (rear + maxSize - front) % maxSize;
    }

    public int getHeadQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }

        return arr[front];  //front已经循环
    }
}
