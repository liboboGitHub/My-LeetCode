public class Offer090 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(temp(0, n - 1, nums), temp(1, n, nums));
    }

    private int temp(int start, int end, int[] nums) {
        int[] dp = new int[end + 2];
        // base case
        dp[end] = 0;
        dp[end + 1] = 0;
        for (int i = end - 1; i >= start; i--) {
            dp[i] = Math.max(dp[i + 2] + nums[i], dp[i + 1]);
        }
        return dp[start];
    }
}
