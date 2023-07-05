public class Solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;

        traverse(node1.left, node1.right);
        traverse(node2.left, node1.right);
        traverse(node1.right, node2.left);
    }
}
