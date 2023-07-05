import java.util.LinkedList;


public class Solution297 {
    // Encodes a tree to a single string.


    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        traverse(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void traverse(TreeNode root, StringBuilder stringBuilder) {
        // 递归出口
        if (root == null) {
            stringBuilder.append("#").append(",");
            return;
        }
        // 前序位置
        stringBuilder.append(root.val).append(",");
        traverse(root.left, stringBuilder);
        traverse(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> linkedList = new LinkedList<>(); // 这里选择LinkedList 很合理，后面需要用这个集合的使用特点
        for (String s : data.split(",")) {
            linkedList.addLast(s);
        }

        return deser(linkedList);
    }

    private TreeNode deser(LinkedList<String> linkedList) {
        if (linkedList.isEmpty()) {
            return null;
        }

        // 前序位置，LinkedList 中第一个位置的节点就是当前的根节点
        String curRoot = linkedList.removeFirst();
        // 递归出口
        if (curRoot.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(curRoot));
        treeNode.left = deser(linkedList);
        treeNode.right = deser(linkedList);
        return treeNode;
    }
}
