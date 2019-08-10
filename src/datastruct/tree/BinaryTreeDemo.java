package datastruct.tree;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-09 18:42
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        //需要先创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
//        HeroNode root = new HeroNode(1, "宋江");
//        HeroNode node2 = new HeroNode(2, "吴用");
//        HeroNode node3 = new HeroNode(3, "卢俊义");
//        HeroNode node4 = new HeroNode(4, "林冲");
//        HeroNode node5 = new HeroNode(5, "关雄");
//        HeroNode node6 = new HeroNode(6, "雄风");
//        //递归和手动创建，目前先手动创建
//        root.setLeft(node2);
//        root.setRight(node3);
//        node2.setLeft(node6);
//        node3.setRight(node4);
//        node3.setLeft(node5);
//        binaryTree.setRoot(root);
//        //递归和手动创建，目前先手动创建
//        root.setLeft(node2);
//        root.setRight(node3);
//        node2.setLeft(node6);
//        node3.setRight(node4);
//        node3.setLeft(node5);
//        binaryTree.setRoot(root);

        HeroNode root = new HeroNode(1, "1");
        HeroNode node2 = new HeroNode(2, "2");
        HeroNode node3 = new HeroNode(3, "3");
        HeroNode node4 = new HeroNode(4, "4");
        HeroNode node5 = new HeroNode(5, "5");
        HeroNode node6 = new HeroNode(6, "6");
        HeroNode node7 = new HeroNode(7, "7");
        HeroNode node8 = new HeroNode(8, "8");
        HeroNode node9 = new HeroNode(9, "9");
        HeroNode node10 = new HeroNode(10, "10");
        HeroNode node11 = new HeroNode(11, "11");
        HeroNode node12 = new HeroNode(12, "12");
        HeroNode node13 = new HeroNode(13, "13");
        HeroNode node14 = new HeroNode(14, "14");
        HeroNode node15 = new HeroNode(15, "15");
        //递归和手动创建，目前先手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

//        node4.setLeft(node8);
//        node4.setRight(node9);
//
//        node5.setLeft(node10);
//        node5.setRight(node11);
//
//        node6.setLeft(node12);
//        node6.setRight(node13);
//
//        node7.setLeft(node14);
//        node7.setRight(node15);

        binaryTree.setRoot(root);

        //1，遍历
//        System.out.println("前序遍历");
//        binaryTree.preOrderList();

//        System.out.println("中序遍历");
////        binaryTree.midOrderList();

//        System.out.println("后序遍历");  //输出前是否有可能输出其他
//        binaryTree.posOrderList();


        //2，查找
//        HeroNode heroNode1 = binaryTree.preOrderSearch(6);
//        System.out.println("前序查找");
//        System.out.println(heroNode1);

//        HeroNode heroNode2 = binaryTree.midOrderSearch(3);
//        System.out.println("中序查找");
//        System.out.println(heroNode2);

//        HeroNode heroNode3 = binaryTree.preOrderSearch(2);
//        System.out.println("后序查找");
//        System.out.println(heroNode3);


        //3，删除节点
        binaryTree.preOrderList();
        binaryTree.deleteNode(16);
        System.out.println("删除后");
        binaryTree.preOrderList();

    }
}


//先创建HeroNode节点
class BinaryTree{

    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    //1-1前序遍历
    public void preOrderList(){
        if (root != null){
            this.root.preOrderList();
        }else{
            System.out.println("当前二叉树为空");
        }
    }

    //1-2前序遍历
    public void midOrderList(){
        if (root != null){
            this.root.midOrderList();
        }else{
            System.out.println("当前二叉树为空");
        }
    }

    //1-3前序遍历
    public void posOrderList(){
        if (root != null){
            this.root.posOrderList();
        }else{
            System.out.println("当前二叉树为空");
        }
    }



    //2-1，前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }

