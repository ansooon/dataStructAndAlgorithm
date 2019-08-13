package algorithm;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-08 17:08
 */
public class sortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};

//        int[] arr1 = new int[40000000];
//        for (int i = 0; i < 40000000; i++) {
//            arr1[i] = (int) (Math.random() * 40000000);
//        }
//
//        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
//        int[] arr3 = Arrays.copyOf(arr1, arr1.length);
//        int[] arr4 = Arrays.copyOf(arr1, arr1.length);
//        int[] arr5 = Arrays.copyOf(arr1, arr1.length);
//        int[] arr6 = Arrays.copyOf(arr1, arr1.length);
//        int[] arr7 = Arrays.copyOf(arr1, arr1.length);

        //1-1，冒泡排序
//        System.out.println("冒泡排序排序前");
//        System.out.println(Arrays.toString(arr1));
//        long start1 = System.currentTimeMillis();
//        Sort.bubbleSort(arr1);
//        long stop1 = System.currentTimeMillis();
//        System.out.println("1-1冒泡排序耗时:" + (stop1 - start1) / 100);
//        System.out.println("冒泡排序排序后");
//        System.out.println(Arrays.toString(arr1));


        //1-2,快交排序
//        System.out.println("快交排序排序前");
//        System.out.println(Arrays.toString(arr2));
//        long start2 = System.currentTimeMillis();
//        Sort.quickSort(arr2, 0, arr2.length - 1);
//        long stop2 = System.currentTimeMillis();
//        System.out.println("1-2快交排序耗时:" + (stop2 - start2) / 100);
//        System.out.println("快交排序排序后");
//        System.out.println(Arrays.toString(arr2));

        //2-1，选择排序
//        System.out.println("选择排序排序前");
//        System.out.println(Arrays.toString(arr3));
//        long start3 = System.currentTimeMillis();
//        Sort.selectSort(arr3);
//        long stop3 = System.currentTimeMillis();
//        System.out.println("2-1选择排序耗时:" + (stop3 - start3) / 100);
//        System.out.println("选择排序排序后");
//        System.out.println(Arrays.toString(arr3));

        //2-2，堆排序
        System.out.println("选择排序排序前");
        System.out.println(Arrays.toString(arr));
        long start3 = System.currentTimeMillis();
        Sort.heapSort(arr);
        long stop3 = System.currentTimeMillis();
        System.out.println("2-1选择排序耗时:" + (stop3 - start3) / 100);
        System.out.println("选择排序排序后");
        System.out.println(Arrays.toString(arr));


        //3-1，插入排序
//        System.out.println("插入排序排序前");
//        System.out.println(Arrays.toString(arr4));
//        long start4 = System.currentTimeMillis();
//        Sort.insertSort(arr4);
//        long stop4 = System.currentTimeMillis();
//        System.out.println("3-1插入排序耗时:" + (stop4 - start4) / 100);
//        System.out.println("插入排序排序后");
//        System.out.println(Arrays.toString(arr4));

        //3-2-1，希尔排序
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        Sort.insertBasedShellBySwapSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        //3-2-2，希尔排序
//        System.out.println("希尔排序排序前");
//        System.out.println(Arrays.toString(arr5));
//        long start5 = System.currentTimeMillis();
//        Sort.insertBasedShellByMoveSort(arr5);
//        long stop5 = System.currentTimeMillis();
//        System.out.println("3-2希尔排序耗时:" + (stop5 - start5) / 100);
//        System.out.println("希尔排序排序后");
//        System.out.println(Arrays.toString(arr5));

        //4，归并排序
//        System.out.println("归并排序排序前");
//        System.out.println(Arrays.toString(arr6));
//        long start6 = System.currentTimeMillis();
//        Sort.mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
//        long stop6 = System.currentTimeMillis();
//        System.out.println("4归并排序耗时:" + (stop6 - start6) / 100);
//        System.out.println("归并排序排序后");
//        System.out.println(Arrays.toString(arr6));


        //题外，链表排序
//        Date date1 = new Date();
//        String data1Str = simpleDateFormat.format(date1);
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        Sort.slinkedListSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
//        Date date2 = new Date();
//        String data2Str = simpleDateFormat.format(date2);
//        System.out.println(data1Str);
//        System.out.println(data2Str);


    }
}

/**
 * 1插入排序（直插排序，[希尔排序]），2选择排序（简选排序，[堆排序]），3交换排序（冒泡排序，[快交排序]），4归并排序，5基数排序。
 * 时间频度（取最高次项，忽略低次项）；时间复杂度（取n无穷大时的最高次项：1,lgn，n，nlgn，线性对数阶，n^2）
 * 速度：快交 微> 归并（耗内存）> 希尔 > 选择 > 插入 > 冒泡
 */
