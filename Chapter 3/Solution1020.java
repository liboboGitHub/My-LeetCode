public class Solution1020 {
    public int numEnclaves(int[][] grid) {
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
                if (grid[i][j] == 1) {
                    res++;
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
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        for (int[] d : dir) {
            int nextI = d[0] + i;
            int nextJ = d[1] + j;
            dfs(nextI, nextJ, grid);
        }
    }
}
