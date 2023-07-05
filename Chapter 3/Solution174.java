import java.util.Arrays;

public class Solution174 {
    // 难点：分析dp函数的定义，逆向思维
//    int[][] memo;
//
//    public int calculateMinimumHP(int[][] dungeon) {
//        int m = dungeon.length;
//        int n = dungeon[0].length;
//        memo = new int[m][n];
//        for (int i = 0; i < dungeon.length; i++) {
//            Arrays.fill(memo[i], -1);
//        }
//        // dp函数定义：从dungeon[i][j]走到终点所需要的最小初始生命值
//        return dp(dungeon, 0, 0);
//    }
//
//
//    private int dp(int[][] dungeon, int i, int j) {
//        int m = dungeon.length;
//        int n = dungeon[0].length;
//        // base case
//        if (i == m - 1 && j == n - 1) {
//            if (dungeon[i][j] < 0) {
//                return -dungeon[i][j] + 1;
//            } else {
//                return 1;
//            }
//        }
//        // 超过边界
//        if (i >= m || j >= n) {
//            return Integer.MAX_VALUE;
//        }
//        if (memo[i][j] != -1) {
//            return memo[i][j];
//        }
//        int res = Math.min(dp(dungeon, i + 1, j), dp(dungeon, i, j + 1)) - dungeon[i][j];
//        if (res < 0) {
//            memo[i][j] = 1;
//        } else {
//            memo[i][j] = res;
//        }
//        return memo[i][j];
//    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // dp函数定义：dp[i][j]表示从dungeon[i][j]走到终点所需要的最小初始生命值
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) {
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (i == m - 1 && j == n - 1) {
                    if (dungeon[i][j] > 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = -dungeon[i][j] + 1;
                    }
                    continue;
                }
                int res = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (res <= 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = res;
                }
            }
        }
        return dp[0][0];
    }

}
