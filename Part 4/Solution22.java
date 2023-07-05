import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    //基本事实：
    // 1、一个「合法」括号组合的左括号数量一定等于右括号数量。
    // 2、对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0...i] 中左括号的数量都大于或等于右括号的数量。
    // 思路：回溯穷举所有的括号组合，然后筛选出合法的
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder trace = new StringBuilder();
        backtrack(n, n, trace, res); // n,n 表示剩余可以用的左右括号的数量
        return res;
    }

    private void backtrack(int left, int right, StringBuilder trace, List<String> res) {
        // 根据筛选条件1
        if (right < left) {
            return;
        }
        if (right < 0 || left < 0) {
            return;
        }
        // 根据筛选条件2
        if (left == 0 && right == 0) {
            res.add(trace.toString());
            return;
        }
        // 添加一个左括号
        trace.append('(');
        backtrack(left - 1, right, trace, res);
        trace.deleteCharAt(trace.length() - 1);
        // 添加一个右括号
        trace.append(')');
        backtrack(left, right - 1, trace, res);
        trace.deleteCharAt(trace.length() - 1);
    }
}
