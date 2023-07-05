public class Solution312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] point = new int[n + 2];
        point[0] = point[n + 1] = 1; // 最两端的气球价值为1
        System.arraycopy(nums, 0, point, 1, n);
        // dp数组定义：将开区间（i,j）内的气球全部戳破所获得的最大受益
        int[][] dp = new int[n + 2][n + 2]; // 默认初始化为0
        // base case  0<=i<=n+1,j<=i+1的范围内一个气球都没有，结果为0
        // 从下往上遍历
        int res = Integer.MIN_VALUE;
        for (int i = n; i >= 0; i--) { // 遍历各种【状态】
            for (int j = 0; j <= n + 1; j++) {
                // 逆向思维，假设最后一个戳破的气球为k，k在区间（i,j）内
                for (int k = i + 1; k <= j - 1; k++) { // 做【选择】
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + point[k] * point[i] * point[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
