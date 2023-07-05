import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    //  存储「横切边」的优先级队列
    private PriorityQueue<int[]> pq;
    // 类似 visited 数组的作用，记录哪些节点已经成为最小生成树的一部分
    private boolean[] inBST;
    // 生成树的权重和
    private int weightSum = 0;
    // graph 是用邻接表表示的一幅图，
    // graph[s] 记录节点 s 所有相邻的边，
    // 三元组 int[]{from, to, weight} 表示一条边
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {

        this.graph = graph;
        // 按照边的权重从小到大排序
        this.pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int n = graph.length;
        this.inBST = new boolean[n];
        // 随便从一个点开始切分都可以，我们不妨从节点 0 开始
        inBST[0] = true;
        cut(0);// 初次切分
        // 不断进行切分，向最小生成树中添加边
        while (!pq.isEmpty()) {
            int[] edge = pq.poll(); // 取出一条边（由于pq是优先队列，所以取出来的横切边权重肯定是最小的
            int to = edge[1];
            int weight = edge[2];
            if (inBST[to]) {
                // 节点 to 已经在最小生成树中，跳过
                // 否则这条边会产生环
                continue;
            }
            // 将边加入最小生成树
            weightSum += weight;
            inBST[to] = true;

            // 继续切分
            cut(to);
        }

    }

    // 将 s 的横切边加入优先队列
    private void cut(int s) {
        // 遍历s的邻边，注意：edge存储的是{from, to, weight} 表示一条边
        for (int[] edge : graph[s]) {
            int to = edge[1];
            if (inBST[to]) {
                continue;
            }
            // 加入到横切边优先队列
            pq.offer(edge);
        }
    }

    // 最小生成树的权重和
    public int weightSum() {
        return weightSum;
    }

    // 判断最小生成树是否包含图中所有节点
    public boolean allConnected() {
        for (boolean b : inBST) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
