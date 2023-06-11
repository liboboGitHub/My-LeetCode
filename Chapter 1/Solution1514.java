
import java.util.*;

public class Solution1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // 构建领接表
        List<double[]>[] garph = new LinkedList[n];
        // 初始化图
        for (int i = 0; i < n; i++) {
            garph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double edgeProb = succProb[i];
            // 无向图也是双向图
            garph[from].add(new double[]{(double) to, edgeProb});
            garph[to].add(new double[]{(double) from, edgeProb});
        }
        return dijkstra(start, end, garph);
    }

    public class State {
        int id;
        double probFromStart; // 从起点 start 到当前这个节点的概率

        public State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }


    public double dijkstra(int start, int end, List<double[]>[] garph) {
        // 定义：distProb[i] 的值就是节点 start 到达节点 i 的最大概率
        double[] distProb = new double[garph.length];
        // 初始化，两点之间不可达
        Arrays.fill(distProb, -1);
        distProb[start] = 1;
        // 构建队列
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.probFromStart, a.probFromStart);
        });

        pq.offer(new State(start, 1));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curID = curState.id;
            double curProbFromStart = curState.probFromStart;

            if (curID == end) {
                return distProb[curID];
            }
            if (curProbFromStart < distProb[curID]) {
                continue;
            }
            for (double[] next : garph[curID]) {
                int nextID = (int) next[0];
                double nextProbFromStart = next[1] * distProb[curID];
                if (nextProbFromStart > distProb[nextID]) {
                    distProb[nextID] = nextProbFromStart;
                    pq.offer(new State(nextID, nextProbFromStart));
                }
            }
        }
        return 0.0;
    }
}
