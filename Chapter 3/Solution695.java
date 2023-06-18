public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        // 边界判断
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        // base case
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int sum = 0;
        for (int[] d : dir) {
            int nextI = d[0] + i;
            int nextJ = d[1] + j;
            sum += dfs(nextI, nextJ, grid);
        }
        return sum+1;
    }

}
