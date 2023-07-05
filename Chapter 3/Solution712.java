import java.util.Arrays;

public class Solution712 {
    // 自顶向下
//    int[][] memo;
//
//    public int minimumDeleteSum(String s1, String s2) {
//        int m = s1.length();
//        int n = s2.length();
//        memo = new int[m][n];
//        for (int[] i : memo) {
//            Arrays.fill(i, -1);
//        }
//        // dp 函数的定义：s1[i...]和s2[j...]，使两个字符串相等所需删除字符的 ASCII 值的最小和
//        return dp(s1, 0, s2, 0);
//    }
//
//    private int dp(String s1, int i, String s2, int j) {
//        // base case
//        if (i == s1.length()) {
//            int res = 0;
//            while (j < s2.length()) {
//                res += s2.charAt(j);
//                j++;
//            }
//            return res;
//        }
//        if (j == s2.length()) {
//            int res = 0;
//            while (i < s1.length()) {
//                res += s1.charAt(i);
//                i++;
//            }
//            return res;
//        }
//
//        if (memo[i][j] != -1) {
//            return memo[i][j];
//        }
//        if (s1.charAt(i) == s2.charAt(j)) { // 不需要删除
//            memo[i][j] = dp(s1, i + 1, s2, j + 1);
//        } else {
//            memo[i][j] = Math.min(dp(s1, i + 1, s2, j) + s1.charAt(i), dp(s1, i, s2, j + 1) + s2.charAt(j));
//        }
//        return memo[i][j];
//    }
    // 自底向上
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) { // 偏移是这里体现的，跟里面的循环体没有关系，里面的循环体是dp逻辑
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
}
