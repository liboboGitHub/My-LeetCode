public class Solution1312 {
    public int minInsertions(String s) {

        // 为什么？ 先求字符串的最长子序列，那么该最长子序列+多余的字符就可以变成原串，
        // 然后再加上上次多余的字符就又可以变成回文串，因为回文串是对称的
        return s.length() - longestPalindromeSubseq(s);

    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp数组定义：dp[i][j] 表示字符串s[i...j]中的最长回文子序列
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;  // 该字符本身
        }
        // 遍历：i<=j合理，i>j非法；根据状态转换，只能斜着遍历或者反着遍历（自下向上）
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
