import java.util.Arrays;

public class Solution10 {
    boolean[][] memo;

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        memo = new boolean[m][n];
        for (boolean[] i : memo) {
            Arrays.fill(i, false);
        }
        // dp函数的定义：字符串s[i...]可以被模式串p[j...]匹配,则dp(i, s, j, p) = true,否则dp(i, s, j, p) = false
        return dp(0, s, 0, p);
    }

    private boolean dp(int i, String s, int j, String p) {
        int m = s.length();
        int n = p.length();
        // base case
        // 模式串走完了，判断字符串是否走完
        if (j == n) {
            return i == m;
        }

        // 字符串走完了，看剩余的模式串的情况
        if (i == m) {
            // 剩余必须是偶数才有可能
            if ((n - j) % 2 == 1) {
                return false;
            } else {
                // x*y*z*模式
                while (j + 1 < n) {
                    if (p.charAt(j + 1) != '*') {
                        return false;
                    }
                    j += 2;
                }
            }
            return true;
        }
        if (memo[i][j]) {
            return memo[i][j]; // true
        }
        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j + 1 < n && p.charAt(j + 1) == '*') {
                // p[j]匹配0次或者多次
                res = dp(i, s, j + 2, p) || dp(i + 1, s, j, p);
            } else {
                res = dp(i + 1, s, j + 1, p);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // p[j]只能匹配0次
                res = dp(i, s, j + 2, p);
            } else {
                return false;
            }
        }
        memo[i][j] = res;
        return memo[i][j];
    }
}
