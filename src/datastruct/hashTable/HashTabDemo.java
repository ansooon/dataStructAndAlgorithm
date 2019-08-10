package datastruct.hashTable;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-09 16:49
 */

/**
 * 可以同时管理多条链表
 */
public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(3);

        hashTab.add(new Emp(1, "黄一"));
        hashTab.add(new Emp(2, "王二"));
        hashTab.add(new Emp(3, "张三"));
        hashTab.add(new Emp(4, "李四"));
        hashTab.add(new Emp(5, "钱五"));
        hashTab.add(new Emp(6, "赵六"));
//        hashTab.list();

        hashTab.findEmpById(7);

    }
}


/**
 * hashTab
 */
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        this.size = size;
        //注意初始化链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //1，添加雇员
    public void add(Emp emp) {
        //根据员工的ID得到该员工应该加入到哪条链表
        int empLinkedListNo = hashFun(emp.id);

        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);  //empLinkedListArray[empLinkedListNo]这个指向一个链表对象
    }


    //2,根据id查找，
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);

        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.println("在第" + (empLinkedListNo + 1) + "中找到数据" + emp);
        }else{
            System.out.println("在哈希表中没有找到");
        }
    }

    //3，删除(略)

    //,4.遍历所有的链表，即遍历hashTab。有助于理解数和B数
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i + 1);
        }
    }

    //4,编写散列函数
    public int hashFun(int id) {
        return id % size;
    }
}


/**
 * 创建雇员类
 */

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


/**
 * 创建EmpLinkedList
 */
class EmpLinkedList {
    //头指针，执行第一个Emp，因此我们这个链表的head，是指向第一个Emp

    private Emp head;

    //添加雇员
    //1,假定添加雇员时，id时自增的，即id的分配总是从小到大，因此向尾部添加
    public void add(Emp emp) {
        Emp cur = head;
        if (head == null) {
            head = emp;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = emp;
        }
    }


    //2，查找，根据id进行查找
    public Emp findEmpById(int id){
        //判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return null;
        }

        Emp cur = head;
        //注意判断没有找到相等，循环到链表末尾时，退出的时候必须是cur = null。
        // 如果写成id != cur.id && cur != null 有可能使得cur.id报空指针异常
        //对于将while循环在其头部加入判断条件，可以先不写条件，先写业务代码，再在最后判断退出的break条件，然后再在头部将==变成!=
        while (cur != null && id != cur.id){
//        while (id != cur.id && cur != null){
            cur = cur.next;
        }

        return cur;
    }


    public void list(int no) {
        if (head == null) {
            System.out.println("list " + no + " is empty");
            return;
        }

        System.out.println("list" + no + "链表信息为");
        Emp cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

}