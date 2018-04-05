package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 241. Different Ways to Add Parentheses
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 */
public class JavaDifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null)
            return res;
        if (input.length() == 1) {
            res.add(input.charAt(0) - '0');
            return res;
        }
        int strLen = input.length();
        int numCount = (strLen + 1) / 2;
        int opCount = numCount - 1;
        int[] nums = new int[numCount];
        char[] ops = new char[opCount];
        List<Integer>[][] values = new List[numCount][numCount];

        int i = 0, j = 0;
        for (int k = 0; k < strLen; k ++) {
            if (k % 2 == 0) {
                nums[i] = input.charAt(k) - '0';
                values[i][i] = new ArrayList<>();
                values[i][i].add(nums[i]);
                i ++;
            } else
                ops[j ++] = input.charAt(k);
        }


        for (int gap = 1; gap < numCount; gap ++){
            for (i = 0; i + gap < numCount; i ++) {
                j = i + gap;
                if (values[i][j] == null)
                    values[i][j] = new ArrayList<>();
                for (int k = i; k < j; k ++) {
                    List<Integer> vals1 = values[i][k];
                    List<Integer> vals2 = values[k + 1][j];
                    for (int val1 : vals1){
                        for (int val2 : vals2)
                            values[i][j].add(cal(ops[k], val1, val2));
                    }
                }
            }
        }
        return values[0][numCount - 1];
    }

    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        List<Integer> res = map.getOrDefault(input, new ArrayList<>());
        if (res.size() != 0)
            return res;
        for (int i = 0; i < len; i ++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> vals1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> vals2 = diffWaysToCompute(input.substring(i + 1));
                for (int val1 : vals1){
                    for (int val2 : vals2)
                        res.add(cal(c, val1, val2));
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }


    private int cal(char op, int num1, int num2) {
        int val = 0;
        switch (op) {
            case '-':
                val= num1 - num2;
                break;
            case '+':
                val = num1 + num2;
                break;
            case '*':
                val = num1 * num2;
                break;
        }
        return val;
    }

    public static void main(String args[]) {
        String input = "2*3-4*5";
        JavaDifferentWaysToAddParentheses test = new JavaDifferentWaysToAddParentheses();
        List<Integer> res = test.diffWaysToCompute(input);
        for (int val : res)
            System.out.println(val);
    }
}
