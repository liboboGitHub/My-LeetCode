import java.util.Stack;

public class Offer038 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // 存索引
        Stack<Integer> s = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                res[i] = s.peek() - i;
            } else {
                res[i] = 0;
            }
            s.push(i);
        }
        return res;
    }
}
