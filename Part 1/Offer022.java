class Offer022 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 如果链表长为10，要求删除倒数第10个节点，需要寻找倒数第11个节点，会出现空指针异常，防止出现这种情况，使用虚拟的头结点。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第n个节点，找到待删除节点的前一个节点
        ListNode h = getKthFromEnd(dummy, n + 1);
        h.next = h.next.next;
        return dummy.next;
    
    }
    
    public ListNode getKthFromEnd(ListNode head, int k) {
    
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}