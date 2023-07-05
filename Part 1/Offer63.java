public class Offer63 {
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
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

        }
        return dp[prices.length - 1][0];

    }
}
