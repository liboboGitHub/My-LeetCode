public class Solution1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果grid2中的陆地在grid1中是海水的话，岛屿2肯定不是岛屿1的子岛屿
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    // 将该片岛屿淹没，剩下的岛屿就是子岛屿了
                    dfs(i, j, grid2);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(i, j, grid2);
                }
            }
        }
        return res;
    }

    /* 淹没该片岛屿 */
    private void dfs(int i, int j, int[][] grid) {
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
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
