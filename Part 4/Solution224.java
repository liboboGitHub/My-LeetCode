import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution224 {
    public int calculate(String s) {

        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        return helper(queue);

    }

    private int helper(Queue<Character> s) {
        // 辅助栈
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        while (!s.isEmpty()) {
            char c = s.poll();
            if (Character.isDigit(c)) {
                // 如果是非一位数，需要循环实现数字的整合
                num = num * 10 + (c - '0');
            }

            // 遇到 ( 开始递归，遇到 ) 结束递归：
            if (c == '(') {
                num = helper(s);
            }
            // 下面的处理很重要，可以处理最后一位数字，同时忽略空格
            if ((!Character.isDigit(c) && c != ' ') || s.isEmpty()) {
                // 不是数字
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                // 更改符号
                sign = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }
        // 将栈中的所有数字相加
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }
}
