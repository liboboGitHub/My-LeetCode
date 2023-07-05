public class Solution236 {
    /**
     * 如果在一棵二叉树节点的左右子树中找到了p和q，那么这个节点就是lowestCommonAncestor
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode root, int val1, int val2) {
        // base case
        if (root == null) {
            return null;
        }
        // 前序位置：如果当前节点是p或者q的值，则直接返回
        if (root.val == val1 || root.val == val2) {
            return root;
        }
        // 递归遍历左右子树
        TreeNode leftTree = find(root.left, val1, val2);
        TreeNode rightTree = find(root.right, val1, val2);
        // 后序位置：找到了lowestCommonAncestor节点
        if (leftTree != null && rightTree != null) {
            return root;
        }
        // root 不是目标节点，再去看看哪边的子树找到了，如果左右子树都没有找到，返回的是null
        return leftTree != null ? leftTree : rightTree;
    }
}
