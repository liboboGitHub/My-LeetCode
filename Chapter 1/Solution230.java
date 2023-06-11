public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    int res = 0;
    int rank = 0;

    private void traverse(TreeNode root, int k) {
        // 中序遍历二叉树
        if (root == null) {
            return;
        }
        traverse(root.right, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.left, k);
    }
}
