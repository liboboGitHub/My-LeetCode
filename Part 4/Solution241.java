import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution241 {
    HashMap<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        // 分治算法
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 是否是符号
            if (c == '-' || c == '*' || c == '+') {
                // 分
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // 子问题的结果合并
                for (int a : left) {
                    for (int b : right) {
                        if (c == '-') {
                            res.add(a - b);
                        } else if (c == '*') {
                            res.add(a * b);
                        } else {
                            res.add(a + b);
                        }
                    }
                }

            }
        }
        // base case  是一个数字
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
            memo.put(expression, res);
        }
        return res;
    }
}
