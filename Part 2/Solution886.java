import java.util.LinkedList;
import java.util.List;

public class Solution886 {

    private boolean res = true;   // 记录是否是二分图
    private boolean[] color;       // 节点的颜色
    private boolean[] isVisited;   // 当前节点是否被访问过了

    // 本题属于二分图判定问题
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n + 1];
        isVisited = new boolean[n + 1];
        // 构建双向图（无向图），why? 构建的图中节点之间都是相互disliks,符合要求
        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int i = 1; i <= n; i++) {
            traverse(graph, i);
        }
        return res;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        // 初始化领接表
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int j = 0; j < dislikes.length; j++) {
            int l = dislikes[j][0];
            int r = dislikes[j][1];
            graph[l].add(r);
            graph[r].add(l);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int v) {
        if (!res) {
            return;
        }
        // 递归出口
        if (graph[v] == null) {
            return;
        }
        isVisited[v] = true;
        for (int w : graph[v]) {
            if (!isVisited[w]) {
                isVisited[w] = true;
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[v] == color[w]) {
                    res = false;
                    return;
                }
            }
        }
    }
}

