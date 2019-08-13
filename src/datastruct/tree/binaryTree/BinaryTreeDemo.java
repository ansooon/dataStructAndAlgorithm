package datastruct.tree.binaryTree;

import jdk.nashorn.internal.ir.IfNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-11 15:22
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);


        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);//注意这种设计思想

//        //1-1前序遍历
//        binaryTree.preOrderList(root);
//
//        //1-2中序遍历
//        binaryTree.infixOrderList(root);
//
//        //1-3后续遍历
//        binaryTree.posOrderList(root);

        //2-1前序查找
//        System.out.println(binaryTree.preOrderSearch(9));

        //2-2中序查找
//        System.out.println(binaryTree.preOrderSearch(4));

        //2-3后序查找
//        System.out.println(binaryTree.preOrderSearch(8));

    }
}


class BinaryTree {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //1-1前序遍历
    public void preOrderList(TreeNode root) {
        if (root != null) {
            root.preOderList();
        } else {
            System.out.println("空树");
        }
    }

    //1-2前序遍历
    public void infixOrderList(TreeNode root) {
        if (root != null) {
            root.infixOderList();
        } else {
            System.out.println("空树");
        }
    }

    //1-3前序遍历
    public void posOrderList(TreeNode root) {
        if (root != null) {
            root.posOderList();
        } else {
            System.out.println("空树");
        }
    }

    //2-1，前序查找
    public TreeNode preOrderSearch(int data){
        if(root != null){
            return root.preOrderSearch(data);
        }else{
            return null;
        }
    }

    //2-2，中序查找
    public TreeNode infixOrderSearch(int data){
        if(root != null){
            return root.infixOrderSearch(data);
        }else{
            return null;
        }
    }
    //2-1，前序查找
    public TreeNode posOrderSearch(int data){
        if(root != null){
            return root.posOrderSearch(data);
        }else{
            return null;
        }
    }

}


class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }


    //1-1前序遍历
    public void preOderList() {

        System.out.println(this);     //先打印自己

        if (this.left != null) {
            this.left.preOderList();  //再打印左子叶
        }

        if (this.right != null) {
            this.right.preOderList(); //最后打印右子叶
        }

    }

    //1-2中序遍历
    public void infixOderList() {

        if (this.left != null) {  //先探底先
            this.left.infixOderList();  //先打印左子叶
        }

        System.out.println(this);       //再打印自己

        if (this.right != null) {
            this.right.infixOderList();  //最后打印右子叶
        }
    }

    //1-2后序遍历
    public void posOderList() {

        if (this.left != null) {
            this.left.posOderList();   //先打印左子叶
        }

        if (this.right != null) {
            this.right.posOderList();   //再打印右子叶
        }

        System.out.println(this);       //最后打印自己
    }


    //2-1前序查找
    public TreeNode preOrderSearch(int data) {
        TreeNode node = null;

        //递归终止条件，根据前中后序放置
        if (data == this.data) {
            return this;        //关键在于return关键字，能够使"递"提前"归"
        }

        //1，左子树递归
        if (this.left != null) {
            node = this.left.preOrderSearch(data);
        }

        //2.判断是否返回，若返回则意味着终止后续递归，位置一定双递归中间。
        if (node != null) {
            return node;  //这里写return，目的是不要让下一个递归函数继续执行。厉害！
        }

        //3，右子树递归
        if (this.right != null) {
            //1，对于左支，不在后面添加if(node != null){return node;}，是因为递归的归途一定要在最底层栈才能推出。
            // 当递归this.right.preOrderSearch(data)时，递归栈一定会回退到上一个节点的栈函数中，
            // 而上n个栈的根节点栈一定会判断if(node != null){return node;}，到那时再返回值。
            //2，对于右支，在根节点退出是，不管是否找到，都需要退出。
            node = this.right.preOrderSearch(data);
        }

        return node;
    }


    //2-2中序查找
    public TreeNode infixOrderSearch(int data) {
        TreeNode resNode = null;

        //1，左子树递归
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(data);
        }

        //2.判断是否返回，若返回则意味着终止后续递归，位置一定双递归中间。
        if (resNode != null) {
            return resNode;
        }

        //递归终止条件，根据前中后序放置
        if (this.data == data) {
            return this;
        }

        //3，右子树递归
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(data);
        }

        return resNode;
    }

    //2-3 后序查找
    public TreeNode posOrderSearch(int data) {
        TreeNode resNode = null;

        //1，左子树递归
        if (this.left != null) {
            resNode = this.left.posOrderSearch(data);
        }

        //2.判断是否返回，若返回则意味着终止后续递归，位置一定在双递归中间。
        if (resNode != null) {
            return resNode;
        }

        //3,右子树递归
        if (this.right != null) {
            resNode = this.right.posOrderSearch(data);
        }


        //递归终止条件，根据前中后序放置
        if (this.data == data) {
            return this;
        }

        return resNode;
    }


}
