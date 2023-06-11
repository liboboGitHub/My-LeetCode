import java.util.*;

public class Solution139 {

// 动态规划解法一
//    HashSet<String> wordDict;
//
//    // memo[i] = -1，未计算；memo[i] = 0，拼不成，memo[i] = 1，可以
//    int[] memo;
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//        this.wordDict = new HashSet<>(wordDict);
//        this.memo = new int[s.length()];
//        Arrays.fill(memo, -1);
//        return backtrack(s, 0);
//    }
//
//    private boolean backtrack(String s, int i) {
//        // base case
//        if (i == s.length()) {
//            return true;
//        }
//        if (memo[i] != -1) {
//            if (memo[i] == 0) {
//                return false;
//            }
//            return true;
//        }
//        for (int len = 1; i + len <= s.length(); len++) {
//            String prefix = s.substring(i, i + len);
//            if (wordDict.contains(prefix)) {
//                // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出（子问题推出原问题）
//                boolean subProblem = backtrack(s, i + len);
//                if (subProblem) {
//                    memo[i] = 1;
//                    return true;
//                }
//            }
//        }
//        memo[i] = 0;
//        return false;
//    }

    // 动态规划解法二
    HashSet<String> wordDict;
    boolean[] res;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        res = new boolean[s.length() + 1];
        // base case
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
