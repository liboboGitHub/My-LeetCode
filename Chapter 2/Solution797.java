import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution797 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>(); // LinkedList 容易操作前后节点
        traverse(0, path, graph);
        return res;
    }

    private void traverse(int curRoot, LinkedList<Integer> path, int[][] graph) {
        // 针对节点做选择
        path.addLast(curRoot);
        // 得到一条目标路径
        if (curRoot == graph.length - 1) {
            res.add(new LinkedList<>(path));
        }
        // 遍历当前节点的每个相邻节点
        for (int i : graph[curRoot]) {
            traverse(i, path, graph);
        }
        // 针对节点撤销选择，维护 path，这一点很重要；
        // 而且还可以避免因为出现环而导致无限循环的情况
        path.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        Solution797 test = new Solution797();
        test.allPathsSourceTarget(graph);
    }
}
