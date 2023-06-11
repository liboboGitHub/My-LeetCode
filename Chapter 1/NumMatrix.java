public class NumMatrix {

    int[][] preMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        preMatrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preMatrix[i][j] = preMatrix[i - 1][j] + preMatrix[i][j - 1] + matrix[i - 1][j - 1] - preMatrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preMatrix[row2 + 1][col2 + 1] - preMatrix[row2 + 1][col1] - preMatrix[row1][col2 + 1] + preMatrix[row1][col1];
    }
}
