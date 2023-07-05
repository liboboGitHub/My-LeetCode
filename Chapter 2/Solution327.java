public class Solution327 {

    private int lower;
    private int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        // 构建前缀和数组，
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = (long) nums[i] + preSum[i];
        }
        sort(preSum);
        return count;
    }

    private long[] temp;
    private int count = 0;

    private void sort(long[] preSum) {
        temp = new long[preSum.length];
        sort(preSum, 0, preSum.length - 1);
    }

    private void sort(long[] preSum, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(preSum, low, mid);
        sort(preSum, mid + 1, high);
        merge(preSum, low, mid, high);
    }

    private void merge(long[] preSum, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = preSum[i];
        }

        // 维护左闭右开区间 [start, end) 中的元素 和  nums[i] 的差在 [lower, upper] 中
        int start = mid + 1, end = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (start <= high && preSum[start] - preSum[i] < lower) { // 注意理解：为什么preSum[start] - preSum[i] < low？
                start++;
            }
            while (end <= high && preSum[end] - preSum[i] <= upper) {
                end++;
            }
            count += end - start;
        }

        int i = low, j = mid + 1; // 用来遍历temp数组
        for (int k = low; k <= high; k++) { // 用来填充num数组
            if (i == mid + 1) {
                preSum[k] = temp[j++];
            } else if (j == high + 1) {
                preSum[k] = temp[i++];
            } else if (temp[i] > temp[j]) {
                preSum[k] = temp[j++];
            } else {
                preSum[k] = temp[i++];
            }
        }
    }
}
