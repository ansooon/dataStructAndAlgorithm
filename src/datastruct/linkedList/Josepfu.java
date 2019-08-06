package datastruct.linkedList;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-03 0:34
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
//        circleSingleLinkedList.list();

        circleSingleLinkedList.countBoy(1,2,5);

    }
}


class CircleSingleLinkedList{
    //首先创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);

    //添加小孩节点，构建成一个环形链表
    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("nums的值不正确");
            return;
        }

        Boy curBoy = null;  //辅助指针，帮助构建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //第一个小孩比较特殊，第一个环，单独考虑
            if(i == 1){
                first = boy;
                first.setNext(first);  //构成环状
                curBoy = first; //让curBoy指向第一个小孩，因为first不能动
            }else{
                //三部曲
                curBoy.setNext(boy);
                boy.setNext(first);  //指向开头
                curBoy = boy;
            }
        }
    }

    public void list(){
        //判断链表是否为空
        if(first == null){
            System.out.println("没有节点");
            return;
        }

        //因为first不能动，因此使用辅助指正完成遍历
        Boy curBoy = first;
        while (true){
            System.out.println(curBoy);
            if (curBoy.getNext() == first){ //遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入，计算出节点出圈的顺序

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初由多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums){

        //先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        //创建辅助指针，帮助完成节点出圈
        Boy helper = first;
        //需要创建一个辅助指针，helper，事先应该指向环形链表的最后一个节点
        while (true){
            if(helper.getNext() == first){ //注意不是用equls()
                break;
            }

            helper = helper.getNext();
        }

        //节点报数前，先让first 和 helper 移动k - 1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当节点报数时，让first和helper指针同时移动m - 1次，然后出圈
        //是一个循环操作，直到圈中只有一个节点。即helper == first
        while (true){
            //后增退出
            if(helper == first){ //说明圈中只有一个节点
                break;
            }
            
            //让first和helper同时移动countNum - 1 次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //这时first指向的节点就是要出圈的节点
            System.out.println(first);

            //这时，将first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.println(first);
    }

}


//创建一个Boy，表示一个节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
