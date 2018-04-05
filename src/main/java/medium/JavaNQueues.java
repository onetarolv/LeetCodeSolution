package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queues
 * https://leetcode.com/problems/n-queens/description/
 *
 * 45 line: id = row + col
 * 135 line: id = row - col + n - 1
 */
public class JavaNQueues {
    private int n;
    boolean[] cols;
    boolean[] plus;
    boolean[] minus;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if (n > 0) {
            this.n = n;
            cols = new boolean[n];
            plus = new boolean[2 * n - 1];
            minus = new boolean[2 * n - 1];
            backtracking(0, new ArrayList<String>());
        }
        return res;
    }

    private int id(int r, int c) {
        return r - c + n - 1;
    }
    private void backtracking(int idx, ArrayList<String> pos) {
        if (idx == n) {
            res.add(new ArrayList<>(pos));
            return;
        }
        char[] line = new char[n];
        for (int i = 0; i < n; i ++)
            line[i] = '.';
        for (int c = 0; c < n; c ++) {
            if (cols[c] || plus[c + idx] || minus[id(idx, c)])
                continue;
            cols[c] = plus[c + idx] = minus[id(idx, c)] = true;
            line[c] = 'Q';
            pos.add(new String(line));
            backtracking(idx + 1, pos);
            pos.remove(pos.size() - 1);
            line[c] = '.';
            cols[c] = plus[c + idx] = minus[id(idx, c)] = false;
        }
    }

    public static void main(String[] args) {
        JavaNQueues test = new JavaNQueues();
        List<List<String>> res = test.solveNQueens(4);
        int i = 1;
        for(List<String> one: res) {
            System.out.println("solution" + (i ++) + ":");
            for (String line : one) {
                System.out.println(line);
            }
            System.out.println("-----------------");
        }
    }
}

