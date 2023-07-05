public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            // base case
            if (i - 1 == -1) {
                dp[0][0] = 0;
                dp[0][1] = -prices[i] - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);

        }
        return dp[prices.length - 1][0];
    }
}
