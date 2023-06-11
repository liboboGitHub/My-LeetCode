public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        return gap(nums) >= 0;
    }

    private int gap(int[] nums) {
        int n = nums.length;
        // dp数组定义：dp[i,j,k]表示在数组[i,j]中选择k(先手，后手）中获得的最大分数
        int[][][] dp = new int[n][n][2]; // 默认初始化为0
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = 0;
        }
        // 从下往上遍历
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 先手选择左边，面对[i + 1，j]时，它属于后手
                int left = nums[i] + dp[i + 1][j][1];
                // 先手选择右边，面对[i,j-1]时，它属于后手
                int right = nums[j] + dp[i][j - 1][1];
                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][n - 1][0] - dp[0][n - 1][1];
    }
}
