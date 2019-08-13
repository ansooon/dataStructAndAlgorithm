package datastruct.tree.bstTreeIntigram;

import java.util.*;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-12 17:43
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {

        int[] arr = {10, 11, 7, 6, 8, 9};
//        int[] arr = {10, 11, 7, 6, 8};
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree binaryTree2 = new BinaryTree();

        //1，增加
        for (int i = 0; i < arr.length; i++) {
            //1-1，非递归添加
//            binaryTree.add(arr[i]);
            //1-2，递归添加
            binaryTree.addByRecr(arr[i]);
            //1-3，递归添加成平衡树
//            binaryTree.addByRecrAsAvl(arr[i]);
            binaryTree2.addByRecr(arr[i]);
        }
        System.out.println("前序遍历");
        binaryTree.preOrderList();
        System.out.println("中序遍历");
        binaryTree.infixOrderList();
        System.out.println("后序遍历");
        binaryTree.posOrderList();


        System.out.println("树的高度=" + binaryTree.treeHeight());
        System.out.println("左子树的高度=" + binaryTree.leftHeight(binaryTree.root));
        System.out.println("右子树的高度=" + binaryTree.rightHeight(binaryTree.root));
        System.out.println("最小高度为" + binaryTree.getTreeMinDepth());
        System.out.println("数的总节点数为" + binaryTree.getNodeNumRec());
        System.out.println("从上至下分层顺序打印" + binaryTree.levelOrderList());
        System.out.println("根节点为" + binaryTree.root);
        System.out.println("第k层的节点个数" + binaryTree.getKLevelNodeNums(binaryTree.root, 2));
        System.out.println("第k层的叶子节点个数" + binaryTree.getKLevelLeafNodeNums(binaryTree.root, 5));
        System.out.println("判断是否是同一个颗树" + binaryTree.isSameTree(binaryTree, binaryTree2));
        System.out.println("判断是否是平衡二叉树" + binaryTree.isAvlTree(binaryTree.root));
        binaryTree.invertTree(binaryTree.root);
        System.out.println("从上至下分层顺序打印" + binaryTree.levelOrderList());
        System.out.println("判断两棵树是否是镜像数" + binaryTree.isSymmetricTrees(binaryTree, binaryTree2));
        System.out.println("二叉树中两个节点最近的共同祖先" + binaryTree.lowestCommonAncestorBaseRec(binaryTree.root, binaryTree.search(6), binaryTree.search(9)));
        System.out.println("二叉树中两个节点最近的共同祖先" + binaryTree.lowestCommonAncestor(binaryTree.root, binaryTree.search(6), binaryTree.search(9)));
        System.out.println("二叉树中两个节点最近的共同祖先" + binaryTree.lowestCommonAncestorForBst(binaryTree.root, new Node(6), new Node(9)));
        System.out.println("求二叉树的最长直径" + binaryTree.diameterOfBinaryTree(binaryTree.root));
        System.out.println("判断是否是完全二叉树" + binaryTree.isCompleteTree(binaryTree.root));
        System.out.println("输出第K小的节点" + binaryTree.KthNode(binaryTree.root, 1));
        System.out.println("序列化" + binaryTree.serialize(binaryTree.root));


        //重构二叉树
        int[] preOrder = {10, 7, 6, 8, 9, 11};
        int[] infixOrder = {6, 7, 8, 9, 10, 11};
        int[] posOrder = {6, 9, 8, 7, 11, 10};
        //根据前序和中序重建树
//        Node root = binaryTree.buildTreeBypreOrderAndInfixOrder(preOrder, infixOrder);
//        BinaryTree binaryTreeNew = new BinaryTree(root);
//        binaryTreeNew.infixOrderList();
//        System.out.println(binaryTreeNew.getRoot());

        //根据中序和后序重建树
//        Node root1 = binaryTree.buildTreeByInfxOrderAndPosOrder(infixOrder, posOrder);
//        BinaryTree binaryTreeNew1 = new BinaryTree(root1);
//        binaryTreeNew1.infixOrderList();
//        System.out.println(binaryTreeNew1.getRoot().left);


        //遍历
//        binaryTree.preOrderList();
//        binaryTree.infixOrderList();
//        binaryTree.posOrderList();

//        //2-1，前序查找
//        System.out.println(binaryTree.preOrderSearch(1));
//
//        //2-2，中序查找
//        System.out.println(binaryTree.infixOrderSearch(1));
//
//        //2-3，后序查找
//        System.out.println(binaryTree.posOrderSearch(1));
//
//        //2-4，一般查找
//        System.out.println(binaryTree.posOrderSearch(8));
//
//        //2-5,查找父节点
//        System.out.println(binaryTree.searchParent(1));


        //3，删除
//        binaryTree.delete(7);
//        binaryTree.infixOrderList();


    }
}


