import java.util.Arrays;

public class Solution300 {
    // 经典问题：最长递增子序列
    public int lengthOfLIS(int[] nums) {
        //dp 数组定义：dp[i]是以nums[i]为结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case
        Arrays.fill(dp, 1);
        // 数学归纳法
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 状态转移方程
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
