public class Solution261 {

    // 判断输入的若干条边是否能构造出一棵树结构
    public boolean validTree(int n, int[][] edges) {
        // 初始化并查集
        UF uf = new UF(n);
        // 将边中的两个节点相连
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            // 如果两个节点在同一个联通分量（也即相连）则会形成环，肯定构不成树
            if (uf.connected(node1, node2)) {
                return false;
            }
            // 否则可以构成树中的节点
            uf.union(node1, node2);
        }
        // 生成树肯定只有一个联通分量
        return uf.count == 1;
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
}