public class Solution5 {
    public String longestPalindrome(String s) {
        String rt = "";

        for (int i = 0; i < s.length(); i++) {
            // i == j 回文串是奇数
            String s1 = longest(i, i, s);
            // i != j 回文串是偶数
            String s2 = longest(i, i + 1, s);
            if (s1.length() > rt.length()) {
                rt = s1;
            }
            if (s2.length() > rt.length()) {
                rt = s2;
            }
        }
        return rt;

    }


    // 寻找以s[i]为中心的最长回文串
    public String longest(int left, int right, String s) {
        // 中心往两边扩散
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
