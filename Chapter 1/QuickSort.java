import java.util.Random;

public class QuickSort {
    // 快速排序

    public static void sort(int[] nums) {
        // 随机打乱数组
        shuffer(nums);
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        // partition 执行的次数是二叉树节点的个数
        int p = partition(nums, low, high); // 已经把p这个位置的元素放在了正确的位置，也即：[low,p) <= p < [p+1,high]
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[0]; // 选择第一个元素作为“定位点”
        int i = low + 1, j = high;
        while (i <= j) {
            while (i < high && nums[i] <= pivot) { // 最终：nums[i] > pivot
                i++;
            }
            while (j > low && nums[j] > pivot) {  // 最终：nums[i] <= pivot
                j--;
            }
            swap(nums, i, j);
            if (i >= j) {
                break;
            }
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
