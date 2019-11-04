package numArray;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-19 18:54
 */
public class NumArrayDemo {
    public static void main(String[] args) {

        //1，二维数组中的查找
//        int[][] matrix = {{1, 2, 8, 9},
//                {2,  4,  9,  12},
//                {4,  7,  10, 13},
//                {6,  8,  11, 15},
//                {8,  9,  12, 16},
//                {9,  10, 13, 17}
//        };
//
//        D2MatrixFindNum m = new D2MatrixFindNum();
//        long start1 = System.currentTimeMillis();
//        System.out.println(m.findMatrixNum(matrix, 18));
//        long finish1 = System.currentTimeMillis();
//        System.out.println(finish1 - start1);
//
//        long start2 = System.currentTimeMillis();
//        boolean hasNum = false;
//        for (int i = 0; i < matrix.length; i++) {
//            if (m.findByBinarySearch(matrix[i], 0, matrix[0].length - 1, 18)){
//                hasNum = true;
//                break;
//            }
//        }
//        System.out.println(hasNum);
//        long finish2 = System.currentTimeMillis();
//        System.out.println(finish2 - start2);


        //2,旋转数组的最小数字
//        int[] arr = {1, 1, 1, 1, 1, 0, 1, 1, 1};
//        MinNumberInRotateArray minNumberInRotate = new MinNumberInRotateArray();
//        System.out.println(minNumberInRotate.minNumberInRotateArray(arr));

        //3，调整数组，使奇数位于偶数前
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        ReOrderArray reOrderArray = new ReOrderArray();
//        reOrderArray.reOrderArray(arr);
//        reOrderArray.reOrderArrayByExchang(arr);
//        System.out.println(Arrays.toString(arr));

        //4,顺时针打印矩阵
//        int[][] arr = {{1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15}
//        };
//        PrintMatrix printMatrix = new PrintMatrix();
//        printMatrix.printMatrix(arr);


        //5,数组中出现次数超过一半的数字
//        int[] arr = {1,1,1,1,1,2,3,4};
//        MoreThanHalfNumCnt moreThanHalfNumCnt = new MoreThanHalfNumCnt();
//        System.out.println(moreThanHalfNumCnt.moreThanHalfNumSolutionByHashMap(arr));
//        System.out.println(moreThanHalfNumCnt.moreThanHalfNumSolutionBySort(arr));
//        System.out.println(moreThanHalfNumCnt.moreThanHalfNumSolution(arr));


        //6，取最小的K个数
//        int[] arr = {6,4,8,9,2,5,7};
//        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
//        System.out.println(getLeastNumbers.getLeastNumbersSolutionByHeap(arr, 3));
//        System.out.println(getLeastNumbers.getLeastNumbersSolutionBySort(arr, 3));


        //7, 连续子数组的最大和
//        int[] arr = {6,-3,-2,7,-15,1,2,2};
//        FindGreatestSumOfSubArray findGreatestSumOfSubArray = new FindGreatestSumOfSubArray();
//        System.out.println(findGreatestSumOfSubArray.findGreatestSumOfSubArray(arr));


        //8，把数组排成最小的数
//        int[] arr= {3,32,321};
//        AddString addString = new AddString();
//        System.out.println(addString.getMinNum(arr));


        //11,数组中只出现一次的数字
//        int[] arr = {1, 2, 3, 4, 4, 3, 5, 5};
//        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
////        int[] resArr = findNumsAppearOnce.findNumsAppearOnceByMap(arr);
//        int[] resArr = findNumsAppearOnce.findNumsAppearOneByYiHuo(arr);
//        for (int i = 0; i < resArr.length; i++) {
//            System.out.println(resArr[i]);
//        }

        //12,扑克牌顺子
//        int[] arr = {0,0,1,3,5};
//        IsContinuous isContinuous = new IsContinuous();
//        System.out.println(isContinuous.isContinuous(arr));


        //13,孩子们的游戏(圆圈中最后剩下的数)
//        LastRemaining lastRemaining = new LastRemaining();
//        System.out.println(lastRemaining.lastRemainingSolution(10, 3));

        //14,数组中重复的数字
//        int[] arr = {2, 3, 1, 0, 2, 5, 3};
//        FindDuplicate findDuplicate = new FindDuplicate();
//        System.out.println(findDuplicate.duplicate(arr, arr.length, new int[1]));

        //15，构建乘积数组
//        int[] arr = {1, 2, 3, 4, 5};
//        Mutiply mutiply = new Mutiply();
//        int[] B = mutiply.multiply(arr);
////        int[] B = mutiply.multiplyByForce(arr);
//        for (int i = 0; i < B.length; i++) {
//            System.out.print(B[i] + ",");
//        }

        //16，滑动窗口的最大值
//        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
//        MaxInWindows maxInWindows = new MaxInWindows();
//        System.out.println(maxInWindows.maxInWindowsByForce(arr, 3));
//        System.out.println(maxInWindows.maxInWindowsByQueue(arr, 3));

        //17，找最大最小值
//        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1, 0};
//        GetMAxAndMin getMAxAndMin = new GetMAxAndMin();
//        getMAxAndMin.getMaxAndMin(arr);
//        System.out.println(getMAxAndMin.min + "" + getMAxAndMin.max);


        //18，找到第二大数
//        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1, 0};
//        FindSecondMaxNum findSecondMaxNum = new FindSecondMaxNum();
//        System.out.println(findSecondMaxNum.findSecondMaxNum(arr));

        //19，两两相加等于sum
//        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1, 0};
//        FindSum findSum = new FindSum();
//        System.out.println(findSum.findSum(arr, 6));

        //20，把数组右移k位
//        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1, 0};
//        ShiftK shiftK = new ShiftK();
//        shiftK.shiftK(arr, 3);
//        System.out.println(Arrays.toString(arr));

        //21，找第k小的数
//        int[] arr = {1, 3, 4, 2, 6, 5};
//        GetKMin getKMin = new GetKMin();
//        System.out.println(getKMin.getKMin(arr, 3));


        //22,找出数组中只出现一次的数字
//        int[] arr = {1, 3, 4, 3, 4, 5, 1};
//        FindNotDouble findNotDouble = new FindNotDouble();
//        System.out.println(findNotDouble.findNotDouble(arr));


        //23,找出数组中唯一重复1次的数字
//        int[] arr = {1, 2, 1, 3, 4};
//        FindOnlyDoubleNum findOnlyDoubleNumnew = new FindOnlyDoubleNum();
//        System.out.println(findOnlyDoubleNumnew.findOnlyDoubleNumBySum(arr));
//        System.out.println(findOnlyDoubleNumnew.findOnlyDoubleNumByXor(arr));


        //24，用递归求最大值
//        int[] arr = {1, 2, 4, 3, 1};
//        FindMaxNumByRec findMaxNumByRec = new FindMaxNumByRec();
//        System.out.println(findMaxNumByRec.findMaxNumByRec(arr, 0));

        //25，求数对的最大差值
//        int[] arr = {1, 4, 17, 3, 2, 9};
//        GetMaxDif getMaxDif = new GetMaxDif();
//        System.out.println(getMaxDif.getMaxDifByDp(arr));
//        System.out.println(getMaxDif.getMaxDif(arr));

        //26，求给定两个数的最小距离
//        int[] arr = {4, 5, 6, 4, 7, 4, 6, 4, 5, 7, 8, 5, 6, 4, 3, 10, 8};
//        GetMinDistance getMinDistance = new GetMinDistance();
//        System.out.println(getMinDistance.getMinDistance(arr, 4, 8));

        //28，求指定数字第一次出现的位置，数组中的相邻元素之差为1
//        int[] arr = {3,4,5,6,5,6,7,8,9,8};
//        GetFistOccurIndex getFistOccurIndex = new GetFistOccurIndex();
//        System.out.println(getFistOccurIndex.getFistOccurIndex(arr, 6));


        //29,对数组的有序子序列进行合并排序
//        int[] arr = {1,5,6,7,9,2,4,8,10};
//        SortTwoSortedSubArr sortTwoSortedSubArr = new SortTwoSortedSubArr();
//        sortTwoSortedSubArr.sortTwoSortedSubArr(arr, 5);
//        System.out.println(Arrays.toString(arr));

        //30，
//        int[] arr1 = {0, 1, 2, 3, 4};
//        int[] arr2 = {1, 3, 5, 7, 9};
//        GetMixed getMixed = new GetMixed();
//        System.out.println(getMixed.getMixed(arr1, arr2));

        //31,
        int[] arr = {1,5,3,2,6};
        GetReverseCnt getReverseCnt = new GetReverseCnt();
        System.out.println(getReverseCnt.getReverseCnt(arr));
        getReverseCnt.mergeSortAndGetReverseCnt(arr, 0, arr.length - 1);
        System.out.println(getReverseCnt.reverseCnt);

    }
}


