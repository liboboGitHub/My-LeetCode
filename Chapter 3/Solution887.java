import java.util.Arrays;

public class Solution887 {
    //    int[][] memo;
//
//    public int superEggDrop(int k, int n) {
//        memo = new int[k + 1][n + 1];
//        for (int[] i : memo) {
//            Arrays.fill(i, -1);
//        }
//        // dp函数的定义：当k个鸡蛋时，面对n层楼（不是第n层楼，是在剩余的n层楼尝试）时，最少扔的次数
//        return dp(k, n);
//    }
//
//    private int dp(int k, int n) {
//        // base case
//        // 当剩余一个鸡蛋时，只能线性遍历
//        if (k == 1) {
//            return n;
//        }
//        // 当剩余的楼层为0时，不需要扔
//        if (n == 0) {
//            return 0;
//        }
//        if (memo[k][n] != -1) {
//            return memo[k][n];
//        }
//        int res = Integer.MAX_VALUE;
////        for (int i = 1; i <= n; i++) {
////            res = Math.min(res, Math.max(dp(k, n - i), dp(k - 1, i - 1)) + 1);
////        }
//
//        // 优化一：二分搜索
//        int hi = n;
//        int lo = 1;
//        while (hi >= lo) {
//            int mid = (hi + lo) / 2;
//            int broken = dp(k - 1, mid - 1);
//            int no_broken = dp(k, n - mid);
//            if (broken > no_broken) {
//                res = Math.min(res, broken + 1);
//                hi = mid - 1;
//            } else {
//                res = Math.min(res, no_broken + 1);
//                lo = mid + 1;
//            }
//        }
//        memo[k][n] = res;
//        return res;
//    }
    public int superEggDrop(int K, int N) {
        // 优化二：更换dp函数的定义（基本上想不到这种思路）
        // dp[k][m]=n 表示：k个鸡蛋，最多允许仍m次，所能测得的楼高最高为n
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                // 无论在哪一层扔鸡蛋，都符合转移方程
                dp[k][m] = dp[k - 1][m - 1] + dp[k][m - 1] + 1;
            }
        }
        return m;
    }
}
