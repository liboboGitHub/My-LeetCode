import java.util.*;

public class Solution1631 {

    // 处理上下左右移动的逻辑
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 构建图
    private List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> neighbor = new ArrayList<>();
        for (int[] dir : dirs) {
            int newX = dir[0] + x;
            int newY = dir[1] + y;
            // 判断是否会越界
            if (newX >= m || newX < 0 || newY >= n || newY < 0) {
                continue;
            }
            neighbor.add(new int[]{newX, newY});
        }
        return neighbor;
    }

    private class State {
        int x, y;
        int effortFromStart; // 从起点 (0, 0) 到当前位置的最小体力消耗

        public State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // 当前节点的最小体力消耗
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        res[0][0] = 0;//在起始节点为0
        Queue<State> pq = new PriorityQueue<>((a, b) -> (a.effortFromStart - b.effortFromStart));
        pq.offer(new State(0, 0, 0));
        while (!pq.isEmpty()) {

            // 当前元素出队
            State curNode = pq.poll();
            int curX = curNode.x;
            int curY = curNode.y;
            int curEffort = curNode.effortFromStart;
            if (curEffort > res[curX][curY]) {
                continue;
            }
            // 到达终点了
            if (curX == m - 1 && curY == n - 1) {
                return curEffort;
            }
            for (int[] nextNode : adj(heights, curX, curY)) {
                int nextX = nextNode[0];
                int nextY = nextNode[1];
                int nextEffort = Math.max(res[curX][curY], Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                if (res[nextX][nextY] > nextEffort) {
                    res[nextX][nextY] = nextEffort;
                    pq.offer(new State(nextX, nextY, nextEffort));
                }
            }
        }
        return -1;

    }
}
