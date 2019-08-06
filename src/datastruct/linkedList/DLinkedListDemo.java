package datastruct.linkedList;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-04 0:39
 */
public class DLinkedListDemo {

}




class DLinkedList<E>{

    Node<E> head;
    Node<E> tail;
    int size = 0;

    //定义节点
    private static class Node<E> {
        E item;
        Node<E> pre;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    /**
     * 头加
     * @param item
     */
    public void add(E item) {
        Node<E> node = new Node<>(item);

        //首先针对新的node添加到头部：node.next = head
        node.pre = null;
        node.next = head;

        //因为最开始head为null，因此要分类讨论，如果head不是null，那么下一个节点指向新头节点
        if (head != null) {
            head.pre = node;
        } else {
            tail = node;
        }

        size ++;
        head = node;  //将头指针放入头部
    }


    /**
     * 通过交换指针实现链表倒置（推荐）
     */
    public void reverseBySwapPointer() {
        Node<E> temp = null;
        Node<E> current = head;
        tail = head;
        while (current != null) {
            temp = current.pre;
            current.pre = current.next;
            current.next = temp;
            current = current.pre;
        }

        if (temp != null) {
            head = temp.pre;
        }
    }

    /**
     * 通过交换数据实现链表倒置
     */
    public void reverseBySwapData() {
        Node<E> headNode = head;
        Node<E> tailNode = tail;
        while (headNode != tailNode) {
            E data = headNode.item;
            headNode.item = tailNode.item;
            tailNode.item = data;
            headNode = headNode.next;
            if (headNode == tailNode) {
                break;
            }
            tailNode = tailNode.pre;
        }
    }



    void printList() {
        Node<E> node = head;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }


    public E getFirst() {
        return head != null ? head.item : null;
    }

    public E getLast() {
        return tail != null ? tail.item : null;
    }

    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int r = size >> 1;
        if (index < (size >> 1)) {
            Node<E> node = head;
            for (int i=0; i<index; i++) {
                node = node.next;
            }
            return node != null ? node.item : null;
        } else {
            Node<E> node = tail;
            for (int i=size-1; i>index; i--) {
                node = node.pre;
            }
            return node != null ? node.item : null;
        }
    }

    public static void main(String[] args) {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);       //后进先出
        list.printList();

        System.out.println(list.get(0));
//        list.reverseBySwapPointer();
//        System.out.println(list.head.item);
//        System.out.println(list.tail.item);
//        list.printList();
//        list.reverseBySwapData();
//        System.out.println(list.head.item);
//        System.out.println(list.tail.item);
//        list.printList();
    }
}