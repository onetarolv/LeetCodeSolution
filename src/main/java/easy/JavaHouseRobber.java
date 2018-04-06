package easy;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 */
public class JavaHouseRobber {
    public int rob_1darr(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] d = new int[nums.length + 1];
        d[0] = 0;
        d[1] = nums[0];
        for (int i = 2; i <= nums.length; i ++) {
            d[i] = Math.max(d[i - 2] + nums[i - 1], d[i - 1]);
        }
        return d[nums.length];
    }

    public int rob_2val(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int pre2 = 0, pre1 = nums[0];
        for (int i = 2; i <= nums.length; i ++) {
            int cur = Math.max(pre2 + nums[i - 1], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }


}
