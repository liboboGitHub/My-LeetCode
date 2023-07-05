import java.util.Arrays;

public class Solution72 {
//    int[][] memo;
//
//    public int minDistance(String word1, String word2) {
//        int l1 = word1.length();
//        int l2 = word2.length();
//        memo = new int[l1][l2];
//        for (int[] r : memo) {
//            Arrays.fill(r, -1);
//        }
//        return dp(word1, l1 - 1, word2, l2 - 1);
//    }
//
//    // dp函数定义,返回s1[i...]到s2[j...]的最少编辑距离
//    private int dp(String s1, int i, String s2, int j) {
//        if (i == -1) {
//            return j + 1;
//        }
//        if (j == -1) {
//            return i + 1;
//        }
//        if (memo[i][j] != -1) {
//            return memo[i][j];
//        }
//        if (s1.charAt(i) == s2.charAt(j)) {
//            memo[i][j] = dp(s1, i - 1, s2, j - 1);
//        } else {
//            // 插入，删除，替换
//            memo[i][j] = min(dp(s1, i, s2, j - 1) + 1, dp(s1, i - 1, s2, j) + 1, dp(s1, i - 1, s2, j - 1) + 1);
//        }
//        return memo[i][j];
//    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    //
    // DP table 版
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp定义：dp[i][j]表示s[i...]到s[j...]最小编辑距离
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
