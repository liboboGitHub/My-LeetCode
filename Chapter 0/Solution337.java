import java.util.HashMap;
import java.util.Map;

public class Solution337 {
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // 当前root被抢劫
        int YES = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        // 当前root不被抢
        int NO = rob(root.left) + rob(root.right);

        int res = Math.max(YES, NO);
        memo.put(root, res);
        return res;
    }
}
