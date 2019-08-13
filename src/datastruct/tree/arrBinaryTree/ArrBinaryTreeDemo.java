package datastruct.tree.arrBinaryTree;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-10 18:03
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(new int[]{1, 2, 3, 4, 5, 6});
        arrBinaryTree.preOrder();

    }
}


//编写一个ArrBinaryTree，实现顺序存储二叉树遍历

class ArrBinaryTree{
    private int[] arr; //存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载
    public void preOrder(){
        this.preOrder(0);
    }


    //编写一个方法，完成顺序存储二叉树的遍历
    public void preOrder(int index){
        //如果数组为空，或者长度为0，
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //输出当前的元素
        System.out.println(arr[index]);
        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        //向右遍历
        if (2 * index + 2 < arr.length){
            preOrder(2 * index + 2);
        }
    }
}