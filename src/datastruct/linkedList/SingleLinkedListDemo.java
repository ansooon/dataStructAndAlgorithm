package datastruct.linkedList;

import java.util.Stack;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-02 10:43
 */

//链表就是数据实体之间的线性关联，通过next实现，可以认为加入数据实际上是将当前的next指向下一个数据实体

public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //进行测试
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "黄一", "大一");
        HeroNode heroNode2 = new HeroNode(2, "胡二", "小二");
        HeroNode heroNode3 = new HeroNode(3, "张三", "小三");
        HeroNode heroNode4 = new HeroNode(4, "李四", "小四");
        HeroNode heroNode5 = new HeroNode(5, "王五", "小五");
        HeroNode heroNode6 = new HeroNode(6, "赵六", "小六");

        //创建列表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //--1-1，添加测试
        singleLinkedList.addTail(heroNode1);
        singleLinkedList.addTail(heroNode2);
        singleLinkedList.addTail(heroNode3);
        singleLinkedList.addTail(heroNode4);
        singleLinkedList.addTail(heroNode5);
        singleLinkedList.addTail(heroNode6);
//        singleLinkedList.list();

        //--1-2，添加测试
//        singleLinkedList.addHead(heroNode1);
//        singleLinkedList.addHead(heroNode2);
//        singleLinkedList.addHead(heroNode3);
//        singleLinkedList.addHead(heroNode4);
//        singleLinkedList.addHead(heroNode5);
//        singleLinkedList.addHead(heroNode6);
//        singleLinkedList.list();


        //--1-3，添加测试2
        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode6);
//        singleLinkedList.addByOrder(heroNode5);
//        singleLinkedList.list();


        //--2-1，删除测试
//        singleLinkedList.deleteByDate(1);
//        System.out.println("删除后的情况：");
//        singleLinkedList.list();

        //--2-2，删除测试
//        singleLinkedList.deleteByIndex(6);
//        System.out.println("删除后的情况：");
//        singleLinkedList.list();

        //--2-3，删除测试
//        singleLinkedList.deleteAll();
//        System.out.println("删除后的情况：");
//        singleLinkedList.list();


        //--3-1，修改测试
//        HeroNode newHeroNode = new HeroNode(3,"陈翠莲","小三");
//        singleLinkedList.updateByData(newHeroNode);
//        System.out.println("修改后的情况：");
//        singleLinkedList.list();

        //--3-2，修改测试
//        HeroNode newHeroNode = new HeroNode(3,"陈翠莲","小三");
//        singleLinkedList.updateByIndex(3, newHeroNode);
//        System.out.println("修改后的情况：");
//        singleLinkedList.list();


        //--4-1，获取顺数第n个节点
//        HeroNode heroNode = singleLinkedList.findOrderIndexNode(3);
//        System.out.println(heroNode.toString());

        //--4-2，获取倒数第n个节点
//        HeroNode heroNode = singleLinkedList.findReverOrderIndexNode(2);
//        System.out.println(heroNode.toString());
          //另外一种方法：利用顺数函数获取
//        HeroNode heroNode = singleLinkedList.findOrderIndexNode((singleLinkedList.getLength() + 1) - 7);
//        System.out.println(heroNode.toString());


        //--5，获取长度
//        int len = singleLinkedList.getLength();
//        System.out.println(len);


        //--6，反转链表
//        singleLinkedList.reverseList();
//        singleLinkedList.list();
        //方法2
        singleLinkedList.reverseListByBase();
        singleLinkedList.list();

        //--7，逆序打印
//        singleLinkedList.reversePrint(singleLinkedList.getHead());
    }


}


/**
 * 定义SingleLinkedList,管理节点（节点类+节点管理类）
 */
class SingleLinkedList {
    //首先初始化头结点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }


    //0，遍历
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("list is empty");
            return;
        }

        //因为头结点不能动，我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }

            //数据节点的信息
            System.out.println(temp);

            //将temp后移，一定小心
            temp = temp.next;
        }
    }


    //1-1，增加（链尾）：循环末尾
    //添加节点到单向链表
    //当不考虑排序时，向末尾处添加
    //找到当前链表的最后节点，将next指向新的节点
    public void addTail(HeroNode heroNode) {
        //因为head节点不能动，因此需要引入辅助遍历指针temp
        HeroNode temp = head;
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }

            //如果没有找到最后，将temp后移
            temp = temp.next;
        }

        //当对出while时，temp指向了链表最后
        temp.next = heroNode;

    }

    //1-2，增加（链首）：循环末尾
    public void addHead(HeroNode heroNode) {
        //因为head节点不能动，因此需要引入辅助遍历指针temp
        HeroNode temp = head;

        if(temp.next == null){
            temp.next = heroNode;
        }else{
            //1，新节点后向线指向下一个
            //2，头节点后向线指向新节点
            heroNode.next = head.next;
            head.next = heroNode;
        }
    }

    //1-3,增加（顺序），循环末尾
    //第二种添加数据方法，比在数据库里添加要快
    public void addByOrder(HeroNode heroNode) {
        //因为头结点不能动，所以需要通过temp辅助变量来查找添加位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不成功
        HeroNode temp = head;
        boolean hasExisted = false; //标志添加的编号是否已经存在，如果存在就不再添加，默认为不存在

        while (true) {

            if (temp.next == null) { //说明temp在链表最后
                break;
            }

            if (temp.next.no > heroNode.no) { //位置找到，就在temp的后面加入，注意，将当前节点停留在temp，因此要用到temp.next。此时，temp.no < heroNode.no < temp.next.no
                break;

            } else if (temp.next.no == heroNode.no) { //说明编号已经存在，不能添加
                hasExisted = true;
                break;
            }

            temp = temp.next; //后移，变量当前链表
        }

        //判断flag的值
        if (hasExisted) {
            System.out.println("待插入的数据的编号已经存在，不能加入，数据变编号：" + heroNode.toString());
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //2-1，删除(按值删除),循环前向相等
    //删除节点
    //通过temp找到待删除的前一个节点
    //比较temp.no和需要删除的节点的no进行比较
    public void deleteByDate(int no) {
        HeroNode temp = head;
        boolean isNode = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) { //注意，将当前节点停留在temp，因此要用到temp.next
                isNode = true;
                break;
            }

            temp = temp.next;
        }

        if (isNode) {
            temp.next = temp.next.next;  //左边的“temp.next”中的next是当前节点的属性，右边的head.next是下一个数据实体的地址。赋值操作！
        } else {
            System.out.println("找不到要删除的节点：" + no);
        }
    }

    //2-2，删除(按索引删除),循环前向相等
    //删除节点
    //通过temp找到待删除的前一个节点
    //比较temp.no和需要删除的节点的no进行比较
    public void deleteByIndex(int index) {
        int size = getLength();
        if (size <= 0){
            System.out.println("链表为空");
            return;
        }

        if (index <= 0 || index > size ){
            System.out.println("索引越界");
            return;
        }

        HeroNode temp = head;
        //注意了，当删除第一个节点时，并没有进循环体
        for (int i = 0; i < index - 1; i++) { //删除时一定要找到被删除节点的前一个（目标前）。结论3：对于for循环，i = 0; i < num，则循环次数为num次
            temp = temp.next;
        }

        temp.next = temp.next.next; //结论4：当temp.next在左边时，是对temp的next属性进行赋值，即是对当前temp进行赋值操作，而当temp.next在等号右边时，是取值操作，取当前temp节点的下一个节点。

    }


    //2-3，删除(删除全部),循环前向相等
    //删除节点
    //通过temp找到待删除的前一个节点
    //比较temp.no和需要删除的节点的no进行比较
    public void deleteAll() {

        if (head.next == null){
            return;
        }

        HeroNode temp = head;
        HeroNode tempNext = null; //指向当前节点的下一个节点

        while (true){
            if (temp.next == null){
                break;
            }
            tempNext = temp.next;
            temp.next = null;
            temp = tempNext;
        }

    }



    //3-1，修改
    public void updateByData(HeroNode heroNode) {

        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head;
        boolean isPoint = false; //标记是否找到该节点
        while (true) {
            if (temp.next == null) {
                break; //到链表的最后，遍历结束
            }
            if (temp.next.no == heroNode.no) {
                isPoint = true;
                break;
            }
            temp = temp.next;
        }

        //根据flag判断是否找到要修改的节点，如果flag=false，说明遍历结束也没有找到
        if (isPoint) {
            temp.next.name = heroNode.name;
            temp.next.nickName = heroNode.nickName;
        } else {
            System.out.println("没有找到该节点编号信息，节点=" + heroNode.toString());
        }
    }

    //3-2，修改
    public void updateByIndex(int index, HeroNode heroNode ) {

        int size = getLength();

        if (size == 0){
            System.out.println("list is empty");
            return;
        }


        if (index <= 0 ||  index > size){
            System.out.println("Index of of bound");
            return;
        }

        //定义一个辅助变量
        //temp为目标前节点
        HeroNode temp = head;
        //循环1，结论2：当设计索引时，一般选择for循环，原因是可控制循环次数。
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        heroNode.next = temp.next.next; //结论5，当存在temp.next.next时，注意讨论temp.next是否为null。此处temp.next不为null
        temp.next = heroNode;

        //循环2
        //temp为目标，不可行。结论1，单链表的修改和删除操作的辅助指针必须取目标前节点。
//        for (int i = 0; i < index; i++) {
//            temp = temp.next;
//        }
//        //当修改最后一个时，注意判断
//        heroNode.next = temp.next;
//        temp.next = heroNode;
    }


    //4-1，查找（顺数第k个）
    //查找单链表倒数的第k个节点
    //(head, reverOrderIndex)
    public HeroNode findOrderIndexNode(int orderIndex) {
        if (head.next == null) {
            return null;
        }

        int size = getLength();

        if (orderIndex <= 0 || orderIndex > size) {
            return null;
        }

        //len = 4, index = 1, 执行2:4 - 1 -1
        HeroNode cur = head;
        for (int i = 0; i < orderIndex; i++) {  //执行这么多次：len - reverOrderIndex
            cur = cur.next;
        }

        HeroNode temp = new HeroNode(0,"","");
        temp.no = cur.no;  //注意！！！，要将temp.next置空，且不影响原数据结构
        temp.nickName = cur.nickName;  //注意！！！，要将temp.next置空，且不影响原数据结构
        temp.next = null;
        return temp;
    }

    //4-2，查找（倒数第k个）
    //查找单链表倒数的第k个节点
    //(head, reverOrderIndex)
    public HeroNode findReverOrderIndexNode(int reverOrderIndex) {
        if (head.next == null) {
            return null;
        }

        int size = getLength();

        if (reverOrderIndex <= 0 || reverOrderIndex > size) {
            return null;
        }

        //len = 4, index = 1, 执行2:4 - 1 -1
        HeroNode cur = head;
        for (int i = 0; i < size - reverOrderIndex + 1; i++) {  //执行这么多次：len - reverOrderIndex
            cur = cur.next;
        }

        return cur;
    }



    //5，取长
    //获取单链表长度
    public int getLength() {
        //忽略头结点
        int length = 0;
        HeroNode cur = head; //注意，这里是从头head开始
        while (true) {
            if (cur.next != null) {
                length++;
                cur = cur.next;
            } else {
                break;
            }
        }

        return length;
    }


    //6-1 其他项（反转）
    //反转单链表
    //先定义一个节点reversehead = new HeroNode();
    //从头到尾遍历原来的链表，每遍历一个节点，就将其取出，放在新链表的最前端
    //原来的链表的head.next = reverseHead.next;
    public void reverseList() {
        if (head.next == null || head.next.next == null) { //当链表为空或者只有一个时，不予处理
            return;
        }

        HeroNode cur = head.next; //可以考虑将目标节点前节点取名targetNodePre,将当前节点叫做cur
        HeroNode next = null; //指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next; //先暂时保存当前节点的下一个节点，后面需要使用
            cur.next = reverseHead.next; //将cur的下一个节点指向新的节点的最前端（上一个）,作用：让reverseHead中的next指向上一个数据；结论5：一定要数形结合:，此处，先将当前节点的next指向新链表的第一个，然后再让新链表的头节点指向当前节点
            reverseHead.next = cur; //连起节点，其中cur的上一步已经把其cur.next属性指向reverseHead.next的上一个
            cur = next; //遍历下一个节点
        }

        //将head.next指向reverseHead.next;
        head.next = reverseHead.next;
    }

    //6-1 其他项（反转）
    //反转单链表
    //先定义一个节点reversehead = new HeroNode();
    //从头到尾遍历原来的链表，每遍历一个节点，就将其取出，放在新链表的最前端
    //原来的链表的head.next = reverseHead.next;
    public void reverseListByBase() {
        if (head.next == null || head.next.next == null) { //当链表为空或者只有一个时，不予处理
            return;
        }

        int size = getLength();
        SingleLinkedList singleLinkedListHeadOrder = new SingleLinkedList();

        for (int i = 1; i <= size; i++) {
            HeroNode temp = findOrderIndexNode(i);
            singleLinkedListHeadOrder.addHead(temp);
        }

        this.deleteAll(); //将之前的删除掉
        head = singleLinkedListHeadOrder.getHead();
//        singleLinkedListHeadOrder.setHead(head);


    }

    //6-2 其他项（反向打印——利用栈）
    //从尾到头打印链表
    //方法1，先将链表反转，后打印（破坏原单链表数据结构，不建议，可以先将数据复制出来然后再反转！）
    //方式2，可以利用栈，先将数据压入栈中，利用栈的先进后出特点，实现了逆序打印效果
    //方式3，先获取链表的长度，然后逆序打印
    //此处使用方式2
    public void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }

        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            HeroNode heroNode = stack.pop();
            System.out.println(heroNode.toString()); //先进后出
        }

    }

}


/**
 * 定义数据节点，每个节点就是一个对象
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;


    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
