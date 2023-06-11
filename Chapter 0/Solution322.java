import java.util.Arrays;

public class Solution322 {
    //    int[] memo;
//
//    //
//    （带备忘录）
//    public int coinChange(int[] coins, int amount) {
//        memo = new int[amount + 1];
//        // 数组的填充方法
//        Arrays.fill(memo, -888);
//        return dp(coins, amount);
//    }
//
//    // 返回最少需要的硬币数目
//    private int dp(int[] coins, int amount) {
//        // base case
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//        if (memo[amount] != -888) {
//            return memo[amount];
//        }
//        int res = Integer.MAX_VALUE; // 硬币数目
//        for (int coin : coins) {
//            // 子问题，总数-当前硬币的面值后需要的最少硬币数
//            int subProblem = dp(coins, amount - coin);
//            if (subProblem == -1) {
//                continue;
//            }
//            res = Math.min(res, subProblem + 1);
//        }
//
//        if (res == Integer.MAX_VALUE) {
//            memo[amount] = -1;
//            return memo[amount];
//        } else {
//            memo[amount] = res;
//            return memo[amount];
//        }
//    }


    // 自底向上,dp table
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1 );

        // base case
        dp[0] = 0;
        // 遍历每一种amount（状态），1.重叠子问题
        for (int i = 0; i < dp.length; i++) {
            // 在每一种选择中选择最优解，2.最优子结构
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                // 3.状态转移方程
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }


    public static void main(String[] args) {
        int[] r = {1, 2, 5};
        new Solution322_2().coinChange(r, 11);
    }
}
