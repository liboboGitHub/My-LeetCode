import java.util.Arrays;
import java.util.Comparator;

public class Solution354 {
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

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按照宽度升序，如果宽度一样，按照高度降序排序（题目要求相同高、宽也不能嵌套）
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

}
