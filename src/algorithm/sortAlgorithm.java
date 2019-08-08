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
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int)(Math.random() * 800000);
//        }

        //1-1，冒泡排序
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = new Date();
//        String data1Str = simpleDateFormat.format(date1);
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        Sort.bubbleSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
//        Date date2 = new Date();
//        String data2Str = simpleDateFormat.format(date2);
//        System.out.println(data1Str);
//        System.out.println(data2Str);

        //1-2,快交排序
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        Sort.quickSort(arr, 0, arr.length -1);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        //2，选择排序
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        Sort.selectSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));


        //3，插入排序
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        Sort.insertSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        //4-1，希尔排序
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        Sort.insertBasedShellBySwapSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        //4-2，希尔排序
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        Sort.insertBasedShellByMoveSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
    }
}

/**
 * 1插入排序（直插排序，[希尔排序]），2选择排序（简选排序，[堆排序]），3交换排序（冒泡排序，[快交排序]），4归并排序，5基数排序。
 * 时间频度（取最高次项，忽略低次项）；时间复杂度（取n无穷大时的最高次项：1,lgn，n，nlgn，线性对数阶，n^2）
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
                    swap(temp, j, arr);
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
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int middle = arr[(l + r) >> 1]; //除以2
        int temp = 0; //交换时的值

        //while循环到的目的是让比middle值小的放到左边，比其大的放到右边
        while (l < r){

            //在mid的左边一直找到大于等于mid的值
            while (arr[l] < middle){ //正序，一定能退出，只要等于它自己就一定会退出，最差的情况
                l += 1;
            }

            //在mid的右边一直找到小于等于mid的值
            while (arr[r] > middle){ //正序
                r -= 1;
            }

            //如果l >= r，说明左右两边的值都都以mid作为分界线分大小
            if(l >= r){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完了之后，发现 arr[l] == mid，那么将r--，前移一步.
            if(arr[l] == middle){
                r -= 1;
            }

            //如果交换完了之后，发现 arr[r] == mid，那么将l--，前移一步.
            if(arr[r] == middle){
                l += 1;
            }
        }

        //如果l == r,必须l++，r--,否则出现栈溢出
        if(l == r){
            l += 1;
            r -= 1;
        }

        //向左递归
        if(left < r){  //因为每次都取中，当向左边移动时，r时越来越靠近left直到相等
            quickSort(arr, left, r);
        }

        if(right > l){
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
            for (int i = gap; i < arr.length; i ++) {
                //遍历各组中给所有的元素（当有五组时，每组2个元素，遍历2个元素只需1次，当有2组的时候后，每组共5个元素，要遍历4次。但是是分散比较的）
                //步长：j -= gap:保证向右迭代时，能够在有序列中寻找到合适的位置插入，交换位置时效率不高，要优化成插入排序法，能够高效找出为位置，
                // ，即找到位置一次性插入，而不是都有两两比较一遍。
                //总之，分组内的排序时通过相邻交换位置法，达到从无序插入有序的插入法实现。
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    //如果当前的元素大于还加上步长后的那个元素，说明交换(交换法)
                    if(arr[j] > arr[j + gap]){
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






    private static void swap(int funData, int j, int[] arr) {
        funData = arr[j];     //先换当前
        arr[j] = arr[j + 1];
        arr[j + 1] = funData;
    }
}