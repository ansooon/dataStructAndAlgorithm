package dp;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-10-30 17:10
 */
public class DpDemo {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.search(0, 0));
    }

}

class Solution1{
    private int[] w = new int[]{1, 2};  //重量
    private int[] v = new int[]{3, 2};  //价值
    private static int W = 1;  //总重量
    private static int n = 2;  //总重量


    int search(int idx, int S){
        if(S > W){
            return 0;
        }

        if(idx >= n){
            return 0;
        }

        return Math.max(search(idx + 1, S + w[idx]) + v[idx], search(idx + 1, S));
    }
}
