import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1135 {
    // 最低成本连通城市（最小生成树 Kruskal算法）
    public int minimumCost(int n, int[][] connections) {
        // 并查集解决：连通性问题，连通分量，生成树问题，环检测问题
        UF uf = new UF(n + 1);
        // 按权重由低到高排序（二维数组排序）
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int res = 0;
        for (int[] edges : connections) {
            int node1 = edges[0];
            int node2 = edges[1];
            int edgeCost = edges[2];
            // 加入该条边会形成环
            if (uf.connected(node1, node2)) {
                continue;
            }
            uf.union(node1, node2);
            res += edgeCost;
        }
        if (uf.count == 2) {
            return res;
        } else {
            return -1;
        }
    }

    public class UF {
        // 记录连通分量
        private int count;
        // 节点x的父节点
        private int[] parent;

        // 构造函数
        public UF(int n) {
            // 一开始互不连通
            this.count = n;
            // 父节点指针指向自己
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 将p和q连接
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            // 根节点相同，所以p和q是连通的
            if (rootP == rootQ) {
                return;
            }
            parent[rootQ] = rootP;
            // 连通分量减少
            count--;
        }

        // 查找当前节点的根节点
        public int find(int x) {
            // 根节点的特点是父节点指向自己
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // 判断p和q是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        // 返回图中有多少个连通分量
        public int count() {
            return count;
        }
    }


    // Prim算法
    public int minimumCost_2(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);
        if (prim.allConnected()) {
            return prim.weightSum;
        } else {
            return -1;
        }
    }

    private List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] c : connections) {
            int w = c[0] - 1;
            int v = c[1] - 1;
            int weight = c[2];
            // 无环图也是双向图
            graph[w].add(new int[]{w, v, weight});
            graph[v].add(new int[]{v, w, weight});
        }
        return graph;
    }

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

}
