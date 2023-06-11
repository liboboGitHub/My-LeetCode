public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        // 分解问题的思路
        if (root == null) {
            return null;
        }
        // 翻转左子树
        TreeNode left = invertTree(root.left);
        // 翻转右子树
        TreeNode right = invertTree(root.right);
        // 交换左右子树
        root.left = right;
        root.right = left;

        return root;
    }


}
