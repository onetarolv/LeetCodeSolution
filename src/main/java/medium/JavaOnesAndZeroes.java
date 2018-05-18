package medium;

/**
 * 474. Ones and Zeroes
 */
public class JavaOnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] grids = new int[m + 1][n + 1];
        for (String str: strs) {
            char[] chars = str.toCharArray();
            int z = 0, o = 0;
            for (char c: chars) {
                if (c == '0')
                    z ++;
                else
                    o ++;
            }
            for (int i = m; i >= z; i --) {
                for (int j = n; j >= o; j --){
                    grids[i][j] = Math.max(grids[i][j], grids[i - z][j - o] + 1);
                }
            }
        }
        return grids[m][n];
    }
}
