import java.util.Arrays;

public class Solution931 {
    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 99999);
        }
        int res = Integer.MAX_VALUE;
        // 最后会落在最红一行的任意一列中
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;

    }

    private int dp(int[][] matrix, int i, int j) {
        // 边界判断
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        // base case
        if (i == 0) {
            return matrix[0][j];
        }
        if (memo[i][j] != 99999) {
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
