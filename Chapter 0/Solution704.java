public class Solution704 {
    public int search(int[] nums, int target) {
        // 典型的二分搜索
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;  // 难点；判断
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