/**
 * 1,二维数组中的查找
 * 数组中一个数减去其右边的数的差的最大值
 */
class D2MatrixFindNum {

    public boolean findMatrixNum(int[][] matrix, int num) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix != null && (rows > 0) && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                if (matrix[row][col] == num) {
                    return true;
                } else if (matrix[row][col] > num) {
                    col--;
                } else {
                    row++;
                }
            }
        }

        return false;
    }


    public boolean findByBinarySearch(int[] arr, int left, int right, int num) {

        if (left > right) {
            return false;
        }

        int mid = (left + right) >> 1;
        int midVal = arr[mid];


        if (num == midVal) {
            return true;
        } else if (num < midVal) {
            return findByBinarySearch(arr, left, mid - 1, num);
        } else {
            return findByBinarySearch(arr, mid + 1, right, num);
        }
    }
}


/**
 * 2,旋转数组的最小数字
 */
class MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) >> 1;
            //一定在右边
            if (arr[mid] > arr[high]) {
                low = mid + 1;
                //一个一个试，使mid和right一步步后退
            } else if (arr[mid] == arr[high]) {
                low--;
                high--;
                //一定在左边
            } else {
                high = mid;
            }
        }

        return arr[low];
    }
}


/**
 * 3，调整数组顺序使奇数位于偶数前面
 */
