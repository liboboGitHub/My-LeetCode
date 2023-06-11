public class Solution651 {
    public int maxA(int N) {
        // dp定义，dp[i]表示i次操作屏幕上最多显示的字母A
        int[] dp = new int[N + 1];
        dp[0] = 0;  // base case
        for (int i = 1; i <= N; i++) {
            // 选择1：按A
            dp[i] = dp[i - 1] + 1;

            // 选择2：CA,CC,CV,j代表CV的起点
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }
}
