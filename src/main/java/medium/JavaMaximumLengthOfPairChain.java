package medium;

import java.util.Arrays;

/**
 * 646. Maximum Length of Pair Chain
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */
public class JavaMaximumLengthOfPairChain {
    public static int findLongestChain(int[][] pairs) {
//        Arrays.sort(pairs,new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0)
            return 0;
        Arrays.sort(pairs, ((o1, o2) -> o1[0] - o2[0]));
//        print(pairs);
        int len = pairs.length;
        int[] tails = new int[len];
        int[] dp = new int[len];
        tails[0] = pairs[0][1];
        dp[0] = 1;
        for (int i = 1; i < len; i ++) {
            if (pairs[i][0] > tails[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                tails[i] = pairs[i][1];
//                System.out.println("pair = [" + pairs[i][0] + "," + pairs[i][1] + "], tail = " + tails[i]);
            } else {
                dp[i] = dp[i - 1];
                tails[i] = pairs[i][1] < tails[i - 1] ? pairs[i][1] : tails[i - 1];
            }
        }
        return dp[len - 1];
    }

    public static int findLongestChain_cmp1(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0)
            return 0;
        Arrays.sort(pairs, ((o1, o2) -> o1[1] - o2[1]));
        int len = pairs.length;
        int tail = pairs[0][1], count = 1;
        for (int i = 1; i < len; i ++) {
            if (pairs[i][0] > tail) {
                count += 1;
                tail = pairs[i][1];
            }
        }
        return count;
    }

    public static int findLongestChain_cmp0(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0)
            return 0;
        Arrays.sort(pairs, ((o1, o2) -> o1[0] - o2[0]));
        int len = pairs.length;
        int tail = pairs[0][1], count = 1;
        for (int i = 1; i < len; i ++) {
            if (pairs[i][0] > tail) {
                count += 1;
                tail = pairs[i][1];
            } else {
                tail = pairs[i][1] < tail ? pairs[i][1] : tail;
            }
        }
        return count;
    }

    public static void print(int[][] arr) {
        for (int[] row: arr) {
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        String pre = "[[9,10],[-9,9],[-6,1],[-4,1],[8,10],[7,10],[9,10],[2,10]]";
//        String r1 = pre.replace('[','{').replace(']', '}');
//        System.out.println(r1);
        int[][] pairs = {{9,10},{-9,9},{-6,1},{-4,1},{8,10},{7,10},{9,10},{2,10}};
        int res = JavaMaximumLengthOfPairChain.findLongestChain_cmp1(pairs);
        System.out.print(res);
    }
}