class ReOrderArray {
    public void reOrderArray(int[] arr) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenList.add(arr[i]);
            } else {
                oddList.add(arr[i]);
            }
        }
        oddList.addAll(evenList);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = oddList.get(i);
        }
    }


    //问题，那种排序方法是稳定的？
    public void reOrderArrayByExchang(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] % 2 == 0 && arr[j + 1] % 2 != 0) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

/**
 * 4,顺时针打印矩阵
 */
class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        if (row == 0 && col == 0) {
            return res;
        }

        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            //上：从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
                System.out.println(matrix[top][i]);
            }
            //右：从上到下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
                System.out.println(matrix[i][right]);
            }

            //下：从右到左
            if (top != bottom) {
                //防止单行情况
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                    System.out.println(matrix[bottom][i]);
                }
            }

            //左：从下到上
            if (left != right) {
                //防止单列情况
                for (int i = bottom - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                    System.out.println(matrix[i][left]);
                }

            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}

/**
 * 5,数组中出现次数超过一半的数字
 */
class MoreThanHalfNumCnt {
    public int moreThanHalfNumSolutionByHashMap(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(array[i]))
                map.put(array[i], 1);
            else
                map.put(array[i], map.get(array[i]) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() * 2 > length)
                return entry.getKey();
        }
        return 0;
    }

    public int moreThanHalfNumSolutionBySort(int[] array) {
        Arrays.sort(array);
        int half = array.length / 2;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[half])
                count++;
        }
        if (count > half) {
            return array[half];
        } else {
            return 0;
        }
    }

    public int moreThanHalfNumSolution(int[] array) {

        //返回出现次数最多的字数
        int res = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == res)
                count++;
            else {
                count--;
            }
            if (count == 0) {
                res = array[i];
                count = 1;
            }
        }

        //判断最多字数是否满足个数大于数组长度一半
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res)
                count++;
        }
        return count > array.length / 2 ? res : 0;
    }

}


/**
 * 6，取最小的K个数
 */
class GetLeastNumbers {

    public ArrayList<Integer> getLeastNumbersSolutionBySort(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (arr == null || k == 0 || k > arr.length) {
            return res;
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    /**
     * 法2：利用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
     *
     * @param arr
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbersSolutionByHeap(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (arr == null || k == 0 || k > arr.length) {
            return res;
        }
        //使用PriorityQueue实现大顶堆.PriorityQueue的逻辑结构是一棵完全二叉树，存储结构其实是一个数组。逻辑结构层次遍历的结果刚好是一个数组
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.size() != k)
                maxHeap.offer(arr[i]);
            else {
                if (maxHeap.peek() > arr[i]) {
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }
        for (Integer i : maxHeap) {
            res.add(i);
        }
        return res;
    }
}


/**
 * 7,连续子数组的最大和
 */
class FindGreatestSumOfSubArray {

    /**
     * 对于一个数组中的一个数x，若是x的左边的数加起来非负，那么加上x能使得值变大，这样我们认为x之前的数的和对整体和是有贡献的。
     * 如果前几项加起来是负数，则认为有害于总和。我们用cur记录当前值, 用max记录最大值，如果cur<0,则舍弃之前的数，让cur等于当前的数字，
     * 否则，cur = cur+当前的数字。若cur和大于max更新max。
     *
     * @param array
     * @return
     */
    public int findGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int curSum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            curSum = curSum > 0 ? curSum + array[i] : array[i];  //当出现连续和为负数时，那么将当前连续和值cur移到下一位
            if (max < curSum) {
                max = curSum;
            }
        }
        return max;
    }
}


/**
 * 8,把数组排成最小的数
 */
class AddString {

