public class Solution200 {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    // 深度优先搜索，将当前的数的四周相邻变成0
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid) {
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        // 边界判断
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        // base case
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d : dir) {
            int nextI = d[0] + i;
            int nextJ = d[1] + j;
            dfs(nextI, nextJ, grid);
        }
    }
}
