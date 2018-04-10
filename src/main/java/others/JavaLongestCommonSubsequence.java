package others;

/**
 * Created by engry on 2018/4/8.
 */
public class JavaLongestCommonSubsequence {
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return 0;
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++ ) {
                if (nums1[i - 1] ==nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
