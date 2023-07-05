public class Solution130 {
    /*使用并查集解决：将边缘的O与虚拟节点相连，形成连通分量，内部没有被连通的O最终被替换*/
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // 初始化并查集
        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        // 将第一列和最后一列的O与dummy节点相连
        // 二维坐标线性化成一维坐标的一般技巧：x * n + y
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                // 将其与虚拟节点连通
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + (n - 1), dummy);
            }
        }
        // 将第一行和最后一行的O与dummy相连
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uf.union(i, dummy);
            }
            if (board[m - 1][i] == 'O') {
                uf.union((m - 1) * n + i, dummy);
            }
        }
        // 将内部的O与四周的O相连（使用方向数组搜索四周）
        int[][] temp = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        // 将此 O 与上下左右的 O 连通
                        int x = i + temp[k][0];
                        int y = j + temp[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        // 所有和 dummy 不连通的 O都要被替换
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(i * n + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    // 并查集：高效查询，适用于树、图中
    private class UF {
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
}
