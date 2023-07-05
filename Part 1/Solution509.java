public class Solution509 {
    // 带备忘录的递归解法
    public int fib(int n) {
        int[] memo = new int[n + 1]; // 默认初始化为0
        int res = help(memo, n);
        return res;
    }

    private int help(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = help(memo, n - 1) + help(memo, n - 2);
        return memo[n];
    }

    // 动态规划解法
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1]; // 用来存储重叠子问题的最优答案
        // base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
