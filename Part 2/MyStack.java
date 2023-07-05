import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;
    int topElement = Integer.MIN_VALUE;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        topElement = x;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        topElement = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return topElement;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
