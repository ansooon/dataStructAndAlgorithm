package datastruct.tree.bstTreeV2;

import com.sun.jmx.remote.internal.ArrayQueue;
import jdk.internal.util.xml.impl.ReaderUTF8;

import java.util.*;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-12 17:43
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {

        //创建树
        int[] arr = {10, 11, 7, 6, 8, 9};
        int[] arr2 = {10, 11, 7, 6, 8, 9, 12};
        int[] arr3 = {20, 10, 30, 6, 14, 28, 32, 3, 8, 12, 16, 26};
        int[] arr4 = {7, 6, 8, 9};


        int[] preOrder = {10, 7, 6, 8, 9, 11};
        int[] infixOrder = {6, 7, 8, 9, 10, 11};
        int[] posOrder = {6, 9, 8, 7, 11, 10};
//        int[] arr = {10, 11, 7, 6, 8};
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree binaryTree2 = new BinaryTree();
        BinaryTree binaryTree4 = new BinaryTree();
        BinaryTree completeBinaryTree = new BinaryTree();
        BinaryTree avlTree = new BinaryTree();
        avlTree.buildAvlTree(arr);

        binaryTree.buildTree(arr);
        binaryTree2.buildTree(arr2);
        completeBinaryTree.buildTree(arr3);
        binaryTree4.buildTree(arr4);
//        binaryTree.preOrderList(binaryTree.getRoot());

        //创建镜像数
        Node root = new Node(3);
        Node node1 = new Node(2);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(2);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
//        node2.right = node4;
        BinaryTree duichengTree = new BinaryTree(root);
        

//        //2-1，分层从上到下，从左往右遍历
//        System.out.println(binaryTree.leverUpToDownOrderList());
//        //2-2，分层从下到上，从左往右遍历
//        System.out.println(binaryTree.leverDownToUpOrderList());
//        //2-3，之字形打印
//        System.out.println(binaryTree.zhiOrderList());
//        //3-1,一般二叉树前序查找
//        System.out.println(binaryTree.preOrderSearch(binaryTree.getRoot(), 9));
//        //3-2,一般二叉树中序查找
//        System.out.println(binaryTree.infixOrderSearch(binaryTree.getRoot(), 9));
//        //3-3,一般二叉树后序查找
//        System.out.println(binaryTree.posOrderSearch(binaryTree.getRoot(), 9));
//        //3-4,二叉排序树搜索
//        System.out.println(binaryTree.bstTreeSearch(binaryTree.getRoot(), 9));
//        //3-5,二叉排序树父节点搜索
//        System.out.println(binaryTree.bstTreeParentSearch(binaryTree.getRoot(), 7));
//        //3-6,一般二叉树父节点搜索
//        System.out.println(binaryTree.btTreeParentSearch(binaryTree.getRoot(), 7));
//        //3-7,寻找二叉排序树中两节点的最近公共祖先
//        System.out.println(binaryTree.lowestCommonAncestorForBstTreeSearch(
//                binaryTree.getRoot(),
//                binaryTree.bstTreeSearch(binaryTree.getRoot(), 6),
//                binaryTree.bstTreeSearch(binaryTree.getRoot(), 9)));
//        //3-8-1,寻找二叉一般树中两节点的最近公共祖先（递归）
//        System.out.println(binaryTree.lowestCommonAncestorSearchBaseRec(
//                binaryTree.getRoot(),
//                binaryTree.bstTreeSearch(binaryTree.getRoot(), 6),
//                binaryTree.bstTreeSearch(binaryTree.getRoot(), 9)));
//        //3-8-2,寻找二叉一般树中两节点的最近公共祖先（非递归）
//        System.out.println(binaryTree.lowestCommonAncestorSearchBaseRec(
//                binaryTree.getRoot(),
//                binaryTree.bstTreeSearch(binaryTree.getRoot(), 6),
//                binaryTree.bstTreeSearch(binaryTree.getRoot(), 9)));
//        //4-1,获取当前节点为根节点的树的最大高度
//        System.out.println(binaryTree.getLocalRootMaxHeight(binaryTree.getRoot()));
//        //4-2,获取当前节点为根节点的树的最大高度
//        System.out.println(binaryTree.getLocalRootMinHeight(binaryTree.getRoot()));
//        //4-3,获取当前节点为根节点的树的最大直径
//        System.out.println(binaryTree.getDiameter(binaryTree.getRoot()));
//        //5-1,获取树的节点个数
//        System.out.println(binaryTree.getNodeNum(binaryTree.getRoot()));
//        //5-2,获取第K层的节点个数
//        System.out.println(binaryTree.getLeverKNodeNum(binaryTree.getRoot(), 5));
//        //6-1,判断两棵树是否是同一个颗树
//        System.out.println(binaryTree.isSamTree(avlTree.getRoot(), avlTree.getRoot()));
//        //6-2,判断一棵树是否是平衡二叉树
//        System.out.println(binaryTree.isAvlTree(avlTree.getRoot()));
        //6-3,判断一棵树是否是镜像树
//        System.out.println(duichengTree.isSymmetricTree(duichengTree.getRoot()));
//        //6-4,判断一棵树是否是完全二叉树
//        System.out.println(completeBinaryTree.isCompleteTree(completeBinaryTree.getRoot()));
//        6-5,判断第二颗树是否是第一颗树的子树
//        System.out.println(binaryTree.isSubtree(binaryTree.getRoot(), binaryTree4.getRoot()));
//        //8-1，反转二叉树
//        System.out.println(binaryTree.leverUpToDownOrderList());
//        binaryTree.invertTree(binaryTree.getRoot());
//        System.out.println(binaryTree.leverUpToDownOrderList());
        //8-2，根据前序和中序重构二叉树
        binaryTree.infixOrderList( binaryTree.buildTreeBypreOrderAndInfixOrder(preOrder, infixOrder));
//        //9-2，求和等于某个给定值的所有路径
//        System.out.println(binaryTree.getAllPathsEqVal(binaryTree.getRoot(), 21));
//        //10-1，序列化
//        System.out.println(binaryTree.serialize(binaryTree.getRoot()));
//        //10-2，反序列化
//        System.out.println(binaryTree.deSerialize(binaryTree.serialize(binaryTree.getRoot())));
        
    }
}


