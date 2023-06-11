public class Solution86 {

    /*
     * 思路：将一个链表分解为两个链表，其中一个链表的val都大于等于指定的值，另一个链表的val都小于指定的值；
     * 关键：虚拟的头结点，利用双指针进行大小比对
     */
    public ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(-1), p1 = new ListNode();
        dummy1 = p1;

        ListNode dummy2 = new ListNode(-1), p2 = new ListNode();
        dummy2 = p2;

        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }

            head = head.next;
        }
        // p1,p2连接
        p2.next = null;
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
