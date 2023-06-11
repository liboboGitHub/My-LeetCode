public class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length, maxFar = 0;
        // 如果数组里面都是正数，必然可以到达最后一个下标
        for (int i = 0; i < n - 1; i++) {
            maxFar = Math.max(maxFar, i + nums[i]);
            if (maxFar == i) {
                return false;
            }
        }
        return maxFar >= n - 1;
    }
}
