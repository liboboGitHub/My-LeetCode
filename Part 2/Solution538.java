public class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        return traverse(root);
    }
    public int sum = 0;
    private TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 逆序的中序遍历
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
        return root;
    }
}
