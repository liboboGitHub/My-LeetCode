import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    // 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> curList = new LinkedList<>();
            for (int i = 0; i < curSize; i++) {
                // 出队
                TreeNode curPoll = queue.poll();
                curList.add(curPoll.val);
                if (curPoll.left != null) {
                    queue.offer(curPoll.left);
                }
                if (curPoll.right != null) {
                    queue.offer(curPoll.right);
                }
            }
            res.add(curList);
        }
        return res;
    }
}
