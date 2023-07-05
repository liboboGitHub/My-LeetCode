import java.util.HashMap;

public class Solution576 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> need = new HashMap<>(26);
        HashMap<Character, Integer> window = new HashMap<>(26);
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (need.get(r).equals(window.get(r))) {
                    valid++;
                }
            }
            // 窗口大小是固定的，也即是：右滑一下左滑一下
            while (right - left == s1.length()) {
                if (need.size() == valid) {
                    return true;
                }
                char l = s2.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (need.get(l).equals(window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);  // 注意位置
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "acbd";
        Solution576 solution576 = new Solution576();
        solution576.checkInclusion(s1, s2);
    }
}