class BinaryTree {
    Node root;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    //1-1，非递归添加
    public void add(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node cur = root;
            Node parent;
            while (true) {  //寻找插入位置
                parent = cur;
                if (data < cur.data) {
                    cur = cur.left;
                    if (cur == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    cur = cur.right;
                    if (cur == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    //1-2，递归添加
    public void addByRecr(Node localRoot, int data) {
        if (data < localRoot.data) {
            if (localRoot.left == null) {
                localRoot.left = new Node(data);
            } else {
                addByRecr(localRoot.left, data);
            }
        } else {
            if (localRoot.right == null) {
                localRoot.right = new Node(data);
            } else {
                addByRecr(localRoot.right, data);
            }
        }
    }

    public void addByRecr(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            this.addByRecr(root, data);
        }
    }


    //1-3，递归添加成平衡树
    public void addByRecrAsAvl(Node localNode, int data) {
        //首先添加节点，然后再判断是否要旋转
        addByRecr(localNode, data);

        //当添加完一个节点后，如果(右子树的高度 - 左子树的高度) > 1，左旋
        if (rightHeight(localNode) - leftHeight(localNode) > 1) {
            //如果当前节点的右子树的左子树的高度大于它的右子树的高度
            //那么先对当前节点的右子树进行右旋，再对当前节点进行左旋
            if (localNode.right != null && leftHeight(localNode.right) > rightHeight(localNode.right)) {
                //先对当前节点的右子节点进行右旋
                rightRotate(localNode.right);
                //再对当前的节点进行左旋
                leftRotate(localNode);
            } else {
                leftRotate(localNode);
            }
        }

        if (leftHeight(localNode) - rightHeight(localNode) > 1) {
            //如果当前节点的左子树的右子树的高度大于它的左子树的高度
            //那么先对当前节点的左子树进行左旋，再对当前节点进行右旋
            if (localNode.left != null && rightHeight(localNode.left) > leftHeight(localNode.left)) {
                //先当前节点的左节点行左旋转
                leftRotate(localNode.left);
                //再对当前节点进行右旋
                rightRotate(localNode);
            } else {
                rightRotate(localNode);
            }
        }
    }

    public void addByRecrAsAvl(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            this.addByRecrAsAvl(root, data);
        }

    }


    //2-1，前序遍历
    public void preOrderList(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot);
            preOrderList(localRoot.left);
            preOrderList(localRoot.right);
        }
    }


    public void preOrderList() {
        if (root == null) {
            System.out.println("空树");
        } else {
            this.preOrderList(root);
        }
    }

    //2-1-1，前序遍历,非递归
    public List<Integer> preOrderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.data);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }

    //2-2,中序遍历
    public void infixOrderList(Node localRoot) {
        if (localRoot != null) {
            infixOrderList(localRoot.left);
            System.out.println(localRoot);
            infixOrderList(localRoot.right);
        }
    }

    public void infixOrderList() {
        if (root == null) {
            System.out.println("空树");
        } else {
            this.infixOrderList(root);
        }
    }

    //2-2-1，中序遍历，非递归
    public List<Integer> infixOrderTraversal() {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<Node> stack = new Stack<Node>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.data);
                cur = cur.right;
            }
        }
        return res;
    }

    //2-3,后序遍历
    public void posOrderList(Node localRoot) {
        if (localRoot != null) {
            posOrderList(localRoot.left);
            posOrderList(localRoot.right);
            System.out.println(localRoot);
        }
    }


    public void posOrderList() {
        if (root == null) {
            System.out.println("空树");
        } else {
            this.posOrderList(root);
        }
    }

    //2-3-1，后序遍历，非递归
    public List<Integer> posOrderTraversal(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                result.addFirst(cur.data);    // Reverse the process of preOrder
                cur = cur.right;             // Reverse the process of preOrder
            } else {
                Node node = stack.pop();
                cur = node.left;            // Reverse the process of preOrder
            }
        }
        return result;
    }

    //2-4，从上至下分层顺序遍历
    public List levelOrderList() {

        List<List<Integer>> res = new ArrayList<>();
        //如果为空就返回
        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        Node cur;
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {  //每一层先进先出
                cur = queue.poll();
                level.add(cur.data);
                if (cur.left != null)   //每次遍历时，将左边线添加进队列，先进先出
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right); //每次遍历时，将右边线添加进队列，先进先出
            }
            res.add(level);
        }
        return res;
    }

    //2-5，从下往上分层顺序遍历
    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                temp.add(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 每次都添加到第一个位置
            res.add(0, temp);
        }
        return res;
    }

    /**
     * 2-6,之字形打印
     * 设两个栈，s2存放奇数层，s1存放偶数层
     * 遍历s2节点的同时按照左子树、右子树的顺序加入s1，
     * 遍历s1节点的同时按照右子树、左子树的顺序加入s2
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(Node pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        int flag = 1;

        if (pRoot == null) {
            return res;
        }

        s2.push(pRoot);

        ArrayList<Integer> temp = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (flag % 2 != 0) {
                while (!s2.isEmpty()) {
                    Node node = s2.pop();
                    temp.add(node.data);
                    if (node.left != null) {
                        s1.push(node.left);
                    }
                    if (node.right != null) {
                        s1.push(node.right);
                    }
                }
            }
            if (flag % 2 == 0) {
                while (!s1.isEmpty()) {
                    Node node = s1.pop();
                    temp.add(node.data);
                    if (node.right != null) {
                        s2.push(node.right);
                    }
                    if (node.left != null) {
                        s2.push(node.left);
                    }
                }
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
            flag++;
        }
        return res;
    }


    //3-1,前序查询
    public Node preOrderSearch(Node localRoot, int data) {
        Node resNode = null;

        if (localRoot.data == data) {
            return localRoot;
        }

        if (localRoot.left != null) {
            resNode = preOrderSearch(localRoot.left, data);
        }

        if (resNode != null) {
            return resNode;
        }

        if (localRoot.right != null) {
            resNode = preOrderSearch(localRoot.right, data);  //注意，还是要加上resNode =
        }

        return resNode;
    }

    public Node preOrderSearch(int data) {
        return this.preOrderSearch(root, data);
    }


    //3-2,中序查询
    public Node infixOrderSearch(Node localRoot, int data) {
        Node resNode = null;

        if (localRoot.left != null) {
            resNode = infixOrderSearch(localRoot.left, data);
        }

        if (localRoot.data == data) {
            return localRoot;
        }

        if (resNode != null) {
            return resNode;
        }

        if (localRoot.right != null) {
            resNode = infixOrderSearch(localRoot.right, data);  //注意，还是要加上resNode =
        }

        return resNode;
    }

    public Node infixOrderSearch(int data) {
        return this.infixOrderSearch(root, data);
    }


    //3-3,后序查询
    public Node posOrderSearch(Node localRoot, int data) {
        Node resNode = null;

        if (localRoot.left != null) {
            resNode = posOrderSearch(localRoot.left, data);
        }

        if (resNode != null) {
            return resNode;
        }

        if (localRoot.right != null) {
            resNode = posOrderSearch(localRoot.right, data);  //注意，还是要加上resNode =
        }

        if (localRoot.data == data) {
            return localRoot;
        }

        return resNode;
    }

    public Node posOrderSearch(int data) {
        return this.posOrderSearch(root, data);
    }


    //3-4.一般查找
    public Node search(Node localRoot, int data) {
        if (data == localRoot.data) {
            return localRoot;
        } else if (data < localRoot.data) {
            if (localRoot.left == null) {
                return null;
            }
            return search(localRoot.left, data);
        } else {
            if (localRoot.right == null) {
                return null;
            }
            return search(localRoot.right, data);
        }
    }

    public Node search(int data) {
        if (root == null) {
            return null;
        } else {
            return search(root, data);
        }
    }

    //3-5，查找父节点
    public Node searchParent(Node localRoot, int data) {
        if ((localRoot.left != null && localRoot.left.data == data)
                || (localRoot.right != null && localRoot.right.data == data)) {
            return localRoot;
        } else {
            if (data < localRoot.data && localRoot.left != null) {
                return searchParent(localRoot.left, data);
            } else if (data >= localRoot.data && localRoot.right != null) {
                return searchParent(localRoot.right, data);
            } else {
                return null;
            }
        }
    }

    public Node searchParent(int data) {
        if (root == null) {
            return null;
        } else {
            return searchParent(root, data);
        }
    }


    //4，删除
    public void delete(int data) {
        //查找删除节点
        Node cur = search(data);

        //如果找不到当前，那么久马上返回
        if (cur == null) {
            return;
        }

        //此时，找到节点
        //先判断有没有父节点,如果没有父节点，那么就将当前唯一节点删除
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        Node parent = searchParent(data);

        //此时，已经找到当前节点和父节点，分三种情况进行：叶子节点，有一个子节点，有两个子节点
        //当时叶子节点时
        if (cur.left == null && cur.right == null) {
            //如果是左节点
            if (parent.left != null && parent.left.data == data) {
                parent.left = null;
            } else if (parent.right != null && parent.right.data == data) {
                parent.right = null;
            }
            //当有两个子节点时
            //只需找到删除节点的右子树的最小值，并将该值赋给删除节点，并删除该最小值的节点即可。
        } else if (cur.left != null && cur.right != null) {
            int minData = deleteRightTreeMin(cur.right);
            cur.data = minData;
        } else {
            //如果要删除的节点有左节点,也就是当删除的节点只有左节点时，父节点的左/右节点（需判断）需分别需指向当前删除节点的左节点.
            if (cur.left != null) {
                //如果只有一个root节点及其唯一节点
                if (parent != null) {
                    //如果删除节点的父节点是父节点的左节点
                    if (parent.left.data == data) {
                        parent.left = cur.left;  //一定为左节点
                    } else {
                        parent.right = cur.left; //一定为左节点
                    }
                } else {
                    root = cur.left; //此时cur.left = null
                }
                ///如果要删除的节点有右节点,也就是当删除的节点只有右节点时
            } else {
                if (parent != null) {
                    //如果删除节点的父节点是父节点的左节点
                    if (parent.left.data == data) {
                        parent.left = cur.right; //一定为右节点
                    } else {
                        parent.right = cur.right; //一定为右节点
                    }
                } else {
                    root = cur.right;
                }

            }

        }
    }


    /**
     * 1,返回的以node为根节点的二叉排序树的最小节点的值
     * 2,删除node为根节点的二叉排序树的最小节点
     *
     * @param node
     * @return
     */
    public int deleteRightTreeMin(Node node) {
        Node cur = node;
        //循环的查找到左节点，就会找到最小值
        while (cur.left != null) {
            cur = cur.left;
        }

        //这时cur指向最小节点
        //删除最小节点，此时删除节点的方法将会按照最小节点为叶子结点进行删除
        delete(cur.data);

        return cur.data;
    }


    //5-1求数的高度
    public int treeHeight() {
        return height(root);
    }

    //5-2，求当前节点的左支的高度
    public int leftHeight(Node localRoot) {
        if (localRoot.left == null) {
            return 0;
        } else {
            return height(localRoot.left);
        }
    }

    //5-3.求当前节点的右支的高度
    public int rightHeight(Node localRoot) {
        if (localRoot.right == null) {
            return 0;
        } else {
            return height(localRoot.right);
        }
    }

    //求当前节点的高度？少加了一个localNode非空判断，因此只能用来求root节点不为空的整棵树的高度
    public int height(Node localNode) {
        return Math.max(localNode.left == null ? 0 : height(localNode.left),
                localNode.right == null ? 0 : height(localNode.right)) + 1;
    }

    //5-4，求当前节点的为根节点的树的高度
    public int maxHigh(Node localNode) {
        if (localNode == null)
            return 0;
        return Math.max(maxHigh(localNode.left), maxHigh(localNode.right)) + 1;
    }

    //5-5,求当前节点的最小高度
    public int getMinDepth(Node localRoot) {
        if (localRoot == null) {
            return 0;
        }

        int leftDepth = getMinDepth(localRoot.left);
        int rightDepth = getMinDepth(localRoot.right);
        if (leftDepth == 0 && rightDepth > 0) {
            return rightDepth + 1;
        } else if (rightDepth == 0 && leftDepth > 0) {
            return leftDepth + 1;
        } else {
            return (leftDepth < rightDepth) ? leftDepth + 1 : rightDepth + 1;
        }
    }

    //5-5-1，求树的最小深度
    public int getTreeMinDepth() {
        return getMinDepth(root);
    }


    //6-1，左旋方法
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

    //6-2，左旋方法
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

    //7-1,求某个节点下面的节点个数
    public int getNodeNumRec(Node localRoot) {
        if (localRoot == null) {
            return 0;
        } else {
            return getNodeNumRec(localRoot.left) + getNodeNumRec(localRoot.right) + 1;
        }
    }

    //7-1-1,求数的节点的个数
    public int getNodeNumRec() {
        return getNodeNumRec(root);
    }


    //7-2，第k层的节点个数
    public int getKLevelNodeNums(Node localRoot, int k) {
        if (localRoot == null || k < 0) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getKLevelNodeNums(localRoot.left, k - 1) + getKLevelNodeNums(localRoot.right, k - 1);
    }

    //7-3，第k层的叶子节点个数
    public int getKLevelLeafNodeNums(Node localRoot, int k) {
        if (localRoot == null || k < 0) {
            return 0;
        }

        if (k == 1) {
            if (localRoot.left == null && localRoot.right == null) {
                return 1;
            } else {
                return 0;
            }

        }

        return getKLevelLeafNodeNums(localRoot.left, k - 1) + getKLevelLeafNodeNums(localRoot.right, k - 1);
    }


    //8-1判断两棵树是否相同
    public boolean isSameTree(Node localRoot1, Node localRoot2) {
//        Node root1 = Tree1.root;
//        Node root2 = Tree2.root;

        if (localRoot1 == null && localRoot2 == null) {
            return true;
        }
        if (localRoot1 == null || localRoot2 == null) {
            return false;
        }

        if (localRoot1.data == localRoot2.data) {
            return isSameTree(localRoot1.left, localRoot2.left) && isSameTree(localRoot1.right, localRoot2.right);
        }

        return false;
    }


    public boolean isSameTree(BinaryTree tree1, BinaryTree tree2) {
        return this.isSameTree(tree1.root, tree2.root);
    }


    //8-2，判断是否是平衡二叉树
    public boolean isAvlTree(Node localRoot) {
        if (localRoot == null) {
            return true;
        }

        return Math.abs(maxHigh(localRoot.left) - maxHigh(localRoot.right)) <= 1
                && isAvlTree(localRoot.left) && isAvlTree(localRoot.right);
//        return Math.abs(leftHeight(localRoot) - rightHeight(localRoot)) <= 1
//                && isAvlTree(localRoot.left) && isAvlTree(localRoot.right);
//        return Math.abs(height(localRoot.left) - height(localRoot.right)) <= 1
//                && isAvlTree(localRoot.left) && isAvlTree(localRoot.right);
    }


    //9-1，求二叉树的镜像（反转二叉树）
    public Node invertTree(Node localRoot) {
        if (localRoot == null) {
            return localRoot;
        }

        Node leftTempNode = localRoot.left;
        localRoot.left = invertTree(localRoot.right);
        localRoot.right = invertTree(leftTempNode);

        return localRoot;
    }

    //9-2,判断两棵树是否是镜像对称的
    public boolean isSymmetricTrees(BinaryTree tree1, BinaryTree tree2) {
        //首先取得其中一棵树的镜像数
        invertTree(tree1.root);

        //判断是不是同一颗树
        return isSameTree(tree1, tree2);
    }

    //9-3,判断一棵树是否是镜像对称的（不改变数的数据结构）
    public boolean isSymmetricTrees(Node root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(Node left, Node right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.data != right.data)
            return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }


    //10-1，二叉搜索树的最低共同父节点
    public Node lowestCommonAncestorForBst(Node root, Node node1, Node node2) {
        if (root == null || root == node1 || root == node2)
            return root;

        if (root.data > node1.data && root.data > node2.data)
            return lowestCommonAncestorForBst(root.left, node1, node2);

        if (root.data < node1.data && root.data < node2.data)
            return lowestCommonAncestorForBst(root.right, node1, node2);

        else
            return root;
    }


    //10-2，求一般二叉树两节点的最低共同父节点（递归方法）
    public Node lowestCommonAncestorBaseRec(Node root, Node node1, Node node2) {
        if (root == null || root == node1 || root == node2)
            return root;
        Node left = lowestCommonAncestorBaseRec(root.left, node1, node2);
        Node right = lowestCommonAncestorBaseRec(root.right, node1, node2);
        if (left == null) //如果找到之后，当前节点的子左节点为空，那么返回子右节点，知道都不为空的节点，那么那个节点就是共同祖先
            return right;
        if (right == null)
            return left;
        return root;
    }

    //10-2-1,求一般二叉树两节点的最低共同父节点（非递归方法）
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || p == null || q == null)
            return null;
        List<Node> pathp = new ArrayList<>();
        List<Node> pathq = new ArrayList<>();
        pathp.add(root);
        pathq.add(root);

        getPath(root, p, pathp);
        getPath(root, q, pathq);

        Node lca = null;
        for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {
            if (pathp.get(i) == pathq.get(i)) {
                lca = pathp.get(i);
            } else {
                break;
            }
        }
        return lca;
    }

    //10-3求某个节点的路径
    private boolean getPath(Node root, Node n, List<Node> path) {
        if (root == n) {
            return true;
        }

        if (root.left != null) {
            path.add(root.left);
            if (getPath(root.left, n, path)) {
                return true;
            }
            path.remove(path.size() - 1); //如果不对就删除该节点，回退。跟踪递归一定要学会跟踪函数栈。
        }

        if (root.right != null) {
            path.add(root.right);
            if (getPath(root.right, n, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
        return false;
    }


    //10-1，求二叉树的直径，等于节点总个数-1
    private int diameter = 0;

    public int diameterOfBinaryTree(Node root) {
        diamHelper(root);
        return diameter;
    }

    private int diamHelper(Node root) {
        if (root == null) {
            return 0;
        }
        int left = diamHelper(root.left);
        int right = diamHelper(root.right);
        diameter = Math.max(diameter, left + right); //迭代求和
        return Math.max(left, right) + 1;
    }


    //10-1-2，分别求根节点左右两边的最大深度
    public int diameterOfBinaryTree2(Node root) {
        int leftMax = maxHigh(root.left);  //这个是最深的节点个数
        int RightMax = maxHigh(root.right);

        System.out.println(leftMax);
        System.out.println(RightMax);

        return leftMax + RightMax;
    }

    //11-1，由前序遍历序列和中序遍历序列重建二叉树
    public Node buildTreeBypreOrderAndInfixOrder(int[] preOrder, int[] infixOrder) {
        if (preOrder.length == 0 || infixOrder.length == 0)
            return null;
        return buildTreeHelper01(preOrder, 0, preOrder.length - 1, infixOrder, 0, infixOrder.length - 1);
    }

    public Node buildTreeHelper01(int[] preOrder, int preStart, int preEnd, int[] infixOrder, int infixStart, int infixEnd) {
        if (preStart > preEnd || infixStart > infixEnd)
            return null;
        Node root = new Node(preOrder[preStart]);
        for (int i = infixStart; i <= infixEnd; i++) {
            if (infixOrder[i] == preOrder[preStart]) {
                // 左子树的长度：i-is
                root.left = buildTreeHelper01(preOrder, preStart + 1, preStart + i - infixStart, infixOrder, infixStart, i - 1);
                root.right = buildTreeHelper01(preOrder, preStart + i - infixStart + 1, preEnd, infixOrder, i + 1, infixEnd);
            }
        }
        return root;
    }

    //11-2，由中序遍历序列和后序遍历序列重建二叉树
    public Node buildTreeByInfxOrderAndPosOrder(int[] infixOrder, int[] posOrder) {
        if (infixOrder.length == 0 || posOrder.length == 0)
            return null;
        return buildTreeHelper02(infixOrder, 0, infixOrder.length - 1, posOrder, 0, posOrder.length - 1);
    }

    public Node buildTreeHelper02(int[] infixOrder, int infixStart, int infixEnd, int[] posOrder, int posStart, int posEnd) {
        if (infixStart > infixEnd || posStart > posEnd)
            return null;
        Node root = new Node(posOrder[posEnd]);
        for (int i = infixStart; i <= infixEnd; i++) {
            if (infixOrder[i] == posOrder[posEnd]) {
                root.left = buildTreeHelper02(infixOrder, infixStart, i - 1, posOrder, posStart, posStart + i - infixStart - 1);
                root.right = buildTreeHelper02(infixOrder, i + 1, infixEnd, posOrder, posStart + i - infixStart, posEnd - 1);
            }
        }
        return root;
    }


    //12，判断一个树是不是完全二叉树
    public boolean isCompleteTree(Node node) {
        if (node == null) {
            return false;
        }

        boolean hasLeaf = false;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        //首先下沉到最后一层，
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (tmp.left == null) {
                if (tmp.right != null) {
                    return false;
                } else {
                    hasLeaf = true;
                }
            } else {
                if (hasLeaf) {
                    return false;
                }
                if (tmp.right == null) {
                    hasLeaf = true;
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }
        }
        return true;
    }

    //13，判断是否是子树
    public boolean hasSubtree(Node root1, Node root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.data == root2.data) {
                result = checkNext(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean checkNext(Node root1, Node root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.data != root2.data) return false;
        return checkNext(root1.left, root2.left) && checkNext(root1.right, root2.right);
    }


    //14，打印二叉树中和为某一值的所有路径（难）
    public List findPath(Node pRoot, int expectedSum) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) { //如果此树为空则直接返回
            return null;
        }
        Stack<Integer> path = new Stack<>();          //定义栈来存储一条路径
        findPath(pRoot, expectedSum, path, pathList); //调用查找方法
        return pathList;
    }


    private void findPath(Node pRoot, int expectedSum, Stack<Integer> path, List pathList) {
        if (pRoot == null) {
            return;
        }
        //判断其是不是叶子结点，如果是看其是不是等于期望值，是的话直接添加到ArrayList集合当中
        if (pRoot.left == null && pRoot.right == null) {
            if (pRoot.data == expectedSum) { //如果等于期望值，则添加到list集合中
                ArrayList<Integer> list = new ArrayList<>();
                for (int data : path) { //将路径上的值添加集合中
                    list.add(data);
                }
                list.add(pRoot.data);//将根节点值添加入集合
                pathList.add(list); //将这条路径添加到pathList集合中
            }
        } else {
            //不是叶子结点，前序遍历，将当前结点值放入path栈中
            path.push(pRoot.data);
            findPath(pRoot.left, expectedSum - pRoot.data, path, pathList);
            findPath(pRoot.right, expectedSum - pRoot.data, path, pathList);
            //在返回到父结点之前，在路径上删除当前结点的值
            path.pop();
        }
    }


    //15，给定一棵二叉搜索树，请找出其中的第k小的结点
    private int count = 0;
    private Node result;

    Node KthNode(Node pRoot, int k) {
        //每次都返回一个节点很复杂，
        //所以，我可以就是进行中序遍历，然后达到k的时候就记录一下节点
        //已经找到的时候，后面就不必遍历了，就一直return就可以了
        inOrder(pRoot, k);
        return result;
    }

    private void inOrder(Node pRoot, int k) {
        if (pRoot == null || count >= k) {
            return;
        }
        inOrder(pRoot.left, k);
        //中序遍历意味着count++这部分代码要在中间执行
        count++;
        if (count == k) {
            result = pRoot;
        }
        inOrder(pRoot.right, k);
    }


    //16-1，序列化
    public String serialize(Node root) {
        if (root == null)
            return "#,";
        StringBuffer res = new StringBuffer(root.data + ",");
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }

    //反序列化
    public Node deserialize(String data) {
        String[] d = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < d.length; i++) {
            queue.offer(d[i]);
        }
        return pre(queue);
    }

    private Node pre(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#"))
            return null;
        Node node = new Node(Integer.parseInt(val));
        node.left = pre(queue);
        node.right = pre(queue);
        return node;
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

