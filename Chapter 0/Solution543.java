public class Solution543 {
    int maxDiaMeter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depthMax(root);
        return maxDiaMeter;
    }

    private int depthMax(TreeNode root) {
        // 当前节点的最大深度
        if (root == null) {
            return 0;
        }
        int leftDepth = depthMax(root.left);
        int rigtDeoth = depthMax(root.right);

        // 此时已经知道了当前节点的左右子树的深度，直接在这里计算直径
        int curDiaMeter = leftDepth + rigtDeoth;
        maxDiaMeter = Math.max(curDiaMeter, maxDiaMeter);

        return Math.max(leftDepth, rigtDeoth) + 1;
    }
}
