public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        // 索引和数字对应
        int nums1 = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res[0] = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }
        return res;

    }
}

