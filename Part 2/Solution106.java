import java.util.HashMap;

public class Solution106 {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postorderStart, int postorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        // 递归函数的出口
        if (postorderStart > postorderEnd) {
            return null;
        }
        int curRootValue = postorder[postorderEnd];
        int index = hashMap.get(curRootValue);
        int leftSize = index - inorderStart;
        // 构建节点
        TreeNode curroot = new TreeNode(curRootValue);
        curroot.left = build(postorder, postorderStart, postorderStart + leftSize - 1, inorder, inorderStart, index - 1);
        curroot.right = build(postorder, postorderStart + leftSize, postorderEnd - 1, inorder, index + 1, inorderEnd);
        return curroot;
    }
}
