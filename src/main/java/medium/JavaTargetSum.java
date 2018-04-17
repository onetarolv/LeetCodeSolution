package medium;

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 */
public class JavaTargetSum {
    /** dfs solutions: only beat 7% */
    int count = 0;
    private void dfs(int[] nums, int S, int idx) {
        if (idx == nums.length && S == 0)
            count ++;
        else if (idx < nums.length){
            dfs(nums, S + nums[idx], idx + 1);
            dfs(nums, S - nums[idx], idx + 1);
        }
    }
    public int findTargetSumWays_dfs(int[] nums, int S) {
        if (nums != null || nums.length != 0)
            dfs(nums, S, 0);
        return count;
    }

    /** dynamic programing solutions:  beat 71% */
    public int findTargetSumWays_dp(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        int[][] cnt = new int[nums.length][2001];
        cnt[0][nums[0] + 1000] = 1;
        cnt[0][-nums[0] + 1000] += 1;
        for (int j = 1; j < nums.length; j ++) {
            for (int i = 0; i < 2001; i ++) {
                if (cnt[j - 1][i] > 0) {
                    cnt[j][i - nums[j]] += cnt[j - 1][i];
                    cnt[j][i + nums[j]] += cnt[j - 1][i];
                }
            }
        }
        return cnt[nums.length - 1][S + 1000];
    }

    /** knapsack solutions:  beat 89%
     *  find the collection whose total value is (S + sum(nums))/2
     * */
    public int findTargetSumWays_knapsack(int[] nums, int S) {
        if (nums == null || nums.length == 0 || S > 1000)
            return 0;
        int sum = 0;
        for (int num: nums)
            sum += num;
        if ((sum + S) % 2 != 0 || sum < S)
            return 0;
        int target = (sum + S) / 2;
        int[] cnt = new int[target + 1];
        cnt[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= 0; i --) {
                if (num <= i)
                    cnt[i] += cnt[i - num];
            }
        }
        return cnt[target];
    }


    public static void main(String[] args) {
        JavaTargetSum test = new JavaTargetSum();
        int[] nums = {1,1,1,1,1};
        int res = test.findTargetSumWays_dp(nums, 3);
        System.out.println(res);
    }
}