class Sort {

    /**
     * 1-1,交换：冒泡排序。依次交换相邻逆序位置。
     * 每一次排序时，如果前后数据是逆序，那么会改两者的排序，而不是仅仅将最大数放最后而已
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean sortFinish = true; //假设都已经排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    sortFinish = false;  //假设不成立
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第" + (i + 1) + "次排序结果");
//            System.out.println(Arrays.toString(arr));

            if (sortFinish) {
                break;
            } else {
                sortFinish = true;
            }
        }
    }


    /**
     * 1-2，交换，快交排序。以中间作为分界线分左右两边大小，递归处理
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(l + r) >> 1]; //除以2
        int temp = 0; //交换时的值

        //while循环到的目的是让比middle值小的放到左边，比其大的放到右边
        while (l < r) {

            //在mid的左边一直找到大于等于mid的值
            while (arr[l] < mid) { //正序，一定能退出，只要等于它自己就一定会退出，最差的情况
//                l += 1;
                l++;
            }

            //在mid的右边一直找到小于等于mid的值
            while (arr[r] > mid) { //正序
//                r -= 1;
                r--;
            }

            //如果l >= r，说明左右两边的值都都以mid作为分界线分大小
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完了之后，发现 arr[l] == mid，那么将r--，前移一步.
            if (arr[l] == mid) {
//                r -= 1;
                r--;
            }

            //如果交换完了之后，发现 arr[r] == mid，那么将l--，前移一步.
            if (arr[r] == mid) {
//                l += 1;
                l++;
            }
        }

        //如果l == r,必须l++，r--,否则出现栈溢出
        if (l == r) {
//            l += 1;
//            r -= 1;
            l++;
            r--;
        }

        //向左递归
        if (left < r) {  //因为每次都取中，当向左边移动时，r时越来越靠近left直到相等
            quickSort(arr, left, r);
        }

        if (right > l) {
            quickSort(arr, l, right);
        }
    }


    /**
     * 2-1，选择排序，从右边依次选择最值和左边顺位交换位置。因为交换的次数少，所以时间教冒泡段
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {  //顺位个数= len - 1
            int minTemp = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (minTemp > arr[j]) {
                    minTemp = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];  //腾出最开始的位置
                arr[i] = minTemp;
            }
//            System.out.println("第" + (i + 1) + "次排序结果");
//            System.out.println(Arrays.toString(arr));
        }
    }


    /**
     * 2-2，选择排序，堆排序。升序大顶锥，降序小顶锥
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int temp;

        //1， 将无序序列构建成一个堆。根据升序降序需求选择大顶锥和小顶锥。
        //从最后一个非叶子节点开始。从左至右，从下至上进行调整。
        //第一次调整是从底部调整，后续调整将从头部开始调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjustHeap(arr, 0, arr.length);
//        }

        //2，将锥顶元素与末尾元素交换，将最大元素"沉"到数组末端
        //3，重新调整结构，使其满足堆定义，然后继续减缓对顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0]; //arr[0]是大顶锥，最大的值
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * 将一个数组(二叉树),调整成一个大顶锥，即将i指向的非叶子节点调整成大顶锥,即i指向为子树中的最大值
     *
     * @param arr                     待调整的数组
     * @param i,                      表示非叶子节点在数组中的索引，最后非叶子节点公式 i = arr.length/2 - 1
     * @param length，表示多少个元素继续调整，逐渐减少
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量中
        int temp = arr[i];
        //开始调整，左节点公式 k = i * 2 + 1
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {  //说明左子节点的值小于右子节点
                k++; //k指向右子节点
            }

            //k指向左右子节点中的最大值
            if (arr[k] > temp) { //如果子节点大于父节点
                arr[i] = arr[k]; //把较大的值赋给当前节点
                i = k;          //让i指向k（结论：左边为指向）
            } else {
                break;          //从下至上调整，说明下层无序再调整！
            }
        }

        //当for循环结束后，已经将i为父节点的数调整为局部大顶锥
        arr[i] = temp; //将temp放到最后调整的位置，腾笼换鸟
    }


    /**
     * 3-1，插入排序。将右边无序依次列插入左边有序列
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {  //千万不要减1，指向待插入的值
            for (int j = 0; j < arr.length; j++) {
                int insertDataTemp = arr[i]; //暂存
                int currentIndexToInsert = i - 1;

                //1，insertToIndex >= 0保证在给insertData找插入位置时不越界
                //2，insertData < arr[insertToIndex]，带插入的数还没有找到插入位置。将无序列找到位置！
                //3，需要将arr[insertToIndex]后移←←
                while (currentIndexToInsert >= 0 && insertDataTemp < arr[currentIndexToInsert]) {  //差别1，正序！！！ *************insertDataTemp < arr[currentIndexToInsert])***********
                    //实际上就是将逆序子列复制一份，并向右移一位进行复制！
                    // 如[1,2,4,5,6],[3],5,6，相对于待插入值3，那么逆序子列为4,5,6，将他们复制一份像右移，得到[1,2,[4],4,5],[6],5,6，
                    // 最后再将插入值赋给[4]即可,得到[1,2,[3],4,5],[6],5,6，
                    arr[currentIndexToInsert + 1] = arr[currentIndexToInsert];
                    currentIndexToInsert--;  //最小为-1
                }

                //当退出时，位置找到
                if (!(currentIndexToInsert + 1 == i)) { //没有进循环体
                    arr[currentIndexToInsert + 1] = insertDataTemp; //因为退出来的时候urrentIndexToInsert --，自减了一位。
                }

            }
//            System.out.println("第" + (i) + "次排序结果");
//            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 3-2-1，插入排序。希尔排序，交换法
     *
     * @param arr
     */
    public static void insertBasedShellBySwapSort(int[] arr) {

        //第一轮，将10个数分成了5组
        int temp;
        int cnt = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //1，按照步长分组，
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中给所有的元素（当有五组时，每组2个元素，遍历2个元素只需1次，当有2组的时候后，每组共5个元素，要遍历4次。但是是分散比较的）
                //步长：j -= gap:保证向右迭代时，能够在有序列中寻找到合适的位置插入，交换位置时效率不高，要优化成插入排序法，能够高效找出为位置，
                // ，即找到位置一次性插入，而不是都有两两比较一遍。
                //总之，分组内的排序时通过相邻交换位置法，达到从无序插入有序的插入法实现。
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前的元素大于还加上步长后的那个元素，说明交换(交换法)
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            cnt++;
            System.out.println("第" + (cnt) + "次排序结果");
            System.out.println(Arrays.toString(arr));

        }
    }

    /**
     * 3-2-2，插入排序。希尔排序，移动法
     *
     * @param arr
     */
    public static void insertBasedShellByMoveSort(int[] arr) {

        //第一轮，将10个数分成了5组
        int temp;
        int cnt = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[i];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    //移动
                    arr[j] = arr[j - gap];
                    j -= gap; //最小退出为负数
                }
                //当退出while后，就给temp找到插入的位置
                arr[j] = temp;
            }
        }
    }


    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;  //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);  //这些递归只是把mid的值分组而已
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //到合并
            merge(arr, left, mid, right, temp);  //非递归
        }
    }


    /**
     * 归
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
//        System.out.println("***");
        int i = left;
        int j = mid + 1;
        int t = 0; //指向temp数组的当前索引

        //1，先把左右两边（有序）的数据。按照规则填充到temp数组，直到左右两边的有序序列处理完毕为止
        while (i <= mid && j <= right) { //继续
            //当左边的元素小于等于右边的元素。
            // 当等于时，右边的数要么比左边下一个数小，要么等于，如果是小于则右边的数也被填充，如果最后剩下，那么也会被整体被填充到新数组。
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //2，把有剩余数据的一边依次填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        //3，将temp重新copy到arr。并不是每次都拷贝全部.每次拷贝分成的那几个数组。因为数组已经放在栈中，所以
        t = 0;
        int tempLeft = left;
//        System.out.print("tempLeft = " + tempLeft + ",");
//        System.out.println("right = " + right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }


    public static void slinkedListSort(int[] arr) {
        SLinkedList sLinkedList = new SLinkedList();
        for (int i = 0; i < arr.length; i++) {
            sLinkedList.addByOrder(arr[i]);
        }

        sLinkedList.reSetArr(arr);
    }

}


class SLinkedList {
    Node head = new Node(0);
    int size;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addByOrder(int data) {

        Node cur = head; //每次添加进来都是从头开始
        Node newNode = new Node(data);
        while (true) {
            if (cur.next == null) {
                break;
            }

            if (cur.next.data >= data) {  //逆序找位置
                break;
            }
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void reSetArr(int[] arr) {
        Node cur = head.next;
        for (int i = 0; i < size; i++) {
            arr[i] = cur.data;
            cur = cur.next;
        }
    }
}