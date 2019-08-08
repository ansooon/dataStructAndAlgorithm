package datastruct.queue;



import java.util.Stack;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-06-23 18:23
 */

/**
 * 测试类
 */
public class ArrayAndSlinkedListAndStackQueueDemo {

    public static void main(String[] args) {
        /**************************************************
         *                1，非循环数组实现
         */
//        ArrayQueue arrayQueue = new ArrayQueue(5);
//
//        //添加
//        arrayQueue.addQueue(1);
//        arrayQueue.addQueue(2);
//        arrayQueue.addQueue(3);
//
//        arrayQueue.showQueue();
//
//        //获取
//        int n1 = arrayQueue.getQueue();
//        System.out.println("n = " + n1);
//        arrayQueue.showQueue();
//
//        int n2 = arrayQueue.getQueue();
//        System.out.println("n = " + n2);
//        arrayQueue.showQueue();
//
//        int n3 = arrayQueue.getQueue();
//        System.out.println("n = " + n3);
//        arrayQueue.showQueue();
//
//        arrayQueue.addQueue(4);
//        arrayQueue.showQueue();
//
//        arrayQueue.addQueue(5);
//        arrayQueue.showQueue();
//
//        arrayQueue.addQueue(6); //队列已满
//        arrayQueue.showQueue();
//
//        System.out.println(arrayQueue.getHeadQueue());
//        System.out.println(arrayQueue.getTailQueue());


        /**************************************************
         *                2，循环数组实现
         */
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(1 + 5);

        circleArrayQueue.addQueue(1);
        circleArrayQueue.addQueue(2);
        circleArrayQueue.addQueue(3);
        circleArrayQueue.addQueue(4);
        circleArrayQueue.addQueue(5);
        circleArrayQueue.showQueue();

//        System.out.println(circleArrayQueue.getHeadQueue());


        System.out.println("取节点");
        System.out.println(circleArrayQueue.getQueue());
        System.out.println(circleArrayQueue.getQueue());
        System.out.println(circleArrayQueue.getQueue());
        System.out.println("取节点后打印节点");
        circleArrayQueue.showQueue();


        circleArrayQueue.addQueue(6);
        circleArrayQueue.addQueue(7);
        circleArrayQueue.addQueue(8);
        System.out.println("添加节点后展示节点");
        circleArrayQueue.showQueue();



        /**************************************************
         *                3，链表实现
         */

//        SLinkQueue sLinkQueue = new SLinkQueue(5);

        //方法1，添加
//        sLinkQueue.addQueue(1);
//        sLinkQueue.addQueue(2);
//        sLinkQueue.addQueue(3);
//        sLinkQueue.addQueue(4);
//        sLinkQueue.addQueue(5);
//        sLinkQueue.showQueue();
//
//        //方法2，获取
//        System.out.println("获取队列");
//        System.out.println(sLinkQueue.getQueue());
//        System.out.println(sLinkQueue.getQueue());
//        System.out.println(sLinkQueue.getQueue());
//        System.out.println(sLinkQueue.getQueue());
//        System.out.println(sLinkQueue.getQueue()); //5
//        sLinkQueue.addQueue(1);
//        System.out.println(sLinkQueue.getQueue());
//        sLinkQueue.addQueue(2);
//        System.out.println(sLinkQueue.getQueue());
//        System.out.println(sLinkQueue.getLinkedListSize());
//        //重新添加队列
//        sLinkQueue.addQueue(1);
//        sLinkQueue.addQueue(2);
//        sLinkQueue.addQueue(3);
//        sLinkQueue.addQueue(4);
//        sLinkQueue.addQueue(5);
//        System.out.println("展示列表");
//        sLinkQueue.showQueue();
//        System.out.println(sLinkQueue.getLinkedListSize());
//        //获取头部数据
//        System.out.println("获取头部数据");
//        System.out.println(sLinkQueue.getHeadQueue());
//        System.out.println("取数");
//        System.out.println(sLinkQueue.getQueue());
//        System.out.println("获取头部数据");
//        System.out.println(sLinkQueue.getHeadQueue());
//        System.out.println("展示数据");
//        sLinkQueue.showQueue();


        /**************************************************
         *                4，双栈实现
         */

//        StackQueue<Integer> stackQueue = new StackQueue<>();
//        //1，添加
//        stackQueue.addQueue(1);
//        stackQueue.addQueue(2);
//        stackQueue.addQueue(3);
//        stackQueue.showQueue();

        //2，获取
//        System.out.println("取数");
//        System.out.println(stackQueue.getQueue());
//        System.out.println(stackQueue.getQueue());
//        System.out.println(stackQueue.getQueue());
//        System.out.println(stackQueue.getQueue());
//        System.out.println("取数后展示");
//        stackQueue.showQueue();

    }
}


