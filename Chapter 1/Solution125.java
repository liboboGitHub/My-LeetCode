import java.util.ArrayList;
import java.util.List;

public class Solution125 {
    public boolean isPalindrome(String s) {

        String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0, right = s1.length() - 1;
        while (left < right) {
            if (s1.charAt(left) != s1.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution125 s = new Solution125();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
