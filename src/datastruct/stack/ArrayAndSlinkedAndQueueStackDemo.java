package datastruct.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-07 23:29
 */
public class ArrayAndSlinkedAndQueueStackDemo {
    public static void main(String[] args) {

        /***********************************************
         *              1，利用数组实现
         */
//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        arrayStack.push(1);
//        arrayStack.push(2);
//        arrayStack.push(3);
//        System.out.println(arrayStack.getSize());
//
//        System.out.println("取数");
//        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.pop());
//        System.out.println("取数后的stack个数为：" + arrayStack.getSize());
//        System.out.println(arrayStack.pop());


        /***********************************************
         *              2，利用链表实现
         */
//        SlinkedListStack<Integer> slinkedListStack = new SlinkedListStack<>();
//        slinkedListStack.push(1);
//        slinkedListStack.push(2);
//        slinkedListStack.push(3);
//        System.out.println(slinkedListStack.getSize());
//        System.out.println("slinkedListStack.peek():");
//        System.out.println(slinkedListStack.peek());
//        System.out.println("取数");
//        System.out.println(slinkedListStack.pop());
//        System.out.println(slinkedListStack.pop());
//        slinkedListStack.push(4);
//        System.out.println("添加后取数：");
//        System.out.println(slinkedListStack.pop());
//        System.out.println(slinkedListStack.pop());
    }
}


class ArrayStack<E>{
    private Object[] arr;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayStack(){
        arr = new Object[10];
    }

    //1判断空
    public boolean isEmpty(){
        return size == 0;
    }

    //2,添加
    public void push(E data){
        ensureCapacity(size + 1);
        arr[size++] = data; //先赋值后自增
    }

    //3-1，获取顶部数据
    public E peek(){
        if (isEmpty()){
            System.out.println("栈为空");
            return  null;
        }
        return (E)arr[size - 1];
    }

    //3-2,获取数据并置空
    public E pop(){
        E data = peek();
        arr[size - 1] = null;  //置空，为什么队列案例里不置空呢？因为当时是int类型，没必要置空成0，也无法像对象一样置空。
        size --;
        return  data;
    }


    private void ensureCapacity(int nextSize) {
        int len = arr.length;
        if (nextSize > len){
            int newLen = len + 10;
            arr = Arrays.copyOf(arr, newLen);
        }
    }
}


class SlinkedListStack<E>{
    private Node head;
    private int size;

    public int getSize(){
        return this.size;
    }

    class Node<E>{
        E data;
        Node next;

        public Node(E data){
            this.data = data;
        }
    }

    //1，增加
    public void push(E data){
        //加入头节点
        Node cur = new Node<E>(data);
        cur.next = head;
        head = cur;
        size ++;
    }

    //2,获取
    public E pop(){
        if (isEmpty()){
            System.out.println("空栈");
            return  null;
        }

        E data = (E)head.data;
        head = head.next;
        size --;
        return data;
    }


    //3，取顶部
    public E peek(){
        if (isEmpty()){
            System.out.println("空栈");
            return  null;
        }

        return (E)head.data;
    }

    //4，判断空
    public boolean isEmpty(){
        return head == null;
    }
}