package medium;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class JavaLongestIncreasingSubsequence {
    /** o(n^2)*/
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i ++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j --) {
                if (nums[j] >= nums[i])
                    continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /** o(nlogn)*/
    public static int lengthOfLIS_nlogn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] tail = new int[nums.length];
        int t = 0;
        for (int num: nums) {
            int start = 0, end = t;
            while (start != end) {
                int mid = start + (end - start) / 2;
                if (tail[mid] < num)
                    start = mid + 1;
                else
                    end = mid;
            }
            tail[start] = num;
            if (start == t)
                t ++;
        }
        return t;
    }

    public static void main(String[] args) {
        int res = lengthOfLIS(new int[]{-2, -1});
        System.out.println(res);
    }
}
