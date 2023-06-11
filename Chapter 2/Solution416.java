public class Solution416 {
    public boolean canPartition(int[] nums) {
        // 转换为背包问题，是否存在一种组合，使得sum/2的背包刚好装满（巧妙）
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        // dp数组定义：dp[i][j]表示：从前i个数字中选择，是否能填满容量为j的背包
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
//        for (int i = 0; i <= sum; i++) {
//            dp[0][i] = false;
//        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选择或者不选择
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
