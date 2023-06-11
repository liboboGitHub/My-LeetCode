public class Offer106 {
    /**
     * 二分图判断
     * DFS 版本
     *
     * @param graph 图
     * @return res
     */

    private boolean res = true;   // 记录是否是二分图
    private boolean[] color;       // 节点的颜色
    private boolean[] isVisited;   // 当前节点是否被访问过了

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];    // 默认都是false
        isVisited = new boolean[n];  // 默认都没有被访问过

        // 图不一定连通，所以每一个节点都有可能成为遍历的起点
        for (int v = 0; v < n; v++) {
            if (!isVisited[v]) {
                traverse(graph, v);
            }
        }
        return res;
    }

    private void traverse(int[][] graph, int v) {
        // 提前判断，提前结束递归
        if (!res) {
            return;
        }
        // 递归出口
        if (graph[v] == null) {
            return;
        }
        isVisited[v] = true;
        // 继续遍历当前节点的每一个相邻节点
        for (int i : graph[v]) {
            // 没有被访问
            if (!isVisited[i]) {
                isVisited[i] = true;
                // 节点生成不同的颜色
                color[i] = !color[v];
                // 递归当前节点
                traverse(graph, i);
            } else if (color[i] == color[v]) {
                res = false;
                return;
            }
        }
    }
}
