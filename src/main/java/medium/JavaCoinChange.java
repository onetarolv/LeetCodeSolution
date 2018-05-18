package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 322. Coin Change (Medium)
 */
public class JavaCoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return 0;
        int[] cnt = new int[amount + 1];
        Arrays.fill(cnt, amount + 1);
        cnt[0] = 0;

        for (int i = 1; i <= amount; i ++) {
            for (int val: coins) {
                if (val <= i)
                cnt[i] = Math.min(cnt[i], cnt[i - val] + 1);
            }
        }
        return cnt[amount] > amount ? -1 : cnt[amount];
    }
}
