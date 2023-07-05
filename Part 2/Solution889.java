import sun.font.TextRecord;

import java.util.HashMap;

public class Solution889 {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            hashMap.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        // 递归出口
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int curRootValue = preorder[preStart];

        int leftRootValue = preorder[preStart + 1]; // 也可以充当右子树节点
        int index = hashMap.get(leftRootValue); // 最关键的一步，找到 postOrder 中左右子树的分界点

        int leftSize = index - postStart + 1; // 当前根节点下的左子树元素的个数
        TreeNode curRoot = new TreeNode(curRootValue);

        curRoot.left = build(preorder, preStart + 1, preStart + leftSize, preorder, postStart, index);
        curRoot.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);
        return curRoot;

    }
}