class BinaryTree {
    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }


    /**
     * 1,添加二叉排序树
     *
     * @param localRoot
     * @param data
     */
    public void add(Node localRoot, int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (data < localRoot.data) {
                if (localRoot.left == null) {
                    localRoot.left = new Node(data);
                } else {
                    add(localRoot.left, data);
                }
            } else {
                if (localRoot.right == null) {
                    localRoot.right = new Node(data);
                } else {
                    add(localRoot.right, data);
                }
            }
        }
    }

    /**
     * 2，创建树
     *
     * @param arr
     */
    public void buildTree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(root, arr[i]);
        }
    }


    /**
     * 3-1，前序打印
     *
     * @param localRoot
     */
    public void preOrderList(Node localRoot) {
        if (root == null) {
            System.out.println("空树");
        } else {
            if (localRoot != null) {
                System.out.println(localRoot);
                preOrderList(localRoot.left);
                preOrderList(localRoot.right);
            }
        }
    }

    /**
     * 3-2，中序打印
     *
     * @param localRoot
     */
    public void infixOrderList(Node localRoot) {
        if (root == null) {
            System.out.println("空树");
        } else {
            if (localRoot != null) {
                infixOrderList(localRoot.left);
                System.out.println(localRoot);
                infixOrderList(localRoot.right);
            }
        }
    }

    /**
     * 3-3，后序打印
     *
     * @param localRoot
     */
    public void posOrderList(Node localRoot) {
        if (root == null) {
            System.out.println("空树");
        } else {
            if (localRoot != null) {
                posOrderList(localRoot.left);
                posOrderList(localRoot.right);
                System.out.println(localRoot);
            }
        }
    }

    /**
     * 3-4,从上到下逐层打印
     *
     * @return
     */
    public List leverUpToDownOrderList() {
        if (root == null) {
            return null;
        }

        List<ArrayList<Node>> resList = new ArrayList<>();
        ArrayList<Node> leverList;
        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp;
            leverList = new ArrayList<>();
            //注意，循环的终止条件不能为queue.size()，因为queue是动态改变的
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                temp = queue.poll();
                leverList.add(temp);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
//                if (temp.right != null) {
//                    queue.add(temp.right);
//                }
//                if (temp.left != null) {
//                    queue.add(temp.left);
//                }
            }
            resList.add(leverList);
        }
        return resList;
    }


    /**
     * 3-5,从下到上逐层打印
     *
     * @return
     */
    public List leverDownToUpOrderList() {
        if (root == null) {
            return null;
        }

        List<ArrayList<Node>> resList = new ArrayList<>();
        ArrayList<Node> leverList;
        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp;
            leverList = new ArrayList<>();
            //注意，循环的终止条件不能为queue.size()，因为queue是动态改变的
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                temp = queue.poll();
                leverList.add(temp);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            resList.add(0, leverList);
        }
        return resList;
    }


    /**
     * 3-6,之字形打印
     *
     * @return
     */
    public List zhiOrderList() {
        if (root == null) {
            return null;
        }

        ArrayList<ArrayList<Node>> resList = new ArrayList<>();
        ArrayList<Node> leverList = null;
        int leverFlag = 1;

        ArrayDeque<Node> queue1 = new ArrayDeque<>(); //存放奇数层
        ArrayDeque<Node> queue2 = new ArrayDeque<>(); //存放偶数层

        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Node temp;
            if (leverFlag % 2 != 0) {
                leverList = new ArrayList<>();
                int len = queue1.size();
                for (int i = 0; i < len; i++) {
                    temp = queue1.poll();
                    leverList.add(temp);
                    if (temp.right != null) {
                        queue2.add(temp.right);
                    }
                    if (temp.left != null) {
                        queue2.add(temp.left);
                    }
                }
            }

            if (leverFlag % 2 == 0) {
                leverList = new ArrayList<>();
                int len = queue2.size();
                for (int i = 0; i < len; i++) {
                    temp = queue2.poll();
                    leverList.add(temp);
                    if (temp.left != null) {
                        queue1.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue1.add(temp.right);
                    }
                }
            }
            resList.add(leverList);
            leverFlag++;
        }
        return resList;
    }

    /**
     * 4-1，一般二叉树前序查找
     *
     * @param localRoot
     * @param data
     * @return
     */
    public Node preOrderSearch(Node localRoot, int data) {
        if (localRoot != null) {
            if (localRoot.data == data) {
                return localRoot;
            }

            Node resNode;
            resNode = preOrderSearch(localRoot.left, data);
            if (resNode != null) {
                return resNode;
            }

            resNode = preOrderSearch(localRoot.right, data);

            return resNode;
        } else {
            return null;
        }
    }

    /**
     * 4-2，一般二叉树中序查找
     *
     * @param localRoot
     * @param data
     * @return
     */
    public Node infixOrderSearch(Node localRoot, int data) {
        if (localRoot != null) {

            Node resNode;
            resNode = infixOrderSearch(localRoot.left, data);

            if (localRoot.data == data) {
                return localRoot;
            }

            if (resNode != null) {
                return resNode;
            }

            resNode = infixOrderSearch(localRoot.right, data);

            return resNode;
        } else {
            return null;
        }
    }


    /**
     * 4-3，一般二叉树后序查找
     *
     * @param localRoot
     * @param data
     * @return
     */
    public Node posOrderSearch(Node localRoot, int data) {
        if (localRoot != null) {

            Node resNode;
            resNode = posOrderSearch(localRoot.left, data);

            if (resNode != null) {
                return resNode;
            }

            resNode = posOrderSearch(localRoot.right, data);

            if (localRoot.data == data) {
                return localRoot;
            }

            return resNode;
        } else {
            return null;
        }
    }


    /**
     * 4-4, 一般二叉树查找父节点。不是二叉排序树
     *
     * @param localRoot
     * @param data
     * @return
     */
    public Node btTreeParentSearch(Node localRoot, int data) {
        if (localRoot != null) {

            if ((localRoot.left != null && localRoot.left.data == data)
                    || (localRoot.right != null && localRoot.right.data == data)) {
                return localRoot;
            }

            Node resNode;
            resNode = btTreeParentSearch(localRoot.left, data);

            if (resNode != null) {
                return resNode;
            }
            resNode = btTreeParentSearch(localRoot.right, data);

            return resNode;
        } else {
            return null;
        }
    }

    /**
     * 4-5，排序二叉树搜索
     *
     * @param localRoot
     * @param data
     * @return
     */
    public Node bstTreeSearch(Node localRoot, int data) {
        if (localRoot != null) {
            if (data == localRoot.data) {
                return localRoot;
            } else if (data < localRoot.data) {
                return bstTreeSearch(localRoot.left, data);
            } else {
                return bstTreeSearch(localRoot.right, data);
            }
        } else {
            return null;
        }
    }


    //4-6，二叉排序树查找父节点
    public Node bstTreeParentSearch(Node localRoot, int data) {
        if (localRoot != null) {
            if ((localRoot.left != null && localRoot.left.data == data)
                    || (localRoot.right != null && localRoot.right.data == data)) {
                return localRoot;
            } else if (data < localRoot.data) {
                return bstTreeParentSearch(localRoot.left, data);
            } else {
                return bstTreeParentSearch(localRoot.right, data);
            }
        } else {
            return null;
        }
    }
    
    
    //4-7,查找二叉排序树两个节点的最近公共祖先
    public Node lowestCommonAncestorForBstTreeSearch(Node localRoot, Node node1, Node node2) {
        //localRoot == node1 || localRoot == node2，说明其中一个就是最近公共祖先
        if (localRoot == null || localRoot == node1 || localRoot == node2){
            return localRoot;
        }

        if (node1.data < localRoot.data && node2.data < localRoot.data){
            return lowestCommonAncestorForBstTreeSearch(localRoot.left, node1, node2);
        }


        if (node1.data > localRoot.data && node2.data > localRoot.data ){
            return lowestCommonAncestorForBstTreeSearch(localRoot.right, node1, node2);
        }

        return localRoot;  //如果两个节点的值都不小于或者大于当前节点，那么当前节点就是最近根节点
    }

    //4-8-1,查找一般二叉树两个节点的最近公共祖先（递归）
    public Node lowestCommonAncestorSearchBaseRec(Node localRoot, Node node1, Node node2) {
        if (localRoot == null || localRoot == node1 || localRoot == node2){
            return localRoot;
        }
        Node left = lowestCommonAncestorSearchBaseRec(localRoot.left, node1, node2);
        Node right = lowestCommonAncestorSearchBaseRec(localRoot.right, node1, node2);
        //如果找到之后，当前节点的子左节点为空，那么返回子右节点，直到都不为空的节点，那么那个节点就是共同祖先
        if (left == null) {
            return right;
        }
        if (right == null){
            return left;
        }
        return localRoot;
    }

    //4-8-2,查找一般二叉树两个节点的最近公共祖先（非递归）
    public Node lowestCommonAncestorSearchBase(Node localRoot, Node node1, Node node2) {
        if (localRoot == null || node1 == null || node2 == null){
            return null;
        }
        List<Node> pathp = new ArrayList<>();
        List<Node> pathq = new ArrayList<>();
        pathp.add(localRoot);
        pathq.add(localRoot);

        getPath(localRoot, node1, pathp);
        getPath(localRoot, node2, pathq);

        Node lca = null;
        //最后一个相等的就是公共父节点
        for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {
            if (pathp.get(i) == pathq.get(i)) {
                lca = pathp.get(i);
            } else {
                break;
            }
        }
        return lca;
    }

    /**
     * 4-9,给定一棵二叉搜索树，请找出其中的第k小的结点
     */
    private int count = 0;
    private Node result;

    Node KthNode(Node localRoot, int k) {
        //每次都返回一个节点很复杂，
        //所以，我可以就是进行中序遍历，然后达到k的时候就记录一下节点
        //已经找到的时候，后面就不必遍历了，就一直return就可以了
        infixOrder(localRoot, k);
        return result;
    }

    private void infixOrder(Node localRoot, int k) {
        if (localRoot == null || count >= k) {
            return;
        }
        infixOrder(localRoot.left, k);
        //中序遍历意味着count++这部分代码要在中间执行
        count++;
        if (count == k) {
            result = localRoot;
            return;
        }
        infixOrder(localRoot.right, k);
    }

    /**
     * 5-1,获取当前节点为根节点的树的最大高度
     *
     * @param localRoot
     * @return
     */
    public int getLocalRootMaxHeight(Node localRoot) {
        if (localRoot == null) {
            return 0;
        } else {
            return Math.max(getLocalRootMaxHeight(localRoot.left), getLocalRootMaxHeight(localRoot.right)) + 1;
        }
    }

    /**
     * 5-2,获取当前节点为根节点的树的最小深度
     *
     * @param localRoot
     * @return
     */

    public int getLocalRootMinDepth(Node localRoot) {
        if (localRoot == null) {
            return 0;
        } else {
            int left = (getLocalRootMinDepth(localRoot.left)) + 1;
            if (localRoot.left == null) {
                left--;
            }
            int right = (getLocalRootMinDepth(localRoot.right)) + 1;
            if (localRoot.right == null) {
                right--;
            }

            if (left != 0 && right == 0) {
                return left;
            } else if (right != 0 && left == 0) {
                return right;
            } else {
                return Math.min(left, right);
            }
        }
    }


    /**
     * 5-3,获取当前节点为根节点的树的最小高度
     *
     * @param localRoot
     * @return
     */
    public int getLocalRootMinHeight(Node localRoot) {
        return getLocalRootMinDepth(localRoot) + 1;
    }


    /**
     *5-4，获取当前节点数的最大直径
     * @param localRoot
     * @return
     */
    public int getDiameter(Node localRoot){
        int left = getLocalRootMaxHeight(localRoot.left);
        int right = getLocalRootMaxHeight(localRoot.right);
        return left + right;
    }
    
    

    /**
     * 6-1, 获取节点数量
     *
     * @param localRoot
     * @return
     */
    public int getNodeNum(Node localRoot) {
        if (localRoot == null) {
            return 0;
        } else {
            int left = getNodeNum(localRoot.left) + 1;
            if (localRoot.left == null) {
                left--;
            }
            int right = getNodeNum(localRoot.right) + 1;
            if (localRoot.right == null) {
                right--;
            }

            if (localRoot != root) {
                return left + right;
            } else {
                return left + right + 1;
            }

        }

//        if (localRoot == null) {
//            return 0;
//        } else {
//            int num = getNodeNumRec(localRoot.left) + getNodeNumRec(localRoot.right) + 1; //后序遍历
//            return num;
//        }
    }

    /**
     * 6-2,获取第K层的节点数量
     *
     * @param localRoot
     * @param leverK
     * @return
     */
    public int getLeverKNodeNum(Node localRoot, int leverK) {
        if (localRoot == null || leverK <= 0) {
            return 0;
        } else {
            if (leverK == 1) {
                return 1;     //在终点处处理
            }
            return getLeverKNodeNum(localRoot.left, leverK - 1)
                    + getLeverKNodeNum(localRoot.right, leverK - 1); //后序遍历
        }
    }

    /**
     * 7-1,判断两棵树是否相同
     * @param localRoot1
     * @param localRoot2
     * @return
     */
    public boolean isSamTree(Node localRoot1, Node localRoot2) {
        if (localRoot1 == null && localRoot2 == null) {
            return true;
        }

        if (localRoot1 == null || localRoot2 == null) {
            return false;
        }


        //相等时继续，不宜利用中序截取变量进行判断
        if (localRoot1.data == localRoot2.data){
            return isSamTree(localRoot1.left, localRoot2.left) && isSamTree(localRoot1.right, localRoot2.right);
        }

        return false;
    }

    /**
     * 7-2,判断是否是平衡二叉树
     * @param localRoot
     * @return
     */
    public boolean isAvlTree(Node localRoot) {
        if (localRoot == null) {
            return true;
        }

        return Math.abs(getLocalRootMaxHeight(localRoot.left) - getLocalRootMaxHeight(localRoot.right)) <= 1
                && isAvlTree(localRoot.left) && isAvlTree(localRoot.right);
    }


    /**
     * 7-3,判断是否是镜像二叉树
     * @param root
     * @return
     */
    public boolean isSymmetricTree(Node root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }
    public boolean isSymmetricHelper(Node left, Node right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.data == right.data){
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        }
        return false;
    }


    /**
     * 7-4, 判断一个树是不是完全二叉树
     * @param localRoot
     * @return
     */
    public boolean isCompleteTree(Node localRoot) {
        if (localRoot == null) {
            return false;
        }

        boolean hasLeaf = false;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(localRoot);
        //首先下沉到最后一层，
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (tmp.left == null) {  //左子节点为空
                if (tmp.right != null) {  //右子节点不为空时，不是满二叉树
                    return false;
                } else {
                    hasLeaf = true;  //右子节点为空时，说明是叶子节点
                }
            } else {  //左子节点不为空，此时如果有右子节点，，那么说明不是完全二叉树
                if (hasLeaf) {
                    return false;
                }
                if (tmp.right == null) {
                    hasLeaf = true;       //当前节点有左边节点
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {  //当右边的子叶不为空，即添加其下一层左右子叶
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }
        }
        return true;
    }


    /**
     * 7-5，判断第二颗树是否是第一颗树的子树
     * @param root1localRoot
     * @param root2
     * @return
     */
    public boolean isSubtree(Node root1localRoot, Node root2) {
        boolean result = false;
        if (root1localRoot != null && root2 != null) {
            if (root1localRoot.data == root2.data) {  //如果值相等，那么就要判断剩余的值是否全相等
                result = checkNext(root1localRoot, root2); //1,先判断两棵树是否是子树关系
            }
            if (!result) {  //如果checkNext直到是真的，那么直接跳过递归
                result = isSubtree(root1localRoot.left, root2); //如果不是，向左递归
            }
            if (!result) { //如果checkNext直到是真的，那么直接跳过递归
                result = isSubtree(root1localRoot.right, root2); //如果不是，向右递归
            }
        }
        return result;
    }

    private boolean checkNext(Node root1localRoot, Node root2) {
        if (root2 == null){
            return true;
        }
        if (root1localRoot == null){
            return false;
        }
        if (root1localRoot.data != root2.data){
            return false;
        }

        //相等时跳过去遍历，直到遍历到尾部root2 = null，如果一切顺利，说明值完全相同。后序遍历。
        return checkNext(root1localRoot.left, root2.left) && checkNext(root1localRoot.right, root2.right);
    }
    
    
    /**
     * 8-1,求二叉树的镜像（反转二叉树）
     * @param localRoot
     * @return
     */
    public Node invertTree(Node localRoot) {
        if (localRoot == null) {
            return localRoot;
        }else{
            Node leftNodeTemp = localRoot.left;
            localRoot.left = invertTree(localRoot.right);
            localRoot.right = invertTree(leftNodeTemp);

            return localRoot;
        }
    }

    //8-2，由前序遍历序列和中序遍历序列重建二叉树
    public Node buildTreeBypreOrderAndInfixOrder(int[] preOrder, int[] infixOrder) {
        if (preOrder.length == 0 || infixOrder.length == 0){
            return null;
        }
        return buildTreeHelper01(preOrder, 0, preOrder.length - 1, infixOrder, 0, infixOrder.length - 1);
    }

    private Node buildTreeHelper01(int[] preOrder, int preStart, int preEnd, int[] infixOrder, int infixStart, int infixEnd) {
        if (preStart > preEnd || infixStart > infixEnd){
            return null;
        }
        Node root = new Node(preOrder[preStart]);
        for (int i = infixStart; i <= infixEnd; i++) {
            //找到中序中的根节点，找到之后前序节点++，
            if (infixOrder[i] == preOrder[preStart]) {
                // 左子树的长度：i-is
                //构建左子树
                root.left = buildTreeHelper01(preOrder, preStart + 1, preStart + i - infixStart, infixOrder, infixStart, i - 1);
                //构建右子树
                root.right = buildTreeHelper01(preOrder, preStart + i - infixStart + 1, preEnd, infixOrder, i + 1, infixEnd);
            }
        }
        return root;
    }

    //8-3，由中序遍历序列和后序遍历序列重建二叉树
    public Node buildTreeByInfxOrderAndPosOrder(int[] infixOrder, int[] posOrder) {
        if (infixOrder.length == 0 || posOrder.length == 0){
            return null;
        }
        return buildTreeHelper02(infixOrder, 0, infixOrder.length - 1, posOrder, 0, posOrder.length - 1);
    }

    private Node buildTreeHelper02(int[] infixOrder, int infixStart, int infixEnd, int[] posOrder, int posStart, int posEnd) {
        if (infixStart > infixEnd || posStart > posEnd){
            return null;
        }
        Node root = new Node(posOrder[posEnd]);
        for (int i = infixStart; i <= infixEnd; i++) {
            if (infixOrder[i] == posOrder[posEnd]) {
                root.left = buildTreeHelper02(infixOrder, infixStart, i - 1, posOrder, posStart, posStart + i - infixStart - 1);
                root.right = buildTreeHelper02(infixOrder, i + 1, infixEnd, posOrder, posStart + i - infixStart, posEnd - 1);
            }
        }
        return root;
    }
    
    /**
     * 9-1,求给定两个节点的路径
     * @param localRoot
     * @param tailNode
     * @param path
     * @return
     */
    public boolean getPath(Node localRoot, Node tailNode, List<Node> path) {
        if (localRoot == tailNode) {
            return true;
        }

        if (localRoot.left != null) {
            path.add(localRoot.left);
            if (getPath(localRoot.left, tailNode, path)) {
                return true;
            }
            path.remove(path.size() - 1); //如果不对就删除该节点，回退。跟踪递归一定要学会跟踪函数栈。
        }

        if (localRoot.right != null) {
            path.add(localRoot.right);
            if (getPath(localRoot.right, tailNode, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }

        return false;
    }


    /**
     * 9-2,直到值等于某个给定值的从根节点到叶子的所有路径
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> getAllPathsEqVal(Node localRoot, int target) {
        //如果是空就返回
        if (localRoot == null) {
            return res;
        }
        //如果数值相等了也返回
        target -= localRoot.data;  //，每个栈单独存一份变量
        temp.add(localRoot.data);
        if (target == 0 /*&& root.left == null && root.right == null*/) {
            res.add(new ArrayList<>(temp));
        }
        //向左遍历
        getAllPathsEqVal(localRoot.left, target);

        //向右遍历
        getAllPathsEqVal(localRoot.right, target);

        //如果找到不到，就删除当前临时变量
        temp.remove(temp.size() - 1); //两个都会函数都会执行到这一行代码

        return res;
    }

    /**
     * 10-1.序列化
     * @param localRoot
     * @return
     */
    public String serialize(Node localRoot) {
        if (localRoot == null){
            return "#,";
        }else{
            StringBuffer resSb = new StringBuffer(localRoot.data + ","); //前序添加：最终是前序添加
            resSb.append(serialize(localRoot.left));  //中序添加
            resSb.append(serialize(localRoot.right)); //后序添加
            return resSb.toString();
        }
    }

    /**
     * 10-2,反序列化
     * @param data
     * @return
     */
    public Node deSerialize(String data) {
        String[] d = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < d.length; i++) {
            queue.offer(d[i]);
        }
        return pre(queue);
    }
    private Node pre(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")){
            return null;
        }
        //前序中序后序倒数插入
        Node node = new Node(Integer.parseInt(val));
        node.left = pre(queue);
        node.right = pre(queue);
        return node;
    }
    
    /**
     * *******************************************构建平衡二叉树***********************************************
     * 
     *******************************************************************************************************/
    public void addAsAvlTree(Node localNode, int data) {
        //首先添加节点，然后再判断是否要旋转
        add(localNode, data);

        if (root.left == null && root.right == null){
            return;
        }

        //当添加完一个节点后，如果(右子树的高度 - 左子树的高度) > 1，左旋
        if (getLocalRootMaxHeight(localNode.right) - getLocalRootMaxHeight(localNode.left) > 1) {
            //如果当前节点的右子树的左子树的高度大于它的右子树的高度
            //那么先对当前节点的右子树进行右旋，再对当前节点进行左旋
            if (localNode.right != null && getLocalRootMaxHeight(localNode.right.left) > getLocalRootMaxHeight(localNode.right.right)) {
                //先对当前节点的右子节点进行右旋
                rightRotate(localNode.right);
                //再对当前的节点进行左旋
                leftRotate(localNode);
            } else {
                leftRotate(localNode);
            }
        }

        if (getLocalRootMaxHeight(localNode.left) - getLocalRootMaxHeight(localNode.right) > 1) {
            //如果当前节点的左子树的右子树的高度大于它的左子树的高度
            //那么先对当前节点的左子树进行左旋，再对当前节点进行右旋
            if (localNode.left != null && getLocalRootMaxHeight(localNode.left.right) > getLocalRootMaxHeight(localNode.left.left)) {
                //先当前节点的左节点行左旋转
                leftRotate(localNode.left);
                //再对当前节点进行右旋
                rightRotate(localNode);
            } else {
                rightRotate(localNode);
            }
        }
    }


    public void buildAvlTree(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            addAsAvlTree(root, arr[i]);
        }
    }

    //2-1，左旋方法
    public void leftRotate(Node curNode) {

        //创建新节点
        Node newNode = new Node(curNode.data);

        //把新的节点的左子树设置成当前节点的左子树
        newNode.left = curNode.left;
        //把新的节点的左子树设置成当前节点的右子树的左子树
        newNode.right = curNode.right.left;

        //把当前节点的值替换成其右子节点的值
        curNode.data = curNode.right.data;

        //把当前节点的右子树设置成其右子树的右子树
        curNode.right = curNode.right.right;
        //把当前节点的左子树（左子节点）设置成新的节点
        curNode.left = newNode;
    }

    //2-2，左旋方法
    public void rightRotate(Node curNode) {
        //创建新节点
        Node newNode = new Node(curNode.data);
        newNode.right = curNode.right;
        newNode.left = curNode.left.right;


        curNode.data = curNode.left.data;

        curNode.left = curNode.left.left;
        //把当前节点的左子树（左子节点）设置成新的节点
        curNode.right = newNode;
    }

}


class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

