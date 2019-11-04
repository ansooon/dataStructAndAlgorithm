package leetcode;

import java.util.*;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2019-10-24 18:53
 */
public class SolutionDemo {

    public static void main(String[] args) {


//        //2，两数之和
//        ListNode listNode1 = new ListNode(5);
////        listNode1.next = new ListNode(4);
////        listNode1.next.next = new ListNode(3);
//
//        ListNode listNode2 = new ListNode(5);
////        listNode2.next = new ListNode(6);
////        listNode2.next.next = new ListNode(4);
//
//        Solution2 solution2 = new Solution2();
//        ListNode listNodeResult = solution2.addTwoNumbers(listNode1, listNode2);
//        System.out.println(listNodeResult.toString());


//        //3,最长子串的长度
//        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.lengthOfLongestSubstringBySet("abcabcbb"));
//        System.out.println(solution3.lengthOfLongestSubstringByMap("abba")); //abba
//        System.out.println(solution3.subOfLongestSubstringBySet("abba"));
//        System.out.println(solution3.subOfLongestSubstringByMap("abba"));

//        //5，最长回文子串
//        Solution5 solution5 = new Solution5();
//        System.out.println(solution5.longestPalindrome(""));

//        //6,打印Z字形
//        Solution6 solution6 = new Solution6();
//        System.out.println(solution6.convert("LEETCODEISHIRING", 4));

//        //7,反转整数
//        Solution7 solution7 = new Solution7();
//        System.out.println(solution7.reverse(1234567777));

//        //8, 字符串转换整数 (atoi)
//        Solution8 solution8 = new Solution8();
//        System.out.println(solution8.myAtoi("words and 987"));

//        //9,判断是否是回文数
//        Solution9 solution9 = new Solution9();
//        System.out.println(solution9.isPalindrome(12321));

//        //11,盛最多水的容器
//        Solution11 solution11 = new Solution11();
//        System.out.println(solution11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

//        //12, 整数转罗马数字
//        Solution12 solution12 = new Solution12();
//        System.out.println(solution12.intToRoman(1994));

//        //13, 罗马数字转整数
//        Solution13 solution13 = new Solution13();
//        System.out.println(solution13.romanToInt("LVIII"));

//        //14. 最长公共前缀
//        Solution14 solution14 = new Solution14();
//        System.out.println(solution14.longestCommonPrefix(new String[]{"flower","flow","flight"}));

//        //15, 三数之和
//        Solution15 solution15 = new Solution15();
//        System.out.println(solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

//        //16. 最接近的三数之和
//        Solution16 solution16 = new Solution16();
//        System.out.println(solution16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));


//        //17. 电话号码的字母组合
//        Solution17 solution17 = new Solution17();
//        System.out.println(solution17.letterCombinations("234"));

//        //20,有效的括号
//        Solution20 solution20 = new Solution20();
//        System.out.println(solution20.isValid("()[]{}"));

//        //26. 删除排序数组中的重复项
//        Solution26 solution26 = new Solution26();
//        System.out.println(solution26.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

//        //33，搜索旋转排序数组
//        Solution33 solution33 = new Solution33();
//        System.out.println(solution33.search(new int[] {4,5,6,7,0,1,2}, 0));

        //34. 在排序数组中查找元素的第一个和最后一个位置
//        Solution34 solution34 = new Solution34();
//        int[] result = solution34.searchRange(new int[] {5,7,7,8,8,10}, 8);
//        System.out.println(Arrays.toString(result));

//        //39. 组合总和（可以无数次取）
//        Solution39 solution39 = new Solution39();
//        System.out.println(solution39.combinationSum(new int[]{2, 3, 6, 7}, 7));

        //40，只可以取一次
        Solution40 solution40 = new Solution40();
        System.out.println(solution40.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}


//2,两数之和-链表
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        ListNode cur = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null ? 0 : l1.val);
            int y = (l2 == null ? 0 : l2.val);

            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode newListNode = new ListNode(sum);
            if (null == resultHead) {
                resultHead = newListNode;
                cur = newListNode;
            } else {
                cur.next = newListNode;
                cur = cur.next; //指向尾节点
            }

            if (null != l1) l1 = l1.next;
            if (null != l2) l2 = l2.next;

        }

        //注意退出的时候要特别考虑
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return resultHead;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


/**
 * 3，无重复字符的最长子串.如果改成输出最长子串呢？
 */
class Solution3 {
    public int lengthOfLongestSubstringBySet(String s) {
        //滑动窗口法：左边进行滑动，检查右边
        Set<Character> set = new HashSet<>();  //易错Character，不是int！1

        int len = s.length();  //易错2！
        int result = 0, i = 0, j = 0;  //result将被进行前后大小判断以迭代

        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));  //添加完成之后才i++;
                result = Math.max(result, j - i);
            } else {
                set.remove(i++);
            }
        }

        return result;
    }

    public int lengthOfLongestSubstringByMap(String s) {
        //滑动窗口法：左边进行滑动，检查右边
        Map<Character, Integer> map = new HashMap<>();  //易错Character，不是int！1

        int len = s.length();  //易错2！
        int result = 0, i = 0, j = 0;  //result将被进行前后大小判断以迭代

        while (j < len) {
            //map添加前判断，更新i
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i); //易错！难点！形如abba时，当j轮到a时，避免i返回去取第一个a的值1
            }
            //一定添加
            map.put(s.charAt(j++), j); //易错，这个地方将更新值，而键不变！“键数值位”
            result = Math.max(result, j - i);
        }

        return result;
    }


    //获取最大子串
    public String subOfLongestSubstringBySet(String s) {
        //滑动窗口法：左边进行滑动，检查右边
        Set<Character> set = new HashSet<>();
        int[] indexs = new int[]{0, 0};

        int len = s.length();
        int difMax = 0, i = 0, j = 0;

        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) { //这里要等到i走到重复的字母前面才会停止。难点！
                set.add(s.charAt(j++));

                if ((j - i) > difMax) {   //对当前的j进行操作，避免j++的影响
                    indexs[0] = i;
                    indexs[1] = j;   //正好j+1，即在被截取的字符的后面
                    difMax = j - i;
                }

            } else {
                set.remove(s.charAt(i++));  //为什么删除的是i++？因为要使得i的左边不包括在集合里

            }
        }

        return s.substring(indexs[0], indexs[1]); //易错，substring含头不含尾（避开区间）
    }

    public String subOfLongestSubstringByMap(String s) {
        //滑动窗口法：左边进行滑动，检查右边
        Map<Character, Integer> map = new HashMap<>();
        int[] indexs = new int[]{0, 0};

        int len = s.length();
        int difMax = 0, i = 0, j = 0;

        while (j < len) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(s.charAt(j), i);
            }

            map.put(s.charAt(j++), j);

            if (j - i > difMax) {
                difMax = j - i;
                indexs[0] = i;
                indexs[1] = j;
            }
        }

        return s.substring(indexs[0], indexs[1]); //易错，substring含头不含尾（避开区间）
    }
}


/**
 * 5，最长回文子串
 */
class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        String sSub = "";
        String huiWenMax = "";

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                sSub = s.substring(i, j);
                if (isHuiWenString(sSub)) {
                    huiWenMax = sSub.length() > huiWenMax.length() ? sSub : huiWenMax;

                }
            }
        }
        return huiWenMax;
    }

    private boolean isHuiWenString(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

/**
 * 6, Z字形变换
 */
class Solution6 {

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        //先放n个SB对象
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;

        //遍历字符串字符
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {  //每一行的首位或者末位
                flag = -flag;
            }

            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}

/**
 * 7，反转正数
 */
class Solution7 {
    public int reverse(int x) {
        int result = 0, a = 0;
        while (x != 0) {
            a = x % 10;     // 得到最低位（除去低，百得低）
            if (result > Integer.MAX_VALUE / 10 || ((Integer.MAX_VALUE / 10) == result && Integer.MAX_VALUE % 10 < a)) {
                return 0;   // 考虑溢出问题 数值范围 [-2^31, 2^31 - 1],Integer.MAX_VALUE % 10 < a 最后一位大于最大数的最后一位
            }
            if (result < Integer.MIN_VALUE / 10 || ((Integer.MAX_VALUE / 10) == result && Integer.MIN_VALUE % 10 > a)) {
                return 0;
            }
            result = result * 10 + a;
            x = x / 10;
        }
        return result;
    }
}


/**
 * 8, 字符串转换整数 (atoi)
 */
class Solution8 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        // 偷懒做法，去掉空格，也可以用while循环来做
        String temp = str.trim();
        if (temp.equals("") || temp.length() == 0) {
            return 0;
        }

        //正数标记
        boolean flag = true;
        char[] bits = temp.toCharArray();
        int i = 0;
        int res = 0;
        int bit = 0;

        //负数标记
        if (bits[0] == '-') {
            flag = false;
        }

        //如果是符号位，那么就将i往后移一位
        if (bits[0] == '+' || bits[0] == '-') {
            i++;
        }

        for (; i < bits.length; i++) {
            if (bits[i] >= '0' && bits[i] <= '9') {  //如果是数字
                bit = bits[i] - '0';
            } else {
                break;  //如果为非数字，那么直接退出
            }
            // 这里巧妙的应用了如果溢出就取最大值 Integer.MAX_VALUE 或 Integer.MIN_VALUE，[-2147483648，2147483647]
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && bit > 7)) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + bit;
        }
        return flag ? res : -res;
    }
}


//9,判断是否是回文数
class Solution9 {
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {  //只循环到中位
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}


//11,盛最多水的容器
class Solution11 {
    public int maxArea(int[] height) {
//        int maxarea = 0;
//        for (int i = 0; i < height.length; i++)
//            for (int j = i + 1; j < height.length; j++)
//                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
//        return maxarea;

        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));

            //谁的板子小则跳过谁
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }

        }
        return maxarea;
    }
}


//12, 整数转罗马数字
class Solution12 {

    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }
}


//13. 罗马数字转整数
class Solution13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {  //包含两个字符
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {  //只包含一个字符
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }
}


//14. 最长公共前缀
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];  //首先将第一个字符串进行初始化
        for (int i = 1; i < strs.length; i++) { //遍历除了第一个字符串之后的所有剩余字符串
            int j = 0;

            //找到不相等的j值
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }

            //获取共同子串
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }
}

/**
 * 15. 三数之和
 */
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重
            }

            int L = i + 1;
            int R = len - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++; // 去重
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }
}


/**
 * 16. 最接近的三数之和
 */
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  //排序
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }

                //组目标是将sum变小，因数组有序，当sum > target时，说明sum很多，应将end--；反之，则将start++
                if (sum > target) {
                    end--;
                } else if (sum < target)
                    start++;
                else {
                    return ans;  //如果循环到最后，如果等于0，那么就将结果返回
                }
            }
        }
        return ans;
    }
}

/**
 * 17. 电话号码的字母组合
 */
class Solution17 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    private void backtrack(String combination, String next_digits) {

        //回溯组合
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {

            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1); //分别取每一个字符

                //next_digits.substring(1)。递归到最后一位数字，然后再回溯组合在一起
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }
}


/**
 * 19. 删除链表的倒数第N个节点
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        //移动n位
        for (int i = 0; i < n; i++) {
            second = second.next;
        }

        if (null == second) {  //如果是null == second，说明删除的是头结点，特殊处理
            head = head.next;
            return head;     //注意要返回

        } else {
            while (second.next != null) {
                first = first.next;
                second = second.next;
            }

            first.next = first.next.next; //是first.next = ...，而不是first = ...

            return head;
        }
    }

    //内部类
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

/**
 * 20,有效的括号
 */
class Solution20 {
    private final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        stack.add('?');

        //策略，进来一个弹出一个进行判断，最后如果只剩下一个？，那么就是真括号
        for (Character c : s.toCharArray()) { //最后不会进来？
            if (map.containsKey(c)) {
                stack.add(c);
            } else if (map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}


/**
 * 21，leetCode上面给的算法其实没有封装好List类，但是提供了Node节点的定义，List类应该定义一个头节点
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode newHead = null;
        ListNode cur = null;

        if (null == l1 && null == l2) {
            return null;
        }

        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }

        //将头节点指向最小的那个链表
        if (head1.val < head2.val) {
            newHead = head1;
            cur = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            cur = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }

        cur.next = head1 == null ? head2 : head1;

        return newHead;
    }
}


/**
 * 24. 两两交换链表中的节点
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;     //要交换的前节点
            ListNode end = temp.next.next;  //要交换的后节点
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}

/**
 * 26. 删除排序数组中的重复项
 */
class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int first = 0;

        //不重复就放左边
        for (int second = 1; second < nums.length; second++) {
            //如果不相等，就更新慢指针，同时在慢指针处插入新值，慢指针同时还起到计数的作用
            if (nums[second] != nums[first]) {
                first++;
                nums[first] = nums[second];  //因为前几个元素存储不重复的数字
            }
        }
        return first + 1;
    }
}

/**
 * 27. 移除元素
 */
class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0;

        //不等就放左边
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }
}


/**
 * 28,实现 strStr(),判断是否存在子串
 */
class Solution28 {
    public int strStr(String haystack, String needle) {
        int lenH = haystack.length();
        int lenN = needle.length();

        for (int i = 0; i < lenH - lenN + 1; i++) {
            if (haystack.substring(i, i + lenN).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}


/**
 * 33, 搜索旋转排序数组
 */
class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}


/**
 * 35，搜索插入位置
 */
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        //如果给的target太长，那么就返回最末尾的插入位置，即末尾加1
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // 等于的情况最简单，我们应该放在第 1 个分支进行判断
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 题目要我们返回大于或者等于目标值的第 1 个数的索引
                // 此时 mid 一定不是所求的左边界，
                // 此时左边界更新为 mid + 1
                left = mid + 1;
            } else {
                // 既然不会等于，此时 nums[mid] > target
                // mid 也一定不是所求的右边界
                // 此时右边界更新为 mid - 1
                right = mid - 1;
            }
        }
        // 注意：一定得返回左边界 left，
        // 如果返回右边界 right 提交代码不会通过
        // 【注意】下面我尝试说明一下理由，如果你不太理解下面我说的，那是我表达的问题
        // 但我建议你不要纠结这个问题，因为我将要介绍的二分查找法模板，可以避免对返回 left 和 right 的讨论

        // 理由是对于 [1,3,5,6]，target = 2，返回大于等于 target 的第 1 个数的索引，此时应该返回 1
        // 在上面的 while (left <= right) 退出循环以后，right < left，right = 0 ，left = 1
        // 根据题意应该返回 left，
        // 如果题目要求你返回小于等于 target 的所有数里最大的那个索引值，应该返回 right

        return left;
    }
}


// 34. 在排序数组中查找元素的第一个和最后一个位置
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找
        int[] result = new int[2];
        result[0] = searchFirst(nums, target);
        result[1] = searchLast(nums, target);

        return result;
    }

    private int searchFirst(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) return -1;

        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }

        return arr[left] == target ? left : -1;

    }

    private int searchLast(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) {
            return -1;
        }
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (arr[mid] <= target) left = mid;
            else right = mid - 1;
        }
        return arr[left] == target ? left : -1;
    }
}


//38. 报数
class Solution38 {
    public String countAndSay(int n) {
        String line = "1";
        for (int i = 1; i < n; i++) {
            line = countAndSayLine(line);
        }
        return line;
    }

    //临时写了一个，待优化
    private String countAndSayLine(String line) {
        StringBuilder newLine = new StringBuilder();
        int i = 0;
        int count = 0;
        while (i < line.length()) {
            if (i == 0 || line.charAt(i) == line.charAt(i - 1)) {
                count++;
            } else {
                newLine.append(count).append(line.charAt(i - 1));
                count = 1;
            }
            if (i == line.length() - 1) {
                newLine.append(count).append(line.charAt(i));
            }
            i++;
        }
        return newLine.toString();
    }
}


//39. 组合总和
class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            res.add(new ArrayList<>(pre)); //可以直接传Stack进去
            return;
        }
        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            findCombinationSum(residue - candidates[i], i, pre);
            pre.pop();  //存的是被减数
        }
    }
}


/**
 * 40,组合总和 II(每个元素只能取一次)
 */
class Solution40 {
    // residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
    // residue 在递归遍历中，只会越来越小
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }


    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            // 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }
}