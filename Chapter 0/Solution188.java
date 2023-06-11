public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[n][k + 1][2];
        // base case (k = 0,没有产生交易)
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // base case
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j-1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        // 动态规划
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            // base case
            if (i - 1 < 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }
        return dp[prices.length - 1][0];

    }
}
