public class Solution1254 {
    // 说明：此题并没有说明这个区域的边界四周被水域包围
    // 将边界上的岛屿去掉，内部的岛屿就是封闭岛屿
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        // 将左右边界的岛屿变成水域
        for (int i = 0; i < m; i++) {
            dfs(i, 0, grid);
            dfs(i, n - 1, grid);

        }
        // 将上下边界的岛屿变成水域
        for (int j = 0; j < n; j++) {
            dfs(0, j, grid);
            dfs(m - 1, j, grid);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] grid) {
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        for (int[] d : dir) {
            int nextI = d[0] + i;
            int nextJ = d[1] + j;
            dfs(nextI, nextJ, grid);
        }
    }
}
