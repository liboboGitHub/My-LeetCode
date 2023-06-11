import java.util.LinkedList;
import java.util.Queue;

public class Solution785 {
    /**
     * 二分图判断
     *
     * @param graph 图
     * @return res
     */

    /****************************DFS 版本********************************/
//    private boolean res = true;   // 记录是否是二分图
//    private boolean[] color;       // 节点的颜色
//    private boolean[] isVisited;   // 当前节点是否被访问过了
//
//    public boolean isBipartite(int[][] graph) {
//        int n = graph.length;
//        color = new boolean[n];    // 默认都是false
//        isVisited = new boolean[n];  // 默认都没有被访问过
//
//        // 图不一定连通，所以每一个节点都有可能成为遍历的起点
//        for (int v = 0; v < n; v++) {
//            if (!isVisited[v]) {
//                traverse(graph, v);
//            }
//        }
//        return res;
//    }
//
//    private void traverse(int[][] graph, int v) {
//        // 提前判断，提前结束递归
//        if (!res) {
//            return;
//        }
//        // 递归出口
//        if (graph[v] == null) {
//            return;
//        }
//        isVisited[v] = true;
//        // 继续遍历当前节点的每一个相邻节点
//        for (int i : graph[v]) {
//            // 没有被访问
//            if (!isVisited[i]) {
//                isVisited[i] = true;
//                // 节点生成不同的颜色
//                color[i] = !color[v];
//                // 递归当前节点
//                traverse(graph, i);
//            } else if (color[i] == color[v]) {
//                res = false;
//                return;
//            }
//        }
//    }
    /********************************************************************/

    /**************************** BFS版本 ********************************/
    private boolean res = true;   // 记录是否是二分图
    private boolean[] color;       // 节点的颜色，默认都是False
    private boolean[] isVisited;   // 当前节点是否被访问过了

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];    // 默认都是false
        isVisited = new boolean[n];  // 默认都没有被访问过

        // 图不一定连通，所以每一个节点都有可能成为遍历的起点
        for (int v = 0; v < n; v++) {
            if (!isVisited[v]) {
                BFS(graph, v);
            }
        }
        return res;
    }

    private void BFS(int[][] graph, int start) {
        // 广度优先遍历或者涉及到层级遍历都应该使用一个队列存储当前节点
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        // 入队的元素都是被访问过的
        queue.offer(start);
        while (!queue.isEmpty() && res) {
            // 出队是为了寻找当前节点的相邻节点
            int cur = queue.poll();
            for (int w : graph[cur]) {
                if (!isVisited[w]) {
                    // 染成不同的颜色
                    color[w] = !color[cur];
                    isVisited[w] = true;
                    queue.offer(w);
                } else {
                    if (color[cur] == color[w]) {
                        res = false;
                        return;
                    }
                }
            }
        }
    }

    /********************************************************************/
}