    public String getMinNum(int[] arr) {
//        int[] num = {3, 32, 321};
        //装箱处理，不然下面的Arrays.sort无法重写
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }


        if (nums.length == 0 || nums == null) {
            return "";
        }

        //按照规则排序
        Arrays.sort(nums, new Comparator<Integer>() {
            //对数组nums用自定义方法排序
            @Override
            public int compare(Integer o1, Integer o2) {
                //重写compare方法来比较o1,o2的大小，当o1+""+o2和o2+""+o1
                //都是字符串，比较o1,o2的大小其实是比较两个子串的大小
                return (o1 + "" + o2).compareTo(o2 + "" + o1);
            }

        });
        String ss = new String();
        for (int i = 0; i < nums.length; i++) {
            ss += nums[i];
        }
        return ss;

    }

}

/**
 * 9,数组中的逆序对
 */
class InversePairs {
    public static int InversePairs(int[] array) {
        if (array == null || array.length <= 1)
            return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return mergeCount(array, copy, 0, array.length - 1);
    }


    public static int mergeCount(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int mid = (start + end) >> 1;
        int leftCount = mergeCount(copy, array, start, mid);
        int rightCount = mergeCount(copy, array, mid + 1, end);


        int i = mid;//i初始化为前半段最后一个数字的下标
        int j = end;//j初始化为后半段最后一个数字的下标
        int index = end;//辅助数组复制的数组的最后一个数字的下标
        int count = 0;//计数--逆序对的数目
        while (i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                copy[index--] = array[i--];
                count += j - mid;
            } else {
                copy[index--] = array[j--];
            }
        }
        for (; i >= start; i--) {
            copy[index--] = array[i];
        }
        for (; j >= mid + 1; j--) {
            copy[index--] = array[j];
        }
        return leftCount + rightCount + count;
    }
}


/**
 * 10,数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 解题思路
 * 正常的思路就是二分查找了，我们用递归的方法实现了查找k第一次出现的下标，用循环的方法实现了查找k最后一次出现的下标。
 */
class GetNumberOfK {
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
}


/**
 * 11,数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * <p>
 * 解题思路
 * 法一：大家都能想到的HashMap法
 * 法二：异或法
 */
class FindNumsAppearOnce {
    public int[] findNumsAppearOnceByMap(int[] array) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (tempMap.containsKey(array[i])) {
                tempMap.remove(array[i]);
            } else {
                tempMap.put(array[i], 1);
            }
        }
        int[] a = new int[tempMap.size()];
        int i = 0;
        for (Integer k : tempMap.keySet()) {
            a[i] = k;
            i++;
        }

        return a;
    }


    public int[] findNumsAppearOneByYiHuo(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return null;
        }

        //利用异或去重，得到两个唯一不同的两个数的异或值
        int AllXOR = 0; //0和任何一个数异或等于他本身，任何数字和本身异或等于0
        for (int i = 0; i < nums.length; i++) {
            AllXOR ^= nums[i];
        }

        //找到AllXOR中第一位为1的位置
        int res = findFirstBit1(AllXOR);

        //无需保存两个数组，直接对两个数组在循环中进行异或运算
        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isBit1(nums[i], res)) {//根据一特定位置是否为1，将数组分为两个子数组进行判断，每一个子数组中包含一个只出现一次的数字
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }

        int[] resArr = new int[2];
        resArr[0] = num1;
        resArr[1] = num2;

        return resArr;

    }

    //num&(-num)是把最右边的1保留下来
    private static int findFirstBit1(int num) {
        return num & (-num);
    }

    //判断某一特定位置是不是1
    private boolean isBit1(int data, int res) {
//        return ((data & res) == 0) ? false : true;
        return ((data & res) != 0);
    }

}


/**
 * 12,扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)…他随机从中抽出了5张牌,想测测自己的手气,
 * 看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子…..LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 * <p>
 * 解题思路
 * 先统计王(0)的数量，再把牌排序，如果后面一个数比前面一个数大于1以上，那么中间的差值就必须用王来补了。
 * 看王的数量够不够，如果够就返回true，否则返回false。
 */
