package medium;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class JavaClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int pre1 = 2, pre2 = 1;
        for(int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
