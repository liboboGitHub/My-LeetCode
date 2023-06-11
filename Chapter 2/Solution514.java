import java.util.ArrayList;
import java.util.HashMap;

public class Solution514 {

    // ring中字符的映射
    HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<>();
    // 备忘录
    int[][] memo;

    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        memo = new int[m][n]; // 默认初始化为0
        // ring中字符的映射
        for (int i = 0; i < ring.length(); i++) {
            if (hashMap.containsKey(ring.charAt(i))) {
                hashMap.get(ring.charAt(i)).add(i);
            } else {
                hashMap.put(ring.charAt(i), new ArrayList<>());
                hashMap.get(ring.charAt(i)).add(i);
            }
        }
        // dp函数的定义:dp(ring,i,key,j)表示当前字符是ring[i]转到字符key[j]所需要的最小次数
        return dp(ring, 0, key, 0);
    }

    private int dp(String ring, int i, String key, int j) {
        // base case:能够正确的匹配一次
        if (j == key.length()) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int n = ring.length();
        int res = Integer.MAX_VALUE;

        for (int index : hashMap.get(key.charAt(j))) {
            // 转动的次数
            int Gap = Math.abs(index - i);
            // 顺时针或者逆时针
            Gap = Math.min(Gap, n - Gap);
            int subProblem = dp(ring, index, key, j + 1);
            res = Math.min(res, subProblem + Gap + 1);
        }
        memo[i][j] = res;
        return res;
    }
}
