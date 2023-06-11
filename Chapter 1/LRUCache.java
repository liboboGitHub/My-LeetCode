import java.util.HashMap;

public class LRUCache {
    private class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    private class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在链表尾部添加节点 x，时间 O(1)
        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中第一个节点，并返回该节点，时间 O(1)
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }

    }

    private HashMap<Integer, Node> hashMap;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        hashMap = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     * 将某个 key 提升为最近使用的
     */
    private void makeRencently(int key) {
        Node x = hashMap.get(key);
        // 删除这个节点后放到队尾
        cache.remove(x);
        cache.addLast(x);
    }

    /**
     * 添加最近使用的元素
     */
    private void addRencetly(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        hashMap.put(key, x);
    }

    /**
     * 删除某一个 key
     */
    private void deleteKey(int key) {
        Node x = hashMap.get(key);
        cache.remove(x);
        hashMap.remove(key);
    }

    /**
     * 删除最久未使用的
     */
    private void removeLeastRecently() {
        Node deleteNode = cache.removeFirst();
        int delKey = deleteNode.key;
        hashMap.remove(delKey);
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        // 将数据升级为最近使用的
        makeRencently(key);
        return hashMap.get(key).val;
    }

    public void put(int key, int val) {
        if (hashMap.containsKey(key)) {
            // 删除旧的数据
            deleteKey(key);
            addRencetly(key, val);
            return;
        }
        if (cap == cache.size()) {
            // 移除最久未使用的
            removeLeastRecently();

        }
        addRencetly(key, val);

    }


}
