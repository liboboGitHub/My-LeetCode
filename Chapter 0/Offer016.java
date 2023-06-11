import java.util.HashMap;

public class Offer016 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            window.put(r, window.getOrDefault(r, 0) + 1);

            while (window.get(r) > 1) {
                char l = s.charAt(left);
                left++;
                window.put(l, window.get(l) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
