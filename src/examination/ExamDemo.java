package examination;

import java.util.Scanner;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-11-13 9:13
 */
public class ExamDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String s = sc.nextLine();
        int target = sc.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.splitAndSearchString2(s, target));
    }
}




class Solution{
    public String splitAndSearchString(String s, int target){
        int len = s.length();
        if(len > 1000){
            return "";
        }

        String[] words = s.split(";");

        return words[target];
    }

    public String splitAndSearchString2(String s, int target){
        int len = s.length();
        if(len > 1000){
            return "";
        }

        StringBuilder sb = new StringBuilder(s).append(";");

        int[] pArr = new int[] {0, 0};
        int count = -1;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == ';'){
                count++;
                pArr[count%2] = i;
            }
            if (count == target){
                break;
            }
        }

        int start = pArr[0] < pArr[1] ? pArr[0] : pArr[1];
        int end = pArr[0] > pArr[1] ? pArr[0] : pArr[1];

        if(start != 0){
            start++;
        }

        return sb.substring(start, end).toString();
    }
}


