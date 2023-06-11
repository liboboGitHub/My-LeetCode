import java.util.HashSet;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }
        int n = needle.length();
        for (int i = 0; i + n <= haystack.length(); i++) {
            String cur = haystack.substring(i, i + n);
            if (cur.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
