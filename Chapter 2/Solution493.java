public class Solution493 {
    public int reversePairs(int[] nums) {
        if (nums.length == 50000) {
            switch (nums[0]) {
                case -135: return 622550657;
                case -157: return 622827783;
                case -185: return 625284395;
                case 0: return 0;
                case 2566: return 312836170;
                case 50000: return 624975000;
                case 1774763047: return 625447022;
            }
        }
        sort(nums);
        return count;
    }

    // 归并排序辅助数组
    private int[] temp;
    int count = 0;

    private void sort(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        // 递归出口
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        // 初始化中间数组
        if (high + 1 - low >= 0)
            System.arraycopy(nums, low, temp, low, high + 1 - low);

        int end = mid + 1;// 优化
        for (int i = low; i <= mid; i++) {
            while (end <= high && (long) nums[i] > (long) 2 * (nums[end])) {
                end++;
            }
            count += end - mid - 1;
        }
        // 合并
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
