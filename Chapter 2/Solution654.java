public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 递归构造树
        return generation(nums, 0, nums.length - 1);
    }

    private TreeNode generation(int[] nums, int left, int right) {
        // 递归函数出口
        if (left > right) {
            return null;
        }

        int maxValue = Integer.MIN_VALUE; // 记录最大值
        int index = -1; // 记录最大值的索引
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        // 前序位置，构造根节点
        TreeNode root = new TreeNode(maxValue);

        // 构造左子树
        root.left = generation(nums, left, index - 1);
        root.right = generation(nums, index + 1, right);
        return root;
    }
}
