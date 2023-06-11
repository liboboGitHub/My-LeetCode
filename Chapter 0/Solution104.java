public class Solution104 {

    // 最大深度
    public int res = 0;
    // 当前节点的深度
    public int curDepth = 0;

    // 求二叉树的最大深度，思路一：遍历二叉树
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树的遍历（递归遍历）
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        curDepth++;
        // 如果是叶子节点就更新
        if (root.left == null && root.right == null) {
            res = Math.max(res, curDepth);
        }
        // 遍历左右子树
        traverse(root.left);
        traverse(root.right);
        // 维护当前的节点深度
        curDepth--;
    }

    // 求二叉树的最大深度，思路二：分解问题
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth2(root.left);
        int r = maxDepth2(root.right);
        int res = Math.max(l, r);
        return res + 1;
    }
}
