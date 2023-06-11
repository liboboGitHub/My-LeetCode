import java.util.LinkedList;
import java.util.List;

public class Solution144 {
    List<Integer> r = new LinkedList<>();

    // 遍历的思想
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return r;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        r.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }


    // 分解的思想
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> r2 = new LinkedList<>();
        if (root == null) {
            return r2;
        }
        r2.add(root.val);
        r2.addAll(preorderTraversal2(root.left));
        r2.addAll(preorderTraversal2(root.right));

        return r2;
    }
}
