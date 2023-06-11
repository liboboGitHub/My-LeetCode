public class Solution26 {
    public int removeDuplicates(int[] nums) {
        // 快慢指针
        int fast = 1;
        int slow = 0;
        while (fast != nums.length) {
            if (nums[slow] != nums[fast]) {
                slow ++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
