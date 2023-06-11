import java.util.Random;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        shuffer(nums);
        int low = 0, high = nums.length - 1;
        k = nums.length - k;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p > k) {
                high = p - 1;
            } else if (p < k) {
                low = p + 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low]; // 选择第一个元素作为“定位点”
        int i = low + 1, j = high;
        while (i <= j) {
            while (i < high && nums[i] <= pivot) { // 最终：nums[i] > pivot
                i++;
            }
            while (j > low && nums[j] > pivot) {  // 最终：nums[i] <= pivot
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private static void shuffer(int[] nums) {
        int n = nums.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(n - i) + i;
            swap(nums, i, r);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int T = nums[i];
        nums[i] = nums[j];
        nums[j] = T;
    }
}
