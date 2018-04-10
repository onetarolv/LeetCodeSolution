package others;

/**
 * Created by DELL_PC on 2018/4/10.
 */
public class JavaKnapsack {
    public static int knapsack_2d(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        //dp[i][j] denotes the maximum value for the first i-th items,
        // if the weight is not greater than j
        for (int i = 1; i <= N; i ++) {
            int curW = weights[i], curV = values[i];
            for (int j = 1; j <= W; j ++) {
                // if the i-th item is not selected, dp[i][j] ==dp[i-1][j];
                // if selected, dp[i][j] = dp[i -1][j-w] + v
                if (j >= curW)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - curW] + curV);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[N][W];
    }

    public static int knapsack_1d(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i ++) {
            int curW = weights[i], curV = values[i];
            //when we calculate dp[j], we use the dp[j-w] calculated in the previous round;
            //so we should calculate w[j] first.
            // In this round, we judge the situation about the i-th item, so we should use w[j-w] about the first i-1 items.
            //if we calculate w[j-w] first, w[j-w] is updated about the first i items.
            for (int j = W; j >= 1; j --) {
                if (j >= curW)
                    dp[j] = Math.max(dp[j], dp[j - curW] + curV);
            }
        }
        return dp[W];
    }

    public static void main() {

    }
}
