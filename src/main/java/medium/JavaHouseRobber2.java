package medium;

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/description/
 */
public class JavaHouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length -2), rob(nums, 1,  nums.length - 1));
    }

    public int rob(int[] nums, int first, int last) {
        if (last - first < 0)
            return 0;
        if (last - first == 0)
            return nums[first];
        int pre2 = 0, pre1 = nums[first];
        for (int i = first + 1; i <= last; i ++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
