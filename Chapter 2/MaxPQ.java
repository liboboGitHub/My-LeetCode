/**
 * 二叉堆实现优先级队列
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
    // 存储元素的数组
    private Key[] pq;
    // 当前 Priority Queue 中的元素个数
    private int size = 0;

    public MaxPQ(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    //当前队列的最大元素
    public Key max() {
        return pq[1];
    }

    // 插入元素（插入到最后的位置，然后让其上浮到合适的位置）
    public void insert(Key e) {
        size++;
        pq[size] = e;
        swim(size);
    }

    // 删除并返回当前队列中最大元素
    public Key delMax() {
        // 堆顶就是最大元素
        Key max = pq[1];
        swap(1, size);
        pq[size] = null;
        size--;
        sink(1);
        return max;
    }

    //上浮第 x 个元素，以维护最大堆性质
    private void swim(int x) {
        while (x > 1 && less(parent(x), x)) {
            swap(x, parent(x));
            x = parent(x);
        }
    }

    //下沉第 x 个元素，以维护最大堆性质
    private void sink(int x) {
        while (left(x) <= size) {
            int max = left(x);
            if (right(x) <= size && less(max, right(x))) {
                max = right(x);
            }
            if (less(max, x)) {
                break;
            }
            swap(x, max);
            x = max;
        }
    }

    // 交换数组的两个元素
    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    // pq[i] 是否比 pq[j] 小？
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public int parent(int root) {
        return root / 2;
    }

    public int left(int root) {
        return root * 2;
    }

    public int right(int root) {
        return root * 2 + 1;
    }
}
