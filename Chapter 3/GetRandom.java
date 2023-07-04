import java.util.Random;

// 水塘抽样算法
public class GetRandom {
    // 返回链表中 k 个随机节点的值
    // 要在单链表中随机选择k个数，只要在第i个元素处以k/i的概率选择该元素，以1 - k/i的概率保持原有选择即可。
    public int[] getRandom(ListNode head, int k) {
        ListNode p = head;
        Random random = new Random();
        int[] res = new int[k];
        // 先将前k个元素装入
        for (int i = 0; i < k && p != null; i++) {
            res[i] = p.val;
            p = p.next;
        }
        int i = k;
        while (p != null) {
            i++;
            // 随机生成[0,j)中的一个元素（索引）
            int j = random.nextInt();
            // 如果随机生成的索引在小于k，则当前这个元素的被选中的概率是k/i。（很巧妙）
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
