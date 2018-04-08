package medium;

/**
 * 376. Wiggle Subsequence
 * https://leetcode.com/problems/wiggle-subsequence/description/
 */

public class JavaWiggleSubsequence {
    public static boolean sym(int a, int b) {
        return a > b ? true : false;
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int len = nums.length;
        int max = 0;
        for (int i = 0; i  < len; i ++) {
            int tail = nums[i];
            int count = 1;
            boolean start = false;
            boolean flag = true;
            for (int j = i + 1; j < len; j ++) {
                if (tail == nums[j])
                    continue;
                if (!start) {
                    flag = sym(nums[j],tail);
                    tail = nums[j];
                    start = true;
                    count ++;
                    continue;
                }
                if (flag ^ sym(nums[j], tail)) {
                    flag = !flag;
                    count += 1;
                }
                tail = nums[j];
            }
            if (max < count)
                max = count;
        }

        return max;
    }

    public static int wiggleMaxLength_simple(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int res = JavaWiggleSubsequence.wiggleMaxLength(nums);
        System.out.println(res);
    }
}
