import java.util.LinkedHashSet;
import java.util.LinkedList;

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
