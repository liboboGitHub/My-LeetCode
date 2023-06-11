import java.util.*;

public class Solution743 {
    int networkDelayTime(int[][] times, int n, int k) {
        //构建图的邻接表
        List<int[]>[] graph = new LinkedList[n+1];
        // 初始化邻接表
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 构建图
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }
        int[] distTo = dijkstra(k, graph);
        int res = 0;
        for (int to : distTo) {
            if (to == Integer.MAX_VALUE) {
                return -1;
            }
            // 寻找distTo中最大值
            res = Math.max(res, to);
        }
        return res;
    }

    // Dijkstra算法模板（最短路径且权重最小）
    int[] dijkstra(int start, List<int[]>[] graph) {
        // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> (a.distFromStart - b.distFromStart));
        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State state = pq.poll();
            int curNodeID = state.id;
            int curDistFromStart = state.distFromStart;
            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }
            // 遍历当前的节点的相邻节点，只需要将能构成最短路径的节点加入队列即可
            for (int[] nextNode : graph[curNodeID]) {
                // 看看从 curNode 达到 nextNode 的距离是否会更短
                int nextNodeID = nextNode[0];
                int weight = nextNode[1];
                int distToNextNode = distTo[curNodeID] + weight;
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }

    private class State {
        int id;
        int distFromStart; // 从起点 start 到当前这个节点的路径权重

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
}