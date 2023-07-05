import java.util.HashMap;

public class Solution76 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (need.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                if (window.get(s.charAt(right)).equals(need.get(s.charAt(right)))) {
                    valid++;
                }
            }
            right++;
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                if (need.containsKey(s.charAt(left))) {
                    if (need.get(s.charAt(left)).equals(window.get(s.charAt(left)))) {
                        valid--;
                    }
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1); // 注意位置
                }
                left++;
            }
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, start + len);
        }
    }
}
