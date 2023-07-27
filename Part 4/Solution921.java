public class Solution921 {
    public int minAddToMakeValid(String s) {
        int needRight = 0, needLeft = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                needRight++;
            } else {
                needRight--;
                if (needRight == -1) {
                    // 需要左括号
                    needRight++;
                    needLeft++;
                }
            }
        }
        return needRight + needLeft;
    }
}
