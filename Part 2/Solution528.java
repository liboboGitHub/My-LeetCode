import java.util.Random;

public class Solution528 {
    private int[] preSum;
    private Random random = new Random();

    public Solution528(int[] w) {
        // 构建前缀和数组
        int n = w.length;
        preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = preSum.length;
        int rand = random.nextInt(preSum[n - 1]) + 1;
        return left_bound(preSum, rand) - 1;
    }


    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
}
