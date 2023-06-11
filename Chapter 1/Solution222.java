public class Solution222 {
    public int countNodes(TreeNode root) {
        TreeNode left = root, right = root;
        int lefthigh = 0, rightHigh = 0;
        // 计算左右子树的高度
        while (left != null) {
            lefthigh++;
            left = left.left;
        }
        while (right != null) {
            rightHigh++;
            right = right.right;
        }
        if (lefthigh == rightHigh) {
            return (int) Math.pow(2, lefthigh) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
