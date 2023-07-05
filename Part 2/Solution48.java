public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 镜像对称
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 反转每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    public void reverse(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (right > left) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
