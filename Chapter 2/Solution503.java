
import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        // 环形操作技巧，取余操作，两倍的原数组长度
        for (int i = n * 2 - 1; i >= 0; i--) {
            // 当前元素后面小于等于它的值出栈，这些值没用
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                res[i % n] = s.peek();
            } else {
                res[i % n] = -1;
            }
            s.push(nums[i % n]);
        }
        return res;
    }
}