    //2-2，中序遍历查找
    public HeroNode midOrderSearch(int no){
        if (root != null){
            return root.midOrderSearch(no);
        }else{
            return null;
        }
    }

    //2-3，后序遍历查找
    public HeroNode posOrderSearch(int no){
        if (root != null){
            return root.posOrderSearch(no);
        }else{
            return null;
        }
    }


    //3，删除
    public void deleteNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else{
                root.deleteNode(no);
            }
        }else {
            System.out.println("空树，不能删除");
        }
    }
}


/**
 * 创建节点
 */
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(){

    }


    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    //1-1，编写前序遍历的方法
    public void preOrderList(){
        System.out.println(this);  //先输出父节点，能进来说明不为空
        //递归向左子树前序遍历
        if (this.left != null){
            this.left.preOrderList();
        }

        //递归向右指数前序遍历
        if (this.right != null){
            this.right.preOrderList();
        }
    }

    //1-2,编写中序遍历的方法
    public void midOrderList(){
        //递归向左子树中序遍历
        if (this.left != null){
            this.left.midOrderList();
        }
        //输出当前节点
        System.out.println(this);

        //递归向右子树中序遍历
        if (this.right != null){
            this.right.midOrderList();
        }

    }

    //1-3,编写后序遍历的方法
    public void posOrderList(){
        //递归向左子树前序遍历
        if (this.left != null){
            this.left.posOrderList();
        }

        //递归向右指数前序遍历
        if (this.right != null){
            this.right.posOrderList();
        }

        System.out.println(this);
    }

    //2-1前序查找
    public HeroNode preOrderSearch(int no){

        //无论是左递归，还是右递归，进来第一件事就是执行该条件。若果是右递归再次找到相等，那么久返回，否则就进入下一个做循环判断。
        //因此，只有右节点有返回，那么一定是找到了。
        //结论，主被调变量思想：对于前序遍历，相对于递归函数，递归函数的上部分变量逻辑为下一次调用的变量逻辑。
        // 注意，第一次调用的下次变量逻辑是外部调用。递归函数的下部分变量为本次调用下一次函数之后的变量逻辑。
        if(this.no == no){
            return this;
        }

        //
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }

        if(resNode != null){
            return resNode;
        }

        //右节点外层循环，左节点内层循环
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;  //不管是否找到，都返回
    }


    //2-2中序查找
    public HeroNode midOrderSearch(int no){
        //首先通过将方法压入栈，先变量到左边最底层节点，然后反向逐一判断。
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.midOrderSearch(no);
        }

        if (resNode != null){
            return resNode;
        }

        if(this.no == no){    //被调变量。无递归函数思想：最底层的被调函数为无递归函数遍历，只看返回结果，然后利用主被调变量思想（上被下主）出栈。
            return this;
        }

        if(this.right != null){
            resNode = this.right.midOrderSearch(no);
        }

        return resNode;
    }

    //2-3后序查找
    public HeroNode posOrderSearch(int no){
        //递归向左子树中序遍历
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.posOrderSearch(no);
        }

        //调用所得结果，说明在左子树找到.
        if (resNode != null){
            return resNode;
        }


        //如果在左子树没有找到，那么向右字子树递归
        if(this.right != null){
            resNode = this.right.posOrderSearch(no);
        }


        if (resNode != null){
            return resNode;
        }

        //如果左右子树都没有找到，就比较当前节点是不是
        if(this.no == no){
            return this;
        }

        return resNode;
    }


    //递归删除节点
    //是叶子节点就删除叶子节点，否则就将该节点的子树全部删除
    public void deleteNode(int no){

        //1如果左右子节点相等，那么置空返回
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }


        //向左递归
        if(this.left != null){
            this.left.deleteNode(no);
        }

        //向右递归
        if(this.right != null){
            this.right.deleteNode(no);
        }

        //这里所有逻辑都是在if里面，如果都不满足，那么将不会调用任何递归函数，因此也是一种退出条件
    }



}