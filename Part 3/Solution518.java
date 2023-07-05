public class Solution518 {

    // 完全背包问题
    public int change(int amount, int[] coins) {
        // 明确状态和选择。状态（背包的容量、可选择的商品），选择（放入背包、不放入背包）
        // dp 数组的定义：dp[i][j]表示在前i个物品中选择时，能够凑出背包容量为j的物品组合数量
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case 1:金额为0时，无论在前哪几个硬币中选择，都不做选择就是一种凑法。
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        // base case 2:可选择的硬币为0时，只要金额大于0，肯定凑不够。
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }
        // 遍历每种状态
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) { // 选择第i种硬币时，超出金额了，选择上一个可以凑好的金额的状态（组合数）
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选择第i种硬币时凑出金额的组合数+不选择第i种硬币时凑出金额的组合数
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
