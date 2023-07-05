public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 val2 >= val1
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }

    /**
     * 假设val1 < val2，那么val1 <= root.val <= val2则说明当前节点就是LCA；
     * 若root.val比val1还小，则需要去值更大的右子树寻找LCA；
     * 若root.val比val2还大，则需要去值更小的左子树寻找LCA。
     */
    private TreeNode find(TreeNode root, int val1, int val2) {
        // base case
        if (root == null) {
            return null;
        }
        if (root.val > val2) {
            return find(root.left, val1, val2);
        }
        if (root.val < val1) {
            return find(root.right, val1, val2);
        }
        // val1 < root.val < val2
        return root;
    }
}
