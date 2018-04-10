package medium;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class JavaPartitionEqualSubsetSum {
    public boolean canPartition_knapsack(int[] nums) {
        int target = 0;
        for (int num: nums)
            target += num;
        if (target % 2 == 1)
            return false;
        target /= 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = target; j >= 1; j --) {
                if (nums[i] <= j)
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public boolean backtracking(int[] nums, int idx, int rest) {
        if (rest == nums[idx])
            return true;
        if (rest < nums[idx])
            return false;
        return backtracking(nums, idx + 1, rest - nums[idx]) ||
                backtracking(nums, idx + 1, rest);
    }
    public boolean canPartition_backtracking(int[] nums) {
        int target = 0;
        for (int num: nums)
            target += num;
        if (target % 2 == 1)
            return false;
        target /= 2;
        Arrays.sort(nums);
        return backtracking(nums, 0, target);
    }
}
