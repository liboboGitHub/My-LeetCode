public class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) { // 找到了删除的节点
            if (root.left == null && root.right == null) // 待删除节点左右子树都为空
                return null;
            else if (root.left == null) // 待删除节点左子树为空
                return root.right;
            else if (root.right == null) { // 待删除节点右子树为空
                return root.left;
            } else {
                // 待删除节点左右子树都不为空
                TreeNode rightMinNode = findMinNode(root.right);
                root.right = deleteNode(root.right, rightMinNode.val);
                /****************交换树中的两个节点******************/
                rightMinNode.left = root.left;
                rightMinNode.right = root.right;
                root = rightMinNode;
                /**********************************/
            }
        } else if (root.val > key) {
            // 返回的是什么？删除节点后新树的根节点（明确定义才能理解递归调用）
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    // 右子树的最左节点就是最小节点
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
