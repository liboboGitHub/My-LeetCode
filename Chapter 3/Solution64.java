import javax.swing.plaf.metal.MetalTheme;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp函数定义：dp[i][j]表示从(0,0)到(i,j)的最小数字和
        int[][] dp = new int[m][n];
        //  base case
        dp[0][0] = grid[0][0];
        // 左边界
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 上边界
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 遍历所有状态，每个位置就是一种状态
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
