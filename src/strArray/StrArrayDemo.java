package strArray;

import sun.nio.ch.FileKey;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-08-21 16:52
 */
public class StrArrayDemo {
    public static void main(String[] args) {

        //1，反转字符串
//        SwapWords swapWords = new SwapWords();
//        System.out.println(swapWords.swapsWords("how are you"));

        //2，比较两个字符串是否是相同字符组成
//        CompareSam compareSam = new CompareSam();
//        System.out.println(compareSam.compareSamBySort("aaaabbc","abcbaaa"));
//        System.out.println(compareSam.compareSam("aaaabbc","abcbaa"));

        //3,删除重复字符
//        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
//        System.out.println(removeDuplicate.removeDuplicate("abcaabcd"));
//        System.out.println(removeDuplicate.removeDuplicateBySpace("abcaabcd"));

    }
}


/**
 * 1，反转字符串
 */
class SwapWords {
    public String swapsWords(String s) {
        char[] cArr = s.toCharArray();

        //对整个字符串进行反转
        swap(cArr, 0, cArr.length - 1);

        int begin = 0;
        //对每一个单词进行字符串反转
        for (int i = 0; i < cArr.length; i++) { //从1开始是因为最开头是“
            if (cArr[i] == ' ') {
                swap(cArr, begin, i - 1);
                begin = i + 1;
            }
        }

        //对最后一个单词进行反转
        swap(cArr, begin, cArr.length - 1);

        return new String(cArr);
    }

    private void swap(char[] cArr, int front, int end) {
        while (front < end) {
            char temp = cArr[end];
            cArr[end] = cArr[front];
            cArr[front] = temp;
            front++;
            end--;
        }
    }
}


/**
 * 2，比较两个字符串是否是相同字符组成
 */
class CompareSam {

    //1,排序法
    public boolean compareSamBySort(String s1, String s2) {

//        byte[] b1 = s1.getBytes();
//        byte[] b2 = s2.getBytes();
        char[] b1 = s1.toCharArray();
        char[] b2 = s2.toCharArray();
        Arrays.sort(b1);
        Arrays.sort(b2);

        s1 = new String(b1);
        s2 = new String(b2);

        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }


    //2,空间法
    public boolean compareSam(String s1, String s2) {
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();

        int[] bCnt = new int[256];

        //初始化为0
        for (int i = 0; i < bCnt.length; i++) {
            bCnt[i] = 0;
        }

        //统计个数，增加
        for (int i = 0; i < b1.length; i++) {
            bCnt[b1[i] - '0']++;
        }

        //统计个数，减少
        for (int i = 0; i < b2.length; i++) {
            bCnt[b1[i] - '0']--;
        }

        //检验
        for (int i = 0; i < bCnt.length; i++) {
            if (bCnt[i] != 0) {
                return false;
            }
        }

        return true;
    }
}


/**
 * 3,删除字符串中重复的字符
 */
class RemoveDuplicate {
    //1,暴力法
    public String removeDuplicate(String str) {
        char[] cArr = str.toCharArray();
        int len = cArr.length;
        for (int i = 0; i < len; i++) {
            if (cArr[i] == '\0') {  //ASCII码为0，表示一个字符串结束的标志
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                if (cArr[i] == '\0') {
                    continue;
                }

                if (cArr[i] == cArr[j]) {
                    cArr[i] = '\0';
                }
            }
        }

        //去掉'\0'
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (cArr[i] != '\0') {
                cArr[cnt++] = cArr[i];
            }
        }

        return new String(cArr, 0, cnt);
    }

    //2，空间换时间法
    public String removeDuplicateBySpace(String str) {
        char[] cArr = str.toCharArray();
        int len = cArr.length;
        int[] flags = new int[8]; //只需要8个32为的bit 的int，8 * 32 = 256 bit
        for (int i = 0; i < 8; i++) {
            flags[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            int index = (int) (cArr[i] / 32);
            int shift = (int) (cArr[i] % 32);
            if ((flags[index] & (1 << shift)) != 0) {  //???
                cArr[i] = '\0';
            }

            flags[index] |= (1 << shift); //???
        }


        //去掉'\0'
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (cArr[i] != '\0') {
                cArr[cnt++] = cArr[i];
            }
        }

        return new String(cArr, 0, cnt);
    }
}