package datastruct.tree.avlTree;



/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-11 23:54
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
        int[] arr = {10,11,7,6,8,9};
//        int[] arr = {3,7,5,12,10,1,9,2};
        AVLTree avlTree = new AVLTree();

        //1，添加
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new TreeNode(arr[i]));
        }
        System.out.println("中序遍历");
        avlTree.infixOrderList();

        System.out.println("旋转后");
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
        System.out.println("根节点= " + avlTree.getRoot());






    }
}

class AVLTree{
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void infixOrderList(){
        if (root != null){
            root.infixOrderList();
        }else{
            System.out.println("空树");
        }
    }



    //1，添加
    public void add(TreeNode node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }

    }


    //2，删除节点
    public void deleteNode(int data){
        if(root == null){
            return;
        }else{
            TreeNode tarNode = search(data);
            if (tarNode == null){
                return;
            }
            //如果发现tarNode没有父节点，即只有根节点（只有根节点）时，删除该节点。
            if(root.left == null && root.right == null){
                root = null;
                return;
            }

            //找到删除节点的父节点
            TreeNode parNode = searchParent(data);

            //1，如果要删除的是叶子结点
            if(tarNode.left == null && tarNode.right == null){
                //判断tarNode是父节点的左子节点还是右子节点
                if(parNode.left != null && parNode.left.data == data){ //如果是左节点
                    parNode.left = null;
                }else if(parNode.right != null && parNode.right.data == data){ //如果是右节点
                    parNode.right = null;
                }
                //2，如果要删除的节点有双子节点。只需找到右子树的最小值，并将该值赋给删除节点，并删除该最小值的节点即可。
            }else if(tarNode.left != null && tarNode.right != null){
                int minData = deleteRightTreeMin(tarNode.right);
                tarNode.data = minData;

                //3，如果删除的节点只有一个子节点
            }else{
                //如果要删除的节点有左子节点
                if (tarNode.left != null){
                    if (parNode != null){//当删除的节点为根节点时，可能有问题，因此加一层判断
                        //如果删除的节点的父节点是左节点
                        if (parNode.left.data == data){
                            parNode.left = tarNode.left;
                        }else{ //如果删除的节点的父节点是右节点
                            parNode.right = tarNode.left;
                        }
                    }else{
                        root = tarNode.left;
                    }

                    //如果要删除的节点有右子节点
                }else{
                    if (parNode != null){
                        //如果删除的节点的父节点是左节点
                        if (parNode.left.data == data){
                            parNode.left = tarNode.right;
                        }else{ //如果删除的节点的父节点是右节点
                            parNode.right = tarNode.right;
                        }
                    }else{
                        root = tarNode.right;
                    }
                }
            }

        }
    }


    //查找删除节点
    private TreeNode search(int data){
        if (root == null){
            return null;
        }else{
            return root.search(data);
        }
    }

    //查找删除节点的父节点
    private TreeNode searchParent(int data){
        if (root == null){
            return null;
        }else{
            return root.searchParent(data);
        }
    }


    /**
     * 1,返回的以node为根节点的二叉排序树的最小节点的值
     * 2,删除node为根节点的二叉排序树的最小节点
     * @param node
     * @return
     */
    private int deleteRightTreeMin(TreeNode node){
        TreeNode cur = node;
        //循环的查找到左节点，就会找到最小值
        while(cur.left != null){
            cur = cur.left;
        }

        //这时cur指向最小节点
        //删除最小节点，此时删除节点的方法将会按照最小节点为叶子结点进行删除
        deleteNode(cur.data);

        return cur.data;
    }


    //
}


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

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


    //中序遍历
    public void infixOrderList(){
        if (this.left != null){
            this.left.infixOrderList();
        }

        System.out.println(this);

        if (this.right != null){
            this.right.infixOrderList();
        }
    }




    //1，添加节点
    public void add(TreeNode node){
        if (node == null){
            return;
        }

        //判断当前传入节点和根节点的大小关系
        if (node.data < this.data){ //当小于当前根节点，则添加到左边
            if (this.left == null){
                this.left = node;
            }else{
                //递归向左子树添加
                this.left.add(node);
            }
        }else{                       //当大于或等于当前根节点，则添加到右边
            if (this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }

        //当添加完一个节点后，如果(右子树的高度 - 左子树的高度) > 1，左旋
        if(rightHeight() - leftHeight() > 1){
            //如果当前节点的右子树的左子树的高度大于它的右子树的高度
            //那么先对当前节点的右子树进行右旋，再对当前节点进行左旋
            if (this.right != null &&  this.right.leftHeight() > this.right.rightHeight()){
                //先对d当前节点的右子节点进行右旋
                this.right.rightRotate();
                //再对当前的节点进行左旋
                leftRotate();
            }else{
                leftRotate();
            }
            return;  //！！！易错点
        }

        if(leftHeight() - rightHeight() > 1){
            //如果当前节点的左子树的右子树的高度大于它的左子树的高度
            //那么先对当前节点的左子树进行左旋，再对当前节点进行右旋
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()){
                //先当前节点的左节点行左旋转
                this.left.leftRotate();
                //再对当前节点进行右旋
                rightRotate();
            }else{
                rightRotate();
            }
        }
    }



    /**
     * 2,查找要删除的节点
     * @param data
     * @return
     */
    public TreeNode search(int data){
        if (data == this.data){
            return this;
        }else if(data < this.data){ //向左子树递归查找
            if (this.left == null){
                return null;
            }
            return this.left.search(data);
        }else{
            if (this.right == null){
                return null;
            }
            return this.right.search(data);
        }
    }

    /**
     * 3,查找要删除的节点的父节点
     * @param data
     * @return
     */
    public TreeNode searchParent(int data){
        if ((this.left != null && this.left.data == data)
                || (this.right != null && this.right.data == data)){
            return this;
        }else{
            //如果查找的值小于当前节点的值，并且当且节点的左子节点不为空
            if(data < this.data && this.left != null){
                return this.left.searchParent(data);
            }else if (data >= this.data && this.right != null){
                return this.right.searchParent(data);
            }else{
                return null; //没有找到父节点
            }

        }
    }


    //4，返回左子树的高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }

        return left.height();
    }

    //5，返回有字数的高度
    public int rightHeight(){
        if (right == null){
            return 0;
        }

        return right.height();
    }

    //6,返回以当前节点为根节点的树的高度
    public int height(){
        int height = Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1; //1是一个定值，当回归的时候会加上
        return height;
    }

    //7，左旋方法
    public void leftRotate(){

        //创建新节点
        TreeNode  newNode = new TreeNode(this.data);

        //把新的节点的左子树设置成当前节点的左子树
        newNode.left = this.left;
        //把新的节点的左子树设置成当前节点的右子树的左子树
        newNode.right = this.right.left;

        //把当前节点的值替换成其右子节点的值
        this.data = this.right.data;

        //把当前节点的右子树设置成其右子树的右子树
        this.right = this.right.right;
        //把当前节点的左子树（左子节点）设置成新的节点
        this.left = newNode;
    }

    //8，左旋方法
    public void rightRotate(){
        //创建新节点
        TreeNode  newNode = new TreeNode(this.data);
        newNode.right = this.right;
        newNode.left = this.left.right;


        this.data = this.left.data;

        this.left = this.left.left;
        //把当前节点的左子树（左子节点）设置成新的节点
        this.right = newNode;
    }
}