import java.util.Arrays;

public class Solution912 {
    public int[] sortArray(int[] nums) {
        Merge.sort(nums);
        return nums;
    }

    // 归并排序
    public static class Merge {
        // 辅助数组
        public static int[] temp;

        public static void sort(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
        }

        private static void sort(int[] nums, int low, int high) {
            // 递归出口，只剩一个元素，不用排序
            if (low == high) {
                return;
            }
            int mid = low + (high - low) / 2;
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            // 类似二叉树的后序位置，合并已经排好序的左右两边
            merge(nums, low, mid, high);
        }

        private static void merge(int[] nums, int low, int mid, int high) {
            if (high + 1 - low >= 0) System.arraycopy(nums, low, temp, low, high + 1 - low);
            int i = low, j = mid + 1; // 用来遍历temp数组
            for (int k = low; k <= high; k++) { // 用来填充num数组
                if (i == mid + 1) {
                    nums[k] = temp[j++];
                } else if (j == high + 1) {
                    nums[k] = temp[i++];
                } else if (temp[i] > temp[j]) {
                    nums[k] = temp[j++];
                } else {
                    nums[k] = temp[i++];
                }
            }
        }
    }
}
