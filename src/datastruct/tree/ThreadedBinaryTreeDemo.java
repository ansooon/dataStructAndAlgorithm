package datastruct.tree;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-10 18:38
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

        ThreadedNode root = new ThreadedNode(1,"tom");
        ThreadedNode node2 = new ThreadedNode(3,"jack");
        ThreadedNode node3 = new ThreadedNode(6,"smith");
        ThreadedNode node4 = new ThreadedNode(8,"mary");
        ThreadedNode node5 = new ThreadedNode(10,"king");
        ThreadedNode node6 = new ThreadedNode(10,"dim");

        //二叉树后面要递归创建
        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        ThreadedNode leftNode = (ThreadedNode) node5.getLeft();
        ThreadedNode rightNode = (ThreadedNode) node5.getRight();
        System.out.println(leftNode);
        System.out.println(rightNode);
    }
}


class ThreadedBinaryTree extends BinaryTree{
    private ThreadedNode root;

    //为了实现线索化，需要创建指向当前节点的前驱节点的指针
    private ThreadedNode pre = null;


    public ThreadedNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    //编写对二叉树进行中序线索化的方法
    public void  threadedNodes(ThreadedNode node){
        if (node == null){
            return;
        }

        //先线索化做左子树
        threadedNodes((ThreadedNode) node.getLeft());
        //线索化当前节点
          //向处理当前节点的前驱节点
        if (node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);  //最开始时，pre还没有初始化
            //修改当前节点的左指针的类型,指向前驱指针
            node.setLeftType(1);

        }

        //处理后续节点，修改前驱指针的右节点指向当前节点
        if (pre!= null && pre.getRight() == null){
            pre.setRight(node);  //搭建后继节点
            pre.setRightType(1);
        }

        //!!!每处理UI个节点后，让当前节点指向下一个节点的前驱节点
        pre = node;

        //最后线索化右子数
        threadedNodes((ThreadedNode) node.getRight());
    }

    //重载线索化方法

    public void threadedNodes(){
        this.threadedNodes(root);
    }
}


class ThreadedNode extends HeroNode{

    //说明，如果leftType = 0.则说明是左子树，否则是前驱节点。rightType同理、
    private int leftType;
    private int rightType;

    public ThreadedNode(int no, String name) {
        super(no, name);
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
}
