public class Solution583 {
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

    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);
        return word1.length() - lcs + word2.length() - lcs;
    }
}
