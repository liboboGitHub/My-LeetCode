import java.util.ArrayList;
import java.util.List;

public class Offer06 {
    List<Integer> arrayList = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        reverse(head);
        int[] n = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            n[i] = arrayList.get(i);
        }
        return n;
    }

    public void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        arrayList.add(head.val);
    }
}