class IsContinuous {

    public boolean isContinuous(int[] arr) {
        int zero = 0, dis = 0;

        //如果不等于5，那么就不满足发牌规则
        if (arr.length != 5) {
            return false;
        }
        //排序
        Arrays.sort(arr);

        //找到arr[i] == 0的个数
        for (int i = 0; i < 4; i++) {
            if (arr[i] == 0) {
                zero++;
                continue; //不能忽略，找到大小王时，不再做任何处理
            }

            //如果牌重复了，不可能是顺子
            if (arr[i] == arr[i + 1]) {
                return false;
            }


            if (arr[i + 1] - arr[i] > 1) {
                dis += arr[i + 1] - arr[i] - 1;
            }
        }
        if (zero >= dis) {
            return true;
        } else {
            return false;
        }
    }
}


/**
 * 13,孩子们的游戏(圆圈中最后剩下的数)
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0…m-1报数….这样下去….直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * <p>
 * 解题思路
 * 用环形链表模拟圆圈。创建一个总共有 n 个结点的环形链表，然后每次在这个链表中删除第 m 个结点。注意，起步是-1 不是 0。
 */
class LastRemaining {
    public int lastRemainingSolution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            link.add(i);
        }
        int index = -1;   //起步是 -1 不是 0
        while (link.size() > 1) {
            index = (index + m) % link.size();  //对 link的长度求余不是对 n
            link.remove(index);
            index--;
        }
        return link.get(0);
    }
}


/**
 * 14,数组中重复的数字(排序部分可以改进)
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * <p>
 * 解题思路
 * 最简单的就是用一个数组或者哈希表来存储已经遍历过的数字，但是这样需要开辟额外的空间。
 * 如果题目要求不能开辟额外的空间，那我们可以用如下的方法：
 * 因为数组中的数字都在0~n-1的范围内，所以，如果数组中没有重复的数，那当数组排序后，数字i将出现在下标为i的位置。
 * 现在我们重排这个数组，从头到尾扫描每个数字，当扫描到下标为i的数字时，首先比较这个数字(记为m)是不是等于i。
 * 如果是，则接着扫描下一个数字；如果不是，则再拿它和m 位置上的数字进行比较，如果它们相等，
 * 就找到了一个重复的数字（该数字在下标为i和m的位置都出现了），返回true；如果它和m位置上的数字不相等，就把第i个数字和第m个数字交换，
 * 把m放到属于它的位置。接下来再继续循环，直到最后还没找到认为没找到重复元素，返回false。
 */
class FindDuplicate {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    int temp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return false;
    }
}


/**
 * 15,构建乘积数组
 * 题目描述
 * 给定一个数组A[0,1,…,n-1],请构建一个数组B[0,1,…,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * <p>
 * 解题思路
 * B[i]的值可以看作图中矩阵第 i 行所有元素的乘积。我们可以先算下三角中的连乘，即我们先算出B[i]中的一部分，
 * 然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 */
class Mutiply {

    public int[] multiply(int[] A) {
        /*这道题的中心思想是将返回的数据列成一个矩阵，每一个矩阵的行向量都是一个从a(0)到a(n-1)
          ,然后这个对角线都是1.那么此时B0的值就是A0为一，剩下的行向量相乘。
        */
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int j = length - 2; j >= 0; j--) {
            temp *= A[j + 1];//temp始终会记录值，每次只需要加上这行上三角没有乘进来的数就可以了。
            B[j] *= temp;
        }
        return B;
    }


    //暴力法
    public int[] multiplyByForce(int[] A) {

        int[] B = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int mul = 1;
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    mul = mul * A[j];
                }
            }
            B[i] = mul;
        }
        return B;

    }
}

/**
 * 16,滑动窗口的最大值
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * <p>
 * 解题思路
 * 法一：简单的暴力法
 * 法二：双向队列
 * 用一个双向队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次，判断当前最大值是否过期（当前最大值的位置是不是在窗口之外），
 * 新增加的值从队尾开始比较，把所有比他小的值丢掉。这样时间复杂度为O(n)。
 */
class MaxInWindows {
    //暴力法
    public ArrayList<Integer> maxInWindowsByForce(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length < size || size == 0) {
            return res;
        }
        for (int i = 0; i < num.length - size + 1; i++) {
            res.add(max(num, i, size));
        }
        return res;
    }

    public int max(int[] num, int index, int size) {
        int res = num[index];
        for (int i = index + 1; i < index + size; i++) {
            if (num[i] > res) {
                res = num[i];
            }
        }
        return res;
    }


    //双向队列
    public ArrayList<Integer> maxInWindowsByQueue(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        if (num.length == 0 || size == 0) {
            return res;
        }
        for (int i = 0; i < num.length; i++) {

            //当窗口滑过了窗口长度，那么将就窗口中的最大的数的下标取出
            if (!deque.isEmpty() && deque.peekFirst() <= i - size) {
                deque.poll();
            }

            //如果队列的最后一个数小于当前循环到的数，那么删除队列的最后一个数
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.removeLast();
            }

            //此时，已经将队列中的小于当前循环数的数全干调，下一步就是添加当前循环数
            deque.offerLast(i);

            //当i + 1 >= size，说明窗口已经开始生效
            if (i + 1 >= size) {
                res.add(num[deque.peekFirst()]);  //头部永远是最大
            }
        }
        return res;
    }
}

/**
 * 17,找最大最小值
 */
class GetMAxAndMin {
    int max;
    int min;

    public void getMaxAndMin(int[] arr) {
        max = arr[0];
        min = arr[0];

        int len = arr.length;

        for (int i = 1; i < len; i = i + 2) {  //注意是到len - 1
            //如果i = len时
            if (i + 1 == len) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }

                break;
            }

            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) {
                    max = arr[i];
                }

                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                }
            }

            if (arr[i] < arr[i + 1]) {
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                }

                if (arr[i] < min) {
                    min = arr[i];
                }
            }
        }
    }
}


/**
 * 18，找到第二大数
 */
class FindSecondMaxNum {
    public int findSecondMaxNum(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else {
                if (arr[i] > secondMax) {
                    secondMax = arr[i];
                }
            }
        }

        return secondMax;
    }
}

/**
 * 19，找到出现在数组中重复最多的数
 */
class FinMostFreInArr {
    public int finMostFreInArr(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        //找到出现元素最多的元素
        int mostVal = 0;
        int resKey = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entty = (Map.Entry) it.next();
            int key = (int) entty.getKey();
            int val = (int) entty.getValue();
            if (val > mostVal) {
                resKey = key;
                mostVal = val;
            }
        }

        return resKey;
    }
}


/**
 * 20,一个数组中两两相加等于sum
 */
class FindSum {
    public List findSum(int[] arr, int sum) {
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> eqlList = new ArrayList<>();
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            if (arr[begin] + arr[end] < sum) {
                begin++;
            } else if (arr[begin] + arr[end] > sum) {
                end--;
            } else {
                ArrayList eleList = new ArrayList<Integer>();
                eleList.add(arr[begin]);
                eleList.add(arr[end]);

                eqlList.add(eleList);

                begin++;
                end--;
            }
        }

        return eqlList;
    }
}

/**
 * 21，把一个数组循环右移k位
 */
class ShiftK {
    public void shiftK(int[] arr, int k) {

        int len = arr.length;
        k = k % len; //防止k大于len
        reverse(arr, len - k, len - 1);
        reverse(arr, 0, len - k - 1);
        reverse(arr, 0, len - 1);
    }

    private void reverse(int[] arr, int b, int e) {
        for (; b < e; b++, e--) {
            int temp = arr[b];
            arr[b] = arr[e];
            arr[e] = temp;
        }
    }
}


/**
 * 21,找出第k小的数
 * <p>
 * 采用快速排序的思想来实现。选一个数 tmp = a[n-1] 作为枢纽， 把比他小的数都放在他的左边，比他大的数放在他的右边，然后判断tmp的位置，
 * 如果他的位置 == k-1, 那么它就是第k个最小的数；
 * 如果它的位置 < k-1,  那么第k个小的元素一定在数组的右半部分, 采用递归的方法在数组的右半部分继续查找；
 * 如果它的位置 > k-1,  那么第k个小的元素一定在数组的左半部分, 采用递归的方法在数组的左半部分继续查找；
 */
class GetKMin {
    public int getKMin(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return Integer.MIN_VALUE;
        }
        return quikSort(arr, 0, arr.length - 1, k);
    }


    private int quikSort(int[] arr, int low, int high, int k) {
//		第0个元素作为枢纽
        int i = low;
        int j = high;
        int tmp = arr[i];

        if (low > high) {
            return Integer.MIN_VALUE;
        }

//		快速排序
        while (i < j) {

            //找到右边比temp小的
            while (i < j && arr[j] >= tmp) {
                j--;
            }

            //此时，j指向比temp小的数。如指向temp本身，则忽略
            if (i < j) {
                arr[i++] = arr[j]; //将较小的数赋值给arr[i]后，i++，
            }

            //找到比temp大的左边的数
            while (i < j && arr[i] < tmp) {
                i++;
            }

            //此时，i指向比temp大的数
            if (i < j) {
                arr[j--] = arr[i];  //将较大的数赋给 arr[j]，然后j--
            }
        }

        //此时，i指向排序好的序列的下一位
        arr[i] = tmp;  //此时在temp的左边比temp小，在temp的右边的temp大

//		判断i+1与k的大小
        if (i + 1 == k) {
            return tmp;
        } else if (i + 1 > k) {
            return quikSort(arr, low, i - 1, k);
        } else {
            return quikSort(arr, i + 1, high, k);
        }
    }
}


/**
 * 22,找出数组中只出现一次的数字
 * 一个数组中其他数字出现多次，只有一个数字出现1次
 */
class FindNotDouble {
    public int findNotDouble(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }

        return res;
    }
}


/**
 * 23，找出数组中唯一出现重复1次的数
 * 问题描述：数组a[N]中，1~N-1为其中的数，其中某个数重复1次
 */
class FindOnlyDoubleNum {
    //1，求和法
    public int findOnlyDoubleNumBySum(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            sum1 += (i + 1);
            sum2 += arr[i];
        }
        sum2 += arr[arr.length - 1];

        return sum2 - sum1;
    }

    //2，异或法
    public int findOnlyDoubleNumByXor(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            res ^= i;
        }

        return res;
    }
}


/**
 * 24,用递归方法求出数组的最大值
 * 回溯找最大值
 */
class FindMaxNumByRec {
    public int findMaxNumByRec(int[] arr, int begin) {
        int len = arr.length - begin;
        if (len == 1) {
            return arr[begin];
        } else {
            return max(arr[begin], findMaxNumByRec(arr, begin + 1));
        }
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}


/**
 * 25,求解数对之差最大值
 */
class GetMaxDif {

    //方法1，动态规划法
    public int getMaxDifByDp(int[] arr) {
        if (arr == null) {
            return Integer.MIN_VALUE;
        }
        int len = arr.length;
        if (len <= 1) {
            return Integer.MIN_VALUE;
        }
        int diff = 0;
        int max = arr[0];
        for (int i = 1; i < len; i++) {
            diff = max(diff, max - arr[i]);
            max = max(max, arr[i]);
        }
        return diff;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }


    //方法2
    public int getMaxDif(int[] arr) {
        int nMax = arr[0];  //当前数组的最大值
        int nMaxDiff = 0;   //当前最大数对之差
        int nCurDiff = 0;   //最大值与数组下标为i的元素的差值

        for (int i = 1; i < arr.length; i++) {
            if (nMax < arr[i - 1]) {
                nMax = arr[i - 1];
            }

            nCurDiff = nMax - arr[i];

            //更新数组中以i结尾的数对之差的最大值
            if (nCurDiff > nMaxDiff) {
                nMaxDiff = nCurDiff;
            }
        }

        return nMaxDiff;
    }
}


/**
 * 26,求升序数组中绝对值最小的数
 */
class GetMinAbsNum {
    public int getMinAbsNum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return Integer.MIN_VALUE;
        }

        //数组中没有负数
        if (arr[0] > 0) {
            return arr[0];
        }

        //数组中都是负数
        if (arr[arr.length - 1] < 0) {
            return arr[arr.length - 1];
        }

        //数组中既有正数，也有负数的情况
        int mid = 0;
        int begin = 0;
        int end = arr.length - 1;
        int absMin = 0;
        while (true) {
            mid = (begin + end) >> 1;
            //如果值等于0，那么就是绝对值最小的数
            if (arr[mid] == 0) {
                return arr[mid];

                //如果值大于0，那么正负分界点在左边
            } else if (arr[mid] > 0) {
                //继续在左边找
                if (arr[mid - 1] > 0) {
                    end = mid - 1;
                } else if (arr[mid - 1] == 0) {
                    return 0;
                } else {
                    break; //在左边找到正负分界点
                }

                //如果值小于0，那么正负分界点在右边
            } else {
                if (arr[mid + 1] < 0) {
                    begin = mid + 1;
                } else if (arr[mid + 1] == 0) {
                    return 0;
                } else {
                    break; //找到正负分界点
                }
            }
        }

