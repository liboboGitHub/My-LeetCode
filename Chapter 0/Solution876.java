public class Solution876 {
    public ListNode middleNode(ListNode head) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

//    public static void main(String[] args) {
//        ListNode[] L = new ListNode[5];
//        for (int i = 0; i < L.length; i++) {
//            L[i] = new ListNode(i);
//        }
//        for (int j = 0; j < L.length; j++) {
//            if (j == 4) {
//                L[j].next = null;
//            } else {
//                L[j].next = L[j + 1];
//            }
//        }
//        Solution876 s = new Solution876();
//        System.out.println(s.middleNode(L[0]).val);
//    }
}
