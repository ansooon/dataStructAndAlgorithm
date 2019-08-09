package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-09 15:00
 */
public class searchAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 6, 9};

//        System.out.println(Search.seqSearch(arr, 8));

//        System.out.println(Search.binarySearch(arr, 0, arr.length - 1, 10));

//        List resIndextList = Search.binaryAllSearch(arr, 0, arr.length - 1, 6);
//        System.out.println(resIndextList);


        System.out.println(Search.insertSearch(arr, 0, arr.length - 1, 9));

    }

}


/**
 * 查找：顺序查找，二分查找/折半查找，插值查找，斐波那契查找/黄金分割点查找
 */
class Search {


    /**
     * 1,线性查找,不找到全部，找到一个就返回。
     *
     * @param arr
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 2-1，二分查找的数组应该是有序的
     *
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findValue) {

        //递归结束条件1
        if (left > right) {
            return -1;
        }

        int mid = (left + right) >> 1;
        int midVal = arr[mid];

        if (findValue > midVal) { //正序,向右查询
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else {
            return mid;  //递归结束条件1
        }
    }


    /**
     * 2-2,找到所有的值后放入集合中返回
     * 1，找到mid索引值，不要马上返回
     * 2，向mid索引值的左边扫描，将所有满足条件的下标找到加入集合
     * 3，向mid索引值的右边扫描，将所有满足条件的下标找到加入集合
     *
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static List<Integer> binaryAllSearch(int[] arr, int left, int right, int findValue) {

        //递归结束条件1
        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) >> 1;
        int midVal = arr[mid];

        if (findValue > midVal) { //正序,向右查询
            return binaryAllSearch(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return binaryAllSearch(arr, left, mid - 1, findValue);
        } else {
            List<Integer> resIndexList = new ArrayList<>();

            //向左扫描
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }

            //先将自身加入
            resIndexList.add(mid);

            //向右扫描
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;  //递归结束条件1
        }
    }

    /**
     * 3,插入查找算法
     *
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static int insertSearch(int[] arr, int left, int right, int findValue) {
        //递归结束条件1
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }

        int cot = (right - left) / (arr[right] - arr[left]);
        int detaY = findValue - arr[left];
        int mid = left + cot * detaY;
        int midVal = arr[mid];

        if (findValue > midVal) { //正序,向右查询
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }

    }
}