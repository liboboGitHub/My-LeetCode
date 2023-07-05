import java.util.Stack;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();   // 保证元素的相对顺序
        int[] count = new int[256];  // 存放每一个字符出现的个数
        boolean[] inStack = new boolean[256];  // 记录栈中的元素
        for (char i : s.toCharArray()) {
            count[i]++;
        }
        for (char cur : s.toCharArray()) {
            count[cur]--;
            if (inStack[cur]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > cur) {
                // 如果当前的栈顶元素后续不再出现，这里不应该出栈，一旦出栈后续将丢失部分元素
                if (count[stack.peek()] == 0) {
                    break;
                } else {
                    inStack[stack.pop()] = false;
                }
            }
            stack.push(cur);
            inStack[cur] = true;
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution316 solution316 = new Solution316();
        solution316.removeDuplicateLetters("bcabc");
    }
}
