public class Solution14 {
    public void flatten(TreeNode root) {

        // flatten 定义：对于每一个节点，
        // 先利用 flatten(x.left) 和 flatten(x.right) 将 x 的左右子树拉平。
        // 将 x 的右子树接到左子树下方，然后将整个左子树作为右子树
        // base case
        if (root == null) {
            return;
        }
        // 左右子树展平
        flatten(root.left);
        flatten(root.right);

        // 备份左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
