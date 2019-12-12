package datastruct.tree.practic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-04 12:34
 */
public class BSTTreeDemo {
    public static void main(String[] args) {

        int[] arr = new int[] {10, 11, 7, 6, 8, 9};

        BSTTree bstTree = new BSTTree();
        bstTree.buildTree(arr);
//        bstTree.midOderlist(bstTree.root);

//        System.out.println(bstTree.leverUpToDownList());
        System.out.println(bstTree.leverZCharList());

    }
}


class BSTTree {
    public TreeNode root;


    public BSTTree() {
    }

    public BSTTree(TreeNode root) {
        this.root = root;
    }


    /**
     * 0-1，添加搜索二叉树。搜索二叉树的概念一定要清楚！
     *
     * @param pRoot
     * @param data
     */
    public void add(TreeNode pRoot, int data) {
        if (null == root) {
            root = new TreeNode(data);
        } else {
            if (data < pRoot.data) {
                if (null == pRoot.left) {
                    pRoot.left = new TreeNode(data);
                } else {
                    add(pRoot.left, data);
                }
            } else {
                if (null == pRoot.right) {
                    pRoot.right = new TreeNode(data);
                } else {
                    add(pRoot.right, data);
                }
            }
        }
    }


    /**
     * 0-2，构建树
     *
     * @param arr
     */
    public void buildTree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(root, arr[i]);
        }
    }

    /**
     * 0-3-1，前序打印树
     *
     * @param pRoot
     */
    public void preOderlist(TreeNode pRoot) {
        if (pRoot != null) {
            System.out.println(pRoot.data);
            preOderlist(pRoot.left);
            preOderlist(pRoot.right);
        }
    }

    /**
     * 0-3-2，中序打印树
     *
     * @param pRoot
     */
    public void midOderlist(TreeNode pRoot) {
        if (pRoot != null) {
            midOderlist(pRoot.left);
            System.out.println(pRoot.data);
            midOderlist(pRoot.right);
        }
    }

    /**
     * 0-3-3，后序打印树
     *
     * @param pRoot
     */
    public void posOderlist(TreeNode pRoot) {
        if (pRoot != null) {
            posOderlist(pRoot.left);
            posOderlist(pRoot.right);
            System.out.println(pRoot.data);
        }
    }


    /**
     * 1-1,从上到下扫描树
     *
     * @return
     */
    public List leverUpToDownList() {  //不需要传参进来

        ArrayList<ArrayList<TreeNode>> resList = new ArrayList<>();
        ArrayList<TreeNode> leverList;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);

        //针对deque进行操作，一个while+for
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            leverList = new ArrayList<>();
            //取出一层数据，存放下层数据
            for (int i = 0; i < dequeSize; i++) {
                TreeNode tempNode = deque.poll();
                leverList.add(tempNode);

                //存放下层数据
                if (tempNode.left != null) {
                    deque.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    deque.add(tempNode.right);
                }
            }
            resList.add(leverList);
//            resList.add(0, leverList);
        }
        return resList;
    }


    /**
     * 1-2,之字形扫描树
     *
     * @return
     */
    public List leverZCharList() {  //不需要传参进来

        ArrayList<ArrayList<TreeNode>> resList = new ArrayList<>();
        ArrayList<TreeNode> leverList;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);
        int leverFlag = 0;
        //针对deque进行操作，一个while+for
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            leverList = new ArrayList<>();
            //取出一层数据，存放下层数据
            for (int i = 0; i < dequeSize; i++) {
                //添加本层数据
                TreeNode tempNode = deque.poll();
                leverList.add(tempNode);

                //存放下层数据
                if (leverFlag % 2 == 0){
                    if (tempNode.right != null) {
                        deque.add(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        deque.add(tempNode.left);
                    }
                }else if(leverFlag % 2 == 1){
                    if (tempNode.left != null) {
                        deque.add(tempNode.left);
                    }

                    if (tempNode.right != null) {
                        deque.add(tempNode.right);
                    }
                }
            }
            resList.add(leverList);

            leverFlag++;
        }
        return resList;
    }


    public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2){


        return lowestCommonAncestor(root, node1, node2);
    }

    private TreeNode lowestCommonAncestor(TreeNode pRoot, TreeNode node1, TreeNode node2) {
        if (pRoot == null || pRoot == node1 || pRoot == node2){
            return pRoot;
        }

        TreeNode left = lowestCommonAncestor(pRoot.left, node1, node2);
        TreeNode right = lowestCommonAncestor(pRoot.left, node1, node2);

        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }

        return pRoot;  //如果left和right都不为空，那么该节点就是公共节点
    }

}




/**
 * 树节点
 */
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}