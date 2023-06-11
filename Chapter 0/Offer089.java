public class Offer089 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[n + 2];
        // base case
        dp[n] = 0;
        dp[n + 1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 2] + nums[i], dp[i + 1]);
        }
        return dp[0];
    }
}
