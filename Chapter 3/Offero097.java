import java.util.Arrays;

public class Offero097 {
    int[][] memo;

    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return dp(s, 0, t, 0);
    }

    // 定义：s[i..] 的子序列中 t[j..] 出现的次数为 dp(s, i, t, j)
    private int dp(String s, int i, String t, int j) {
        // base case1，t 匹配完成
        if (j == t.length()) {
            return 1;
        }
        // base case2,特殊情况,较难想到
        if (s.length() - i < t.length() - j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;

//        for (int k = i; k < s.length(); k++) {
//            if (s.charAt(k) == t.charAt(j)) {
//                res += dp(s, k + 1, t, j + 1);
//            }
//        }
        /**
         * 站在s的角度上
         * 原问题是计算 s[0..] 的所有子序列中 t[0..] 出现的次数，可以先看看 s[0] 是否能匹配 t[0]，
         * 如果不匹配，那没得说，原问题就可以转化为计算 s[1..] 的所有子序列中 t[0..] 出现的次数；
         * 但如果 s[0] 可以匹配 t[0]，那么又有两种情况，这两种情况是累加的关系：
         * 1、让 s[0] 匹配 t[0]，那么原问题转化为在 s[1..] 的所有子序列中计算 t[1..] 出现的次数。
         * 2、不让 s[0] 匹配 t[0]，那么原问题转化为在 s[1..] 的所有子序列中计算 t[0..] 出现的次数。（为什么？为了让后面的元素有匹配机会）
         */
        if (s.charAt(i) == t.charAt(j)) {
            res += dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
        } else {
            res += dp(s, i + 1, t, j);
        }

        memo[i][j] = res;
        return memo[i][j];
    }
}
