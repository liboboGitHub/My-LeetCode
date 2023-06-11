import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution322_2 {
    // 自底向上
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]); // 状态转移方程
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        Solution322_2 solution322_2 = new Solution322_2();
        int[] s = {1, 2, 5};
        solution322_2.coinChange(s, 11);
    }
}
