package datastruct.tree.bstTree;


/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-11 18:56
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {

        int[] arr = {10, 11, 7, 6, 8, 9};
//        int[] arr = {3,7,5,12,10,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();

        //1，添加
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new TreeNode(arr[i]));
        }
        binarySortTree.infixOrderList();

        //2,删除
//        binarySortTree.deleteNode(2);
//        binarySortTree.deleteNode(5);
//        binarySortTree.deleteNode(9);
//        binarySortTree.deleteNode(12);
//        binarySortTree.deleteNode(7);
//        binarySortTree.deleteNode(3);
//        binarySortTree.deleteNode(1);
//        binarySortTree.deleteNode(10);
//        System.out.println("删除后");
//        binarySortTree.infixOrderList();

    }
}


class BinarySortTree{
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
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
            //1，先找到当前节点
            TreeNode tarNode = search(data);
            if (tarNode == null){  //如果没有找到当前节点，那么说明说明即使只有一个根节点，那么这个根节点也不是，否则就是找到。
                return;
            }
            //2，如果发现tarNode没有父节点，即只有根节点（只有根节点）时，删除该节点。
//            if(root.left == null && root.right == null){
            //此时说明找到了当前根节点就是哟啊删除的节点，因此无需再判断是不是相等。
            if(root.left == null && root.right == null){
                root = null;
                return;
            }

            //3,找到删除节点的父节点
            TreeNode parNode = searchParent(data);

            //1，如果要删除的是叶子结点
            if(tarNode.left == null && tarNode.right == null){
                //判断tarNode是父节点的左子节点还是右子节点
                if(parNode.left != null && parNode.left.data == data){ //如果是左节点
                    parNode.left = null;
                }else if(parNode.right != null && parNode.right.data == data){ //如果是右节点
                    parNode.right = null;
                }
            //2，如果要删除的节点有双子节点。只需找到删除节点的右子树的最小值，并将该值赋给删除节点，并删除该最小值的节点即可。
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
    public int deleteRightTreeMin(TreeNode node){
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
        System.out.println("前");

        if (this.left != null){
            this.left.infixOrderList();
            System.out.println("中");
        }


//        System.out.println(this);

        if (this.right != null){
            this.right.infixOrderList();
            System.out.println("后");
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
    }



    /**
     * 查找要删除的节点
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
     * 查找要删除的节点的父节点
     * @param data
     * @return
     */
    public TreeNode searchParent(int data){
        //当前节点的左节点或者右节点等于查找值
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

}