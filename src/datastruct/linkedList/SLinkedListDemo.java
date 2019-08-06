package datastruct.linkedList;

import java.util.List;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-05 21:08
 */
public class SLinkedListDemo {

    public static void main(String[] args) {

        SLinkedList sLinkedList = new SLinkedList();

        //方法1-1，尾部添加
        sLinkedList.addTail(1);
        sLinkedList.addTail(2);
        sLinkedList.addTail(3);
        sLinkedList.addTail(4);
        sLinkedList.addTail(5);
        sLinkedList.addTail(6);
        sLinkedList.addTail(7);
//        sLinkedList.printNodeData(sLinkedList.head);

        //方法1-2，头部添加
//        sLinkedList.addHead(1);
//        sLinkedList.addHead(2);
//        sLinkedList.addHead(3);
//        sLinkedList.addHead(4);
//        sLinkedList.addHead(5);
//        sLinkedList.addHead(6);
//        sLinkedList.printNodeData(sLinkedList.head);

        //方法2，获取长度
//        System.out.println(sLinkedList.getLength());
//        System.out.println(sLinkedList.size);

        //方法3-1,按顺序获取第k个节点
//        System.out.println(sLinkedList.findNode(6).toString());
        //方法3-2，按倒数获取第k个节点
//        System.out.println(sLinkedList.findLastNode(1));
        //方法3-3，按倒数获取第k个节点
//        System.out.println(sLinkedList.findLastNode(sLinkedList.head,2));
        //方法3-4，按倒数获取第k个节点
//        System.out.println(sLinkedList.findMiddleNode()); //123456，取4

        //方法6，合并有序链表
//        SLinkedList sLinkedList1 = new SLinkedList();
//        SLinkedList sLinkedList2 = new SLinkedList();
//        SLinkedList mergeSLinkedList = new SLinkedList();
//        sLinkedList1.addTail(1);
//        sLinkedList1.addTail(3);
//        sLinkedList1.addTail(5);
//        sLinkedList1.addTail(7);
//
//        sLinkedList2.addTail(2);
//        sLinkedList2.addTail(4);
//        sLinkedList2.addTail(5);
//        sLinkedList2.addTail(7);
//        sLinkedList2.addTail(8);
//        sLinkedList2.addTail(10);
//
//        mergeSLinkedList.mergeLinkedList(sLinkedList1, sLinkedList2);
//        mergeSLinkedList.printNodeData(mergeSLinkedList.head);

        //方法7，反转链表
//        sLinkedList.reverseLinkedList();
//        sLinkedList.printNodeData(sLinkedList.head);

        //方法8，判断链表是否有环
        sLinkedList.addTail(sLinkedList.head);
        System.out.println(sLinkedList.hasCycle());





    }



}


class SLinkedList{
    public Node head;
    public Node current;  //在多线程环境中可能会出问题
    int size;


    class Node{
        int data;    //数据域
        Node next;   //指针域

        public Node(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }


    //打印
    public void printNodeData(Node node){
        if (node == null){
            return;
        }

        current = node;
        while(current != null){
            System.out.println(current.data); //sout
            current = current.next; //结论1：current=null时退出循环，因此条件写的是current != null，迭代条件放在末尾
        }
    }

    //方法1-1,向尾部添加数据(注意不是添加节点)
    public void addTail(int data){ //注意，这里既可以定义添加Node节点，也可以定义添加数据域，现实中应该是添加数据域，然后再对Node进行初始化。
        //判断链表为空的时候
        if (head == null){ //如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = new Node(data);
            current = head;


        }else{
            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
            current.next = new Node(data);
            //把链表的当前索引向后移动一位
            current = current.next; //此步操作完成之后，current结点指向新添加的那个结点，即尾节点
            size ++;
        }
    }

    //方法1-1,向尾部添加数据(注意不是添加节点)
    public void addTail(Node node){ //注意，这里既可以定义添加Node节点，也可以定义添加数据域，现实中应该是添加数据域，然后再对Node进行初始化。
        if (node == null){
            return;
        }
        //判断链表为空的时候
        if (head == null){ //如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = node;
            current = head;
            size ++;
        }else{
            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
            current.next = node;
            //把链表的当前索引向后移动一位
            current = current.next; //此步操作完成之后，current结点指向新添加的那个结点，即尾节点
            size ++;
        }
    }

    //方法1-2,向头部添加数据(注意不是添加节点)
    public void addHead(int data){ //注意，这里既可以定义添加Node节点，也可以定义添加数据域，现实中应该是添加数据域，然后再对Node进行初始化。
        //判断链表为空的时候
        if (head == null){ //如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = new Node(data);
            current = head;
            size ++;
        }else{
            current = new Node(data);
            //将新节点关联下一个节点(此处为头节点，和带头节点的链表不太一样)
            current.next = head;
            //将头节点关联新节点
            head = current; //此步操作完成之后，current结点指向新添加的那个结点，即尾节点
            //相同点，都遵循从右到左（从当前新节点开始）,先完成当前新节点的指向，再完成前节点的指向
            //不同点，无头节点的链表的head即指向第一个节点，它伴随着第一个数据实体的初始化而初始化
            size ++;
        }
    }

//    上方代码中，这里面的Node节点采用的是内部类来表示（33行）。使用内部类的最大好处是可以和外部类进行私有操作的互相访问。
//    注：内部类访问的特点是：内部类可以直接访问外部类的成员，包括私有；外部类要访问内部类的成员，必须先创建对象。
//    为了方便添加和遍历的操作，在LinkList类中添加一个成员变量current，用来表示当前节点的索引（03行）。
//    这里面的遍历链表的方法（20行）中，参数node表示从node节点开始遍历，不一定要从head节点遍历。

