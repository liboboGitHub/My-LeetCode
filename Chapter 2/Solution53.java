public class Solution53 {
    // 1.滑动窗口
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int windowSum = 0; // 关键
        int resSum = Integer.MIN_VALUE; // 关键
        while (right < nums.length) {
            windowSum += nums[right];
            right++;
            // 注意：当前窗口内的和并不一定是最大的
            if (windowSum > resSum) {
                resSum = windowSum;
            }

            while (windowSum < 0) {  //贪心思想
                windowSum -= nums[left];
                left++;
            }
        }
        return resSum;
    }


    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        solution53.maxSubArray(test);
    }



    // 2.动态规划
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        // dp 数组定义：以nums[i]为[结尾]的子数组的最大和为dp[i]
//        // base case
//        dp[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//        }
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }
    // 3. 前缀和
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[] preSum = new int[n + 1];
//        preSum[0] = 0;
//        // 构建前缀和数组
//        for (int i = 1; i <= n; i++) {
//            preSum[i] = preSum[i - 1] + nums[i - 1];
//        }
//        int res = Integer.MIN_VALUE;
//        int minPreSum = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            minPreSum = Math.min(minPreSum, preSum[i]);
//            res = Math.max(res, preSum[i + 1] - minPreSum);
//        }
//        return res;
//
//    }
}
