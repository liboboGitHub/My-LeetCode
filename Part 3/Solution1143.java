import java.util.Arrays;

public class Solution1143 {
    /*************************自顶向下**************************/
//    int[][] memo;
//
//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        memo = new int[m][n];
//        for (int[] i : memo) {
//            Arrays.fill(i, -1);
//        }
//        // dp函数定义：返回s1[i...]和s2[j...]的最长公共子序列
//        return dp(text1, 0, text2, 0);
//    }
//
//    private int dp(String s1, int i, String s2, int j) {
//        // base case，只要其中有一个空串，结果必然是0
//        if (i == s1.length() || j == s2.length()) {
//            return 0;
//        }
//        if (memo[i][j] != -1) {
//            return memo[i][j];
//        }
//        if (s1.charAt(i) == s2.charAt(j)) {
//            memo[i][j] = dp(s1, i + 1, s2, j + 1) + 1;
//        } else {
//            memo[i][j] = Math.max(dp(s1, i, s2, j + 1), dp(s1, i + 1, s2, j)); // 同下
//        }
//        return memo[i][j];
//    }
    /*************************自顶向下**************************/


    /*************************自底向上**************************/
    public int longestCommonSubsequence(String text1, String text2) {
        char[] m = text1.toCharArray();
        char[] n = text2.toCharArray();
        int[][] dp = new int[m.length + 1][n.length + 1];
        dp[0][0] = 0; // base case
        for (int i = 1; i <= m.length; i++) {
            for (int j = 1; j <= n.length; j++) {
                if (m[i - 1] == n[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); //包含了dp[i-1][j-1]
                }
            }
        }
        return dp[m.length][n.length];
    }
    /*************************自底向上**************************/

}