/**
 * 1，数组实现队列
 * 主要功能为添加，获取：先进先出，因此添加时应该是最先进的牌最前面。利用单链表实现，末尾添加，取头部。
 */
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
        this.front = -1; //指向前面一个数的地址的前端
        this.rear = -1;  //指向最后一个数的地址
    }

    /**
     * 1，判断是否已满
     * @return
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }


    /**
     * 2，判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     *,3，添加数据到队列
     * @param n
     */
    public void addQueue(int n){
        //判断队列是否已满
        if(isFull()){
            System.out.println("队列已满！");
            return;
        }

        rear++;
        arr[rear] = n;
    }

    /**
     *4-1，获取队列
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
     * 4-2，获取队列的头节点
     * @return
     */
    public int getHeadQueue(){

        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }

        return arr[front + 1];
    }

    /**
     * 4-2，获取队列的头节点
     * @return
     */
    public int getTailQueue(){

        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }

        return arr[rear];
    }

    /**
     *,5，显示队列的所有数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
            return;
        }

        for(int data: arr){
            System.out.println(data);
        }
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
    public boolean isFull(){  //因为front在取值时其值被循环，故而其值不会很大。但是因为rear在添加时，先做满判断，因此其值在判断满环节中没有被循环
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
        int nums = getSize();
        for (int i = front; i < front + nums; i++) {
            System.out.println(arr[i % maxSize]);  //注意哈，变量一定要循环
        }
    }

    /**
     * 求出当前队列的有效个数
     * @return
     */
    public int getSize(){
        return (rear + maxSize - front) % maxSize;  //貌似不需要循环取模了，因为所有的操作变量都取模过了
    }

    public int getHeadQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }

        return arr[front];  //front已经循环
    }
}


/**
 *3，单链表实现队列
 */
class SLinkQueue{
    private int maxSize;
    private SLinkedList sLinkedList;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public SLinkQueue(int maxSize){
        this.maxSize = maxSize;
        this.sLinkedList = new SLinkedList(maxSize); //初始化内部链表类
    }


    public int getLinkedListSize(){
        return  sLinkedList.getSize();
    }

    public boolean isFull(){
        return sLinkedList.isFull();
    }

    public boolean isEmpty(){
        return sLinkedList.isEmpty();
    }


    //1,添加
    public void addQueue (int data){
       if (isFull()){
           System.out.println("队列已满");
           return;
       }

        sLinkedList.addTail(data);
    }

    //2,获取
    public int getQueue (){
       if (isEmpty()){
           System.out.println("队列为空");
           return -1;
       }

        return sLinkedList.getHeadAndRemoveNode().data;
    }

    //3,不删除获取头数据
    public int getHeadQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return -1;
        }

        return sLinkedList.getHeadNode().data;
    }


    //4,列出数据
    public void showQueue(){
        if (sLinkedList.isEmpty()){
            System.out.println("链表为空");
            return;
        }
        sLinkedList.print();

    }


    /**
     * 内部链表类
     */
    class SLinkedList{

        private Node head = null;
        private int size = 0;
        private int maxSize;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(int maxSize) {
            this.maxSize = maxSize;
        }

        public SLinkedList(int maxSize){
            this.maxSize = maxSize;
        }

        class Node{
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data=" + data +
                        '}';
            }
        }




        //1,向尾部添加
        public void addTail(int data){

            Node cur = head;
            if (head == null){
                cur = new Node(data);
                head = cur;
                size++;
            }else{
                while (cur.next != null){
                    cur = cur.next;
                }
                cur.next = new Node(data);
                size++;
            }
        }


        //2,获取头部数据且删除头部数据
        public Node getHeadAndRemoveNode(){
            if(head == null){
                return null;
            }

            Node cur = head;
            head = head.next;
            size --;
            return cur;
        }


        //3,获取头部节点
        public Node getHeadNode(){
            if (head == null){
                System.out.println("链表为空");
                return null;
            }

            return head;

        }

        //4，打印
        public void print(){
            if (head == null){
                System.out.println("链表为空");
                return;
            }
            Node cur = head;
            while (cur != null){
                System.out.println(cur.data);
                cur = cur.next;
            }
        }

        //5，满判断
        public boolean isFull(){
            return size == maxSize;
        }

        //空判断
        public boolean isEmpty(){
            return head == null;
        }
    }

}


/**
 *4， 双栈实现队列
 * @param <E>
 */
class StackQueue<E>{
    private Stack<E> stackAdd  = new Stack<>();
    private Stack<E> stackGet  = new Stack<>();

    //1，存操作。没有满判断，也暂时无法展示所有队列节点信息
     public synchronized void addQueue(E data){
        stackAdd.push(data);
    }

    //2，取操作
    public synchronized E getQueue() {

        if (isEmpty()) {
            System.out.println("队列为空");
            return  null;
        }

        if (stackGet.isEmpty()) {  //如果只有一个if，那么不加else也可以
            while (!stackAdd.isEmpty()){
                stackGet.push(stackAdd.pop());
            }
        }

        return stackGet.pop();
    }


    //3判断为空
    public synchronized boolean isEmpty(){
        return stackAdd.isEmpty() && stackGet.isEmpty();
    }

}