    //方法2：获取单链表的长度
    public int getLength(){
        if(head == null){
            return 0;
        }

        int size = 0;
        current = head;
        while (current != null){
            size ++;
            current = current.next;
        }

        return size;
    }

    //方法3-1，查找顺数第k个链表的数据
    public Node findNode(int index){
        if (head == null){
            return null;
        }

        if (index <= 0 || index > size){
            System.out.println("index out of bound");
        }

        current = head;
        for (int i = 0; i < index - 1 ; i++) {
            current = current.next;
        }

        return current;
    }
    //方法3-2，查找顺数第k个链表的数据
    public Node findLastNode(int index){
        return findNode((size + 1) - index);
    }

    //方法3-3，查找顺数第k个链表的数据,不遍历链表获取链表长度
    public Node findLastNode(Node node, int index){
        if (index == 0 || head == null){
            return null;
        }

        Node first = head;
        Node second = head;

        //先让second和first之间相隔k-1个位置，这样当second都末尾时，first就在末尾前的第k个地方（注意是相隔k-1，不占位相隔和站位相隔：站位相隔k，等于不占为相隔k-1。
        // 这里的站位是要移动的目标是否占位置，且固定目标是站位的）
        for (int i = 0; i < index - 1; i++) { //说明k的值已经大于链表的长度了
            second = second.next;
            if(second == null){
                //throw new NullPointerException("链表的长度小于" + k); //我们自己抛出异常，给用户以提示
                return null;
            }
        }

        //让first和second一起向后移
        while (second.next != null){
            first = first.next;
            second = second.next; //更新完之后while条件才判断（即更新后判断），而if可以前后判断。
        }

        return first;
    }


    //方法3-4，查找中间节点，不遍历链表
    public Node findMiddleNode(){
        if ( head == null){
            return null;
        }

        Node first = head;
        Node second = head;

        //每次移动时，让second结点移动两位，first结点移动一位
        //让first和second一起向后移
        while (second!= null && second.next != null){ //针对奇偶数情况
            first = first.next;
            second = second.next.next;  //更新完之后while条件才判断（即更新后判断），而if可以前后判断。
        }

        return first;
    }


    //方法4，删除
    //方法5，查询
    //方法6，合并两个有序链表，市值仍然有序
    //解题思路：挨着比较链表1和链表2。这个类似于归并排序。尤其要注意两个链表都为空、和其中一个为空的情况。只需要O (1) 的空间。时间复杂度为O (max(len1,len2))
    public void mergeLinkedList(SLinkedList sLinkedList1, SLinkedList sLinkedList2){ //添加到本数据对象中，因此不需要new一个新的进来。此处入口也可以做成传入List
        Node head1 = sLinkedList1.head;
        Node head2 = sLinkedList2.head;

        if (head1 == null && head1 == null){
            return;
        }

        if (head1 == null){
            head = head2;
        }

        if (head2 == null){
            head = head1;
        }

        // 一开始，让current结点指向head1和head2中较小的数据，得到head结点
        if (head1.data < head2.data){
            head = head1;
            current = head1;
            head1 = head1.next; //head1向后一步
        }else{
            head = head2;
            current = head2;
            head2 = head2.next; //head1向后一步
        }

        while (head1 != null && head2 != null){
            if (head1.data < head2.data){
                current.next = head1; //当前节点指向数据较小的节点
                current = current.next; //当前节点后移
                head1 = head1.next; //head1后移
            }else {
                current.next = head2; //当前节点指向数据较小的节点
                current = current.next; //当前节点后移
                head2 = head2.next; //head1后移
            }
        }

        //合并剩余元素
        if (head1 != null){ //不需要while循环，直接加入就行了（注意此处易受到惯性思维影响）
            current.next = head1; //其实每一个节点都可以链接到链尾！
        }
        if (head2 != null){
            current.next = head2; //其实每一个节点都可以链接到链尾！
        }
    }

    //方法7，单链表的反转：【出现频率最高】，思路：从头到尾遍历原链表，每遍历一个结点，将其摘下放在新链表的最前端。注意链表为空和只有一个结点的情况。时间复杂度为O（n）
    public void reverseLinkedList(){
        if(head == null || head.next == null){
            return;
        }

        Node current = head;
        Node currentNext = null;  //记录current的下一个节点
        Node reverseHead = null;  //反转后新链表的表头

        while (current!= null){   //current!= null比current.next!= null多循环一次。前者循环到current = null

            currentNext = current.next;             //暂时保存住当前结点的下一个结点，因为下一次要用
//            current.next = reverseHead.next;
            current.next = reverseHead; //这里存在和有头节点的链表的细微差别;将current的下一个结点指向新链表的头结点
            reverseHead = current; //将头节点指向当前节点
            current = currentNext;
        }

        //最后别忘记把head指向倒序后的链表
        head = reverseHead;
    }

    //判断链表是否有环
    public boolean hasCycle(){
        if (head == null){
            return false;
        }

        Node first = head;
        Node second = head;

        while (second != null && second.next != null){  //循环到链尾second != null，此时second.next = null.也即循环体中的second一定不为null.second.next != null,针对最后循环时当前节点在末尾上
//        while (second != null){  //循环到链尾second != null，此时second.next = null.也即循环体中的second一定不为null.second.next != null,针对最后循环时当前节点在末尾上

            first = first.next;
            second = second.next.next;

            if (first == second){
                return true;
            }
        }

        return false;
    }

}
