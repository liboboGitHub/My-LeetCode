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
