public class Backpack01 {
    // 经典0-1背包问题
    public int knapsack(int N, int W, int[] wt, int[] Val) {
        // （最重要）dp数组定义：dp[i][j]表示只对前i件物品（不一定每件都选）进行选择，当背包的容量最大为j时的最大总价值
        int[][] dp = new int[N + 1][W + 1];
        // base case:  dp[0][j...]没有物品的时候价值为0；dp[i...][0]背包容量为0的时候价值为0
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 状态，选择。选择第i件物品，在剩余的容量中选择前i-1件物品中的最大价值；不选择第i件物品，继承前面的最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + Val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }
}
