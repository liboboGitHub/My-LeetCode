import java.util.LinkedList;
import java.util.List;

public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int upper_bound = 0, lower_bound = m - 1;
        int left_bound = 0, right_bound = n - 1;
        int[] res = new int[m * n];
        int index = 0;
        while (index < m * n) {
            if (upper_bound <= lower_bound) {
                for (int j = left_bound; j <= right_bound; j++) {
                    res[index++] = matrix[upper_bound][j];
                }
                upper_bound++;
            }
            if (left_bound <= right_bound) {
                for (int i = upper_bound; i <= lower_bound; i++) {
                    res[index++] = matrix[i][right_bound];
                }
                right_bound--;
            }
            if (upper_bound <= lower_bound) {
                for (int j = right_bound; j >= left_bound; j--) {
                    res[index++] = matrix[lower_bound][j];
                }
                lower_bound--;
            }
            if (left_bound <= right_bound) {
                for (int i = lower_bound; i >= upper_bound; i--) {
                    res[index++] = matrix[i][left_bound];
                }
                left_bound++;
            }
        }
        return res;
    }
}
