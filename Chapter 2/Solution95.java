import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) { // List中存的是各个BST的根节点
        List<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTree = build(low, i - 1);
            List<TreeNode> rightTree = build(i + 1, high);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    /***************构造BST，i作为当前BST的根节点*********************/
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                    /************************************************************/
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
       Solution95 test =  new Solution95();
       test.generateTrees(3);
    }
}
