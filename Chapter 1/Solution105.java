import java.util.HashMap;

public class Solution105 {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inorderStart, int inorderEnd) {
        // 递归函数的出口
        if (preStart > preEnd) {
            return null;
        }
        int curRootValue = preorder[preStart];
        int index = hashMap.get(curRootValue);
        int leftSize = index - inorderStart;
        // 构建节点
        TreeNode curroot = new TreeNode(curRootValue);
        curroot.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inorderStart, index - 1);
        curroot.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inorderEnd);
        return curroot;
    }

}
