package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 */
public class JavaWordBreak {
    public static boolean wordBreak_dp(String s, List<String> wordDict) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            for (int j = i; j >= 0; j --) {
                if (wordDict.contains(s.substring(j, i + 1)))
                    dp[j][i] = true;
                else {
                    for (int k = j; k <= i - 1; k ++) {
                        if (dp[j][k] && dp[k + 1][i]) {
                            dp[j][i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][len - 1];
    }

    public static boolean wordBreak_knapsack(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i ++) {
            for (String word: wordDict) {
                int l = word.length();
                if (l <= i && word.equals(s.substring(i - l, i)))
                    dp[i] = dp[i] || dp[i - l];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String str = "leetacodea";
        List<String> dict = new ArrayList<String>();
        dict.add("leet");
        dict.add("code");
        dict.add("a");
        System.out.println(wordBreak_knapsack(str, dict));
    }
}
