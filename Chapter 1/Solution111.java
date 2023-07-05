import java.util.LinkedList;
import java.util.Queue;

public class Solution111 {
    public int minDepth(TreeNode root) {
        // 使用BFS框架
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root); // 根节点入队
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll(); // 队头元素出队列
                // 判断是否符合条件，到达叶子节点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
