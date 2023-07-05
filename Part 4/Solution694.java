import java.util.HashMap;
import java.util.HashSet;

public class Solution694 {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    dfs(i, j, grid, 100, stringBuilder); // 淹没该片岛屿并记录路径
                    set.add(stringBuilder.toString()); // 添加路径
                }
            }
        }
        return set.size();
    }

    /* 淹没该片岛屿并记录路径 */
    private void dfs(int i, int j, int[][] grid, int d, StringBuilder s) {
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
        s.append(d).append(',');
        for (int index = 0; index < dir.length; index++) {
            int nextI = dir[index][0] + i;
            int nextJ = dir[index][1] + j;
            dfs(nextI, nextJ, grid, index, s);
        }
        s.append(-d).append(',');
    }
}
  