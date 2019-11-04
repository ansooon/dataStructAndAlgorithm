package datastruct.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-07 23:29
 */

/**
 * 测试类
 * 规范：栈存数据时用push，取数据时用pop，取顶数时用peek；
 * 链表list存数据用add，取数据用get；
 * 队列存数据用add，取数据用poll
 *
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

        /***********************************************
         *              3，利用双队列
         */
        QueueStack<Integer> queueStack = new QueueStack<>();
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);
        System.out.println(queueStack.peek());

        System.out.println("取出");
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());

        System.out.println("加入后取出");
        queueStack.push(4);
        queueStack.push(5);
        queueStack.push(6);
        System.out.println(queueStack.peek());
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());
    }
}


/**
 * 1，数组实现栈。
 * 原理:申请一个数组，每次添加时向尾部添加，添加数据之前，先判断是否扩容，且=
 *
 * @param <E>
 */
class ArrayStack<E> {
    private Object[] arr;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayStack() {
        arr = new Object[10];
    }

    //1判断空
    public boolean isEmpty() {
        return size == 0;
    }

    //2,添加
    public void push(E data) {
        ensureCapacity(size + 1);
        arr[size++] = data; //先赋值后自增
    }

    //3-1，获取顶部数据
    public E peek() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        return (E) arr[size - 1];
    }

    //3-2，获取数据并置空
    public E pop() {
        E data = peek();
        arr[size - 1] = null;  //置空，为什么队列案例里不置空呢？因为当时是int类型，没必要置空成0，也无法像对象一样置空。
        size--;
        return data;
    }


    private void ensureCapacity(int nextSize) {
        int len = arr.length;
        if (nextSize > len) {
            int newLen = len + 10;
            arr = Arrays.copyOf(arr, newLen);  //新方法要记一下
        }
    }
}


/**
 * 2，单链表实现栈
 * 原理：添加时向头部添加
 *
 * @param <E>
 */
class SlinkedListStack<E> {
    private Node head;
    private int size;

    public int getSize() {
        return this.size;
    }

    class Node<E> {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    //1，增加
    public void push(E data) {
        //加入头节点
        Node cur = new Node<E>(data);
        cur.next = head;
        head = cur;
        size++;
    }

    //2,获取
    public E pop() {
        if (isEmpty()) {
            System.out.println("空栈");
            return null;
        }

        E data = (E) head.data;
        head = head.next;
        size--;
        return data;
    }


    //3，取顶部
    public E peek() {
        if (isEmpty()) {
            System.out.println("空栈");
            return null;
        }

        return (E) head.data;
    }

    //4，判断空
    public boolean isEmpty() {
        return head == null;
    }
}


/**
 * 3，双队列实现栈
 * 原理：添加数据时，向存在数据的队列添加，保证另外一个队列为空；取数时，存队列依次取数数据存放到空队列，直到取到最后一个数时，将数取出。
 *
 * @param <E>
 */
class QueueStack<E> {
    Queue<E> queue1 = new ArrayDeque<>();
    Queue<E> queue2 = new ArrayDeque<>();

    /*
     * 1,向栈中压入数据
     */
    public void push(E data) {
        //两个队列都为空时，优先考虑 queue1
        if (isEmpty()) {
            queue1.add(data);
            return;
        }

        //如果queue1为空，queue2有数据，直接放入queue2
        if (queue1.isEmpty()) {
            queue2.add(data);
            return;
        }

        //如果queue2为空，queue1有数据，直接放入queue1中
        if (queue2.isEmpty()) {
            queue1.add(data);
            return;
        }
    }


    /*
     * 2 从栈中弹出一个数据
     */
    public E pop() {
        //如果两个栈都为空，则没有元素可以弹出，异常
        if (isEmpty()) {
            try {
                throw new Exception("satck is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //如果queue1中没有元素，queue2中有元素，将其queue2中的元素依次放入queue1中，直到最后一个元素，弹出即可
        // （队列是先进先出，“通孔”，而栈则属于“盲孔”）
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return (E) queue2.poll();
        }

        //如果queue2中没有元素，queue1中有元素，将其queue1中的元素依次放入queue2中，直到最后一个元素，弹出即可
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return (E) queue1.poll();
        }

        return null;
    }

    /*
     * 3 弹出栈顶数据（注意数据还存在栈中）
     */
    public E peek() {
        //如果两个栈都为空，则没有元素可以弹出，异常
        if (isEmpty()) {
            try {
                throw new Exception("satck is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        E peekData = null;
        //如果queue1中没有元素，queue2中有元素，将其queue2中的元素依次放入queue1中，直到最后一个元素，弹出即可
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            peekData = queue2.poll();
            queue1.add(peekData);
        }

        //如果queue2中没有元素，queue1中有元素，将其queue1中的元素依次放入queue2中，直到最后一个元素，弹出即可
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            peekData = queue1.poll();
            queue2.add(peekData); //重新将元素放回去
        }

        return peekData;
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}