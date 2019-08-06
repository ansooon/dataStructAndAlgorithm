package datastruct.linkedList;


/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-02 10:43
 */


//链表就是数据实体之间的线性关联，通过next实现，可以认为加入数据实际上是将当前的next指向下一个数据实体
//双向链表的优点，双向查找，且可以自我删除（但单链表删除时，总是要找到temp指向删除节点前的节点）

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        //进行测试
        //先创建节点
        DoubleHeroNode DoubleHeroNode1 = new DoubleHeroNode(1, "黄一", "大一");
        DoubleHeroNode DoubleHeroNode2 = new DoubleHeroNode(2, "胡二", "小二");
        DoubleHeroNode DoubleHeroNode3 = new DoubleHeroNode(3, "张三", "小三");
        DoubleHeroNode DoubleHeroNode4 = new DoubleHeroNode(4, "李四", "小四");
        DoubleHeroNode DoubleHeroNode5 = new DoubleHeroNode(5, "王五", "小五");
        DoubleHeroNode DoubleHeroNode6 = new DoubleHeroNode(6, "赵六", "小六");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //增加测试
        doubleLinkedList.add(DoubleHeroNode1);
        doubleLinkedList.add(DoubleHeroNode2);
        doubleLinkedList.add(DoubleHeroNode3);
        doubleLinkedList.add(DoubleHeroNode4);
        doubleLinkedList.add(DoubleHeroNode5);
        doubleLinkedList.add(DoubleHeroNode6);
//        doubleLinkedList.list();

        //修改测试
//        DoubleHeroNode updateDoubleHeroNode4 = new DoubleHeroNode(4, "改变", "改变");
//        doubleLinkedList.update(updateDoubleHeroNode4);
//        doubleLinkedList.list();


        //删除测试

        doubleLinkedList.delete(4);
        doubleLinkedList.list();

    }

}


class DoubleLinkedList {
    private DoubleHeroNode head = new DoubleHeroNode(0,"","");

    public DoubleHeroNode getHead() {
        return head;
    }

    public void setHead(DoubleHeroNode head) {
        this.head = head;
    }

    //1,遍历
    public  void list(){
        if(head.next == null){
            System.out.println("链表为空！");
            return; //记得写上return
        }

        DoubleHeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }

            System.out.println(temp);

            temp = temp.next;
        }
    }

    //2,添加（作业）
    public void add(DoubleHeroNode doubleHeroNode){

        //添加不用判断链表是否为空
        DoubleHeroNode temp = head; //注意，是头节点，而不是头结点的下一个。增删长，指向头。

        while(true){
            //增前判断
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = doubleHeroNode;
        doubleHeroNode.pre = temp;
    }


    //3，删除
    public void delete(int no){

        if(head.next == null){
            System.out.println("链表为空，不能删除");
        }

        DoubleHeroNode temp = head.next; //不是从头开始
        boolean isPosition = false;

        while (true){
            //增后判断
            if(temp == null){
                break;
            }

            if(temp.no == no){
                isPosition = true;
                break;
            }

            //增
            temp = temp.next;
        }

        if(isPosition){
            temp.pre.next = temp.next;
            //如果是删除最后一个，那么temp.next = null，temp.next.pre会报错，因此需要增加一个判断
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("找不到要删除的节点：" + no);
        }
    }

    //4，改变
    public void update(DoubleHeroNode doubleHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        DoubleHeroNode temp = head.next;
        boolean isPoint = false; //标记是否找到该节点
        while (true) {
            if (temp == null) {
                break; //到链表的最后，遍历结束
            }
            if (temp.no == doubleHeroNode.no) {
                isPoint = true;
                break;
            }
            temp = temp.next;
        }

        //根据flag判断是否找到要修改的节点，如果flag=false，说明遍历结束也没有找到
        if (isPoint) {
            temp.name = doubleHeroNode.name;
            temp.nickName = doubleHeroNode.nickName;
        } else {
            System.out.println("没有找到该节点编号信息，节点=" + doubleHeroNode.toString());
        }
    }
}


/**
 * 定义数据节点，每个节点就是一个对象
 */
class DoubleHeroNode {
    public int no;  //注意是public，因此不用getter和setter即可访问
    public String name;
    public String nickName;
    public DoubleHeroNode next;
    public DoubleHeroNode pre;


    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
