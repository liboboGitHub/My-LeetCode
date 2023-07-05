import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> lager;
    PriorityQueue<Integer> small;

    public MedianFinder() {
        // 小顶堆
        lager = new PriorityQueue<>(128);
        // 大顶堆
        small = new PriorityQueue<>(128,(a, b) -> (b - a));

    }

    // ①small和large的元素之差不超过1 ②large中的元素整体大于等于small
    public void addNum(int num) {
        if (small.size() >= lager.size()) {
            // 特殊技巧
            small.offer(num);
            lager.offer(small.poll());
        } else {
            lager.offer(num);
            small.offer(lager.poll());
        }
    }

    public double findMedian() {
        if (lager.size() > small.size()) {
            return lager.peek();
        } else if (lager.size() < small.size()) {
            return small.peek();
        } else {
            return (lager.peek() + small.peek()) / 2.0;
        }
    }
}

