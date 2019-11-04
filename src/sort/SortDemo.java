package sort;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-03 20:57
 */
public class SortDemo {


    public static void main(String[] args) {


        int[] arr = {4, 6, 8, 5, 9, 3, 1};

        //1-1
//        Sort.bublleSort(arr);
//        System.out.println(Arrays.toString(arr));

        //1-2
//        Sort.quickSort(arr);
//        System.out.println(Arrays.toString(arr));

        //2-1
//        Sort.selectSort(arr);
//        System.out.println(Arrays.toString(arr));

        //2-2
//        Sort.heapSort(arr);
//        System.out.println(Arrays.toString(arr));

        //3-1
//        Sort.insertSort(arr);
//        System.out.println(Arrays.toString(arr));

        //3-2
//        Sort.shellSort(arr);
//        System.out.println(Arrays.toString(arr));

        //4-1
//        Sort.mergeSort(arr);
//        System.out.println(Arrays.toString(arr));

    }
}


class Sort {

    /**
     * 1-1,交换排序——泡交排序
     *
     * @param arr
     */
    public static void bublleSort(int[] arr) {
        boolean hasSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    hasSorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (hasSorted) {
                break;
            } else {
                hasSorted = true;
            }
        }
    }


    /**
     * 1-2，交换排序——快交排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        int pL, pR, ref;

        //容易忘记！如果不出来return，后续会报下数组下标越界
        if (left > right) {
            return;
        }

        pL = left;
        pR = right;
        ref = arr[left];

        while (pL < pR) {
            while (arr[pR] >= ref && pL < pR) {
                pR--;
            }

            while (arr[pL] <= ref && pL < pR) {
                pL++; //注意是++
            }

            if (pL < pR) {
                int temp = arr[pL];
                arr[pL] = arr[pR];
                arr[pR] = temp;
            }
        }

        arr[left] = arr[pR];
        arr[pR] = ref;

        quickSort(arr, left, pL - 1);
        quickSort(arr, pR + 1, right);
    }


    /**
     * 2-1,选择排序——直选排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //i是存放最值的左边位置，因此从0开始【1】
            int min = arr[i];
            int pMin = i;
            for (int j = i + 1; j < arr.length; j++) { //遍历找最值
                if (arr[j] < min) {
                    min = arr[j];
                    pMin = j;
                }
            }

            if (pMin != i) {
                arr[pMin] = arr[i];
                arr[i] = min;
            }
        }
    }


    /**
     * 2-2,选择排序——堆选排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {

        //构建大顶锥
        for (int iRoot = arr.length / 2 - 1; iRoot >= 0; iRoot--) { //注意这里是 >= 0!
            adjustHeap(arr, iRoot, arr.length);
        }

        //沉底数据，重新构建大顶锥
        for (int j = arr.length - 1; j > 0; j--) { //j > 0说明最后一个不用选了。arr.length - 1 是为了防止越界
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    private static void adjustHeap(int[] arr, int iRoot, int len) {
        int temp = arr[iRoot];

        for (int k = 2 * iRoot + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && arr[k + 1] > arr[k]) {
                k = k + 1;
            }

            if (temp < arr[k]) {
                arr[iRoot] = arr[k];
                iRoot = k;
            } else {
                break;
            }
        }

        arr[iRoot] = temp;
    }


    /**
     * 3-1,插入排序——直插排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {  //i为待选的数，因此从1开始
            int preIsr = arr[i];
            int p = i - 1;
            while (p >= 0 && preIsr < arr[p]) {
                arr[p + 1] = arr[p];
                p--;
            }

            p++;

            if (p != i) {
                arr[p] = preIsr;
            }
        }
    }


    /**
     * 3-2,插入排序——希插排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {  //i为待选的数，因此从1开始
                int preIsr = arr[i];
                int p = i - gap;
                while (p >= 0 && preIsr < arr[p]) {
                    arr[p + gap] = arr[p];
                    p -= gap;
                }

                p += gap;

                if (p != i) {
                    arr[p] = preIsr;
                }
            }
        }
    }


    /**
     * 4-1,归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr){

        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right){
            int mid = (left + right) >> 1;

            mergeSort(arr, left, mid, temp); //这里要和快交区别开来，不是mid - 1
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int pL = left;
        int pR = mid + 1;
        int pT = 0;

        while(pL <= mid && pR <= right){ //第一个循环条件要记住！
            if(arr[pL] <= arr[pR]){
                temp[pT++] = arr[pL++];
            }else{
                temp[pT++] = arr[pR++];
            }
        }

        while (pL <= mid){
            temp[pT++] = arr[pL++];
        }

        while (pR <= right){
            temp[pT++] = arr[pR++];
        }

        int pLeft = left;
        pT = 0;
        while (pLeft <= right){ //这里要小心，不要写成pT < temp.length
            arr[pLeft++] = temp[pT++];  //从temp搬回去，凡是pT的都是temp数组！
        }
    }
}

