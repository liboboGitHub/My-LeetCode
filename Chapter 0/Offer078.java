import java.util.PriorityQueue;

class Offer078 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        // 常规操作：虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 小顶堆，每次取链表中最小的节点（堆顶），Java中默认创建的是小顶堆,大小是11
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1, node2)->(node1.val - node2.val));

        // 各个链表的头结点依次放入堆中
        for (ListNode h : lists) {
            if (h != null) {
                pq.add(h);
            }
        }

        // 生成链表，自动调整堆
        while (!pq.isEmpty()) {
            ListNode s = pq.poll();
            p.next = s;
            // 将该节点链表的剩余节点放入到堆中
            if (s.next != null) {
                pq.add(s.next);
            }
            p = p.next;
        }

        return dummy.next;
    }

    }