import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution111_2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) { // 整体上从上往下
            int sz = queue.size();
            for (int i = 0; i < sz; i++) { // 遍历当前层
                TreeNode curNode = queue.poll();
                // 出队的当前节点是否是终点
                if (curNode.left == null && curNode.right == null) {
                    return depth;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
