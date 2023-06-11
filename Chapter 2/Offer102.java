public class Offer102 {
    // 转换成背包问题（子集划分问题）
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // 不合法情况
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {  // 第一个判断条件很巧妙
            return 0;
        }
        int tar = (sum + target) / 2;  // 推导
        return sumsets(nums, tar);
    }

    private int sumsets(int[] nums, int tar) {
        // dp 数组的定义：dp[i][j] 表示在前i个数字里选择，凑满j的组合数为dp[i][j]
        int n = nums.length;
        int[][] dp = new int[n + 1][tar + 1];
        // base case
        dp[0][0] = 1; // 当容量为0时，什么都不放，就是一种组合。
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][tar];
    }

}