        //此时已经找到正负分界点
        if (arr[mid] > 0) {
            if (arr[mid] < Math.abs(arr[mid - 1])) {
                absMin = arr[mid];
            } else {
                absMin = arr[mid - 1];
            }

        } else {
            if (Math.abs(arr[mid]) < arr[mid + 1]) {
                absMin = arr[mid];
            } else {
                absMin = arr[mid + 1];
            }
        }

        return absMin;
    }
}


/**
 * 27,求两个给定数字的最小距离
 */
class GetMinDistance {

    public int getMinDistance(int[] arr, int n1, int n2) {
        if (arr == null || arr.length < 1) {
            return Integer.MIN_VALUE;
        }

        int len = arr.length;
        int n1Index = -1;
        int n2Index = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (arr[i] == n1) {
                n1Index = i;

                if (n2Index >= 0) {
                    minDistance = min(minDistance, Math.abs(n1Index - n2Index));
                }
            }


            if (arr[i] == n2) {
                n2Index = i;

                if (n1Index >= 0) {
                    minDistance = min(minDistance, Math.abs(n1Index - n2Index));
                }
            }

        }

        return minDistance;
    }


    private int min(int a, int b) {
        return a < b ? a : b;
    }
}


/**
 * 28,求数字在数组中第一次出现的位置
 * <p>
 * 问题描述：数组中的相邻元素差值都为1。
 */
class GetFistOccurIndex {
    public int getFistOccurIndex(int[] arr, int k) {
        if (arr == null) {
            return -1;
        }

        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == k) {
                return i;
            } else {
                i += Math.abs(k - arr[i]);
            }
        }

        return -1;

    }
}

/**
 * 29,对数组的有序子序列进行合并排序
 * <p>
 * 数列如：{1,5,6,7,9,2,4,8,10}
 */
class SortTwoSortedSubArr {
    public void sortTwoSortedSubArr(int[] arr, int mid) {
        int temp;
        for (int i = 0; i < mid - 1; i++) {
            if (arr[mid] < arr[i]) {
                temp = arr[i];
                arr[i] = arr[mid];
                arr[mid] = temp;

                findRightPlaceForMid(arr, mid);
            }
        }
    }

    private void findRightPlaceForMid(int[] arr, int mid) {
        int temp;
        for (int i = mid; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
}


/**
 * 30，求两个有序数组的交集
 * <p>
 * 两个数组是有序的
 */
class GetMixed {
    public ArrayList<Integer> getMixed(int[] arr1, int[] arr2) {
        ArrayList<Integer> mixedList = new ArrayList<>();
        int i = 0;
        int j = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        while (i < len1 && j < len2) {
            if (arr1[i] == arr2[j]) {
                mixedList.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {  //小的递增
                j++;
            } else {
                i++;
            }
        }

        return mixedList;
    }
}


/**
 * 31,求数组中反序列的个数
 */
class GetReverseCnt {
    //1，暴力法
    public int getReverseCnt(int[] arr) {
        int cnt = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //2，分支归并法
    int reverseCnt = 0;
    public void mergeSortAndGetReverseCnt(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) >> 1;
            mergeSortAndGetReverseCnt(arr, begin, mid);
            mergeSortAndGetReverseCnt(arr, mid + 1, end);
            merge(arr, begin, mid, end);
        }


    }

    private void merge(int[] arr, int begin, int mid, int end) {
        int i, j, k, n1, n2;
        n1 = mid - begin + 1;
        n2 = end - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        //将左边的数放进去
        for (i = 0, k = begin; i < n1; i++, k++) {
            L[i] = arr[k];
        }

        //将右边的数放进去
        for (i = 0, k = mid + 1; i < n2; i++, k++) {
            R[i] = arr[k];
        }

        //排序
        for (i = 0, j = 0, k = begin; i < n1 && j < n2; k++) {
            if (L[i] < R[j]){
                arr[k] = L[i++]; //将较小的数放进原数组
            }else{
                reverseCnt += mid - i + 1;  //？
                arr[k] = R[j++];  //将较小的数放进原数组
            }
        }

        if (i < n1){
            for (j = i; j < n1; j++, k++) {
                arr[k] = L[j];
            }
        }

        if (j < n2){
            for (i = j; i < n2; i++, k++) {
                arr[k] = R[i];
            }
        }
    }
}