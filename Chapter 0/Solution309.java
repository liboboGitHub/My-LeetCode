public class Solution309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        // 0：不持有股票；1：持有股票（两种状态）
        for (int i = 0; i < prices.length; i++) {
            // base case1
            if (i - 1 == -1) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            // base case2
            if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
                continue;
            }
            // 状态转移方程
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);

        }
        return dp[prices.length - 1][0];
    }
}
