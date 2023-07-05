public class Solution96 {
    public int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int low, int high) {
        // base case
        if (low > high) {
            return 1; // 后面要做乘法，这里不能返回0
        }
        if (memo[low][high] != 0) {
            return memo[low][high];
        }
        int sum = 0;
        for (int i = low; i <= high; i++) {
            int leftCount = count(low, i - 1);
            int rightCount = count(i + 1, high);
            sum += leftCount * rightCount;
        }
        memo[low][high] = sum;
        return sum;
    }
}
