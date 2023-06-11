import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution652 {
    HashMap<String, Integer> hashMap = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        // 递归出口
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        // 后序位置
        // 当前节点构成的树，序列化
        String curSubStr = root.val + "," + left + "," + right;
        // 避免重复
        int count = hashMap.getOrDefault(curSubStr, 0);
        if (count == 1) {
            res.add(root);
        }
        hashMap.put(curSubStr, count + 1);
        return curSubStr;
    }
}

