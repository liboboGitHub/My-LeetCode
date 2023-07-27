import java.util.Stack;

public class Solution1541 {
    public int minInsertions(String s) {
        int res = 0, need = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {  // 遇到左括号
                need += 2; // 一个左括号需要两个右括号来匹配
                // 如果右括号的需求数量是奇数，需要插入一个右括号
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            } else {  // 遇到右括号
                // 对右括号需求的数量减一
                need--;
                if (need == -1) {//需要一个左括号
                    res++;
                    need += 2;
                }
            }
        }
        return res + need;
    }
}
