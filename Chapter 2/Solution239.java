import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution239 {
    public class MonotonicQueue {
        // 单调队列（很巧妙）
        // 维护其中的元素自尾部到头部单调递增
        // 队尾添加元素n
        private LinkedList<Integer> maxQ = new LinkedList<>();

        public void push(int n) {
            while (!maxQ.isEmpty() && maxQ.getLast() < n) {
                maxQ.pollLast();
            }
            maxQ.addLast(n);
        }

        public int max() {
            return maxQ.getFirst();
        }

        // 队头元素是n，删除它
        public void pop(int n) {
            if (n == maxQ.getFirst()) {
                maxQ.pollFirst();
            }
        }

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                list.add(window.max());
                window.pop(nums[i - (k - 1)]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
