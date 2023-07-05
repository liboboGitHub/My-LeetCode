public class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length, end = 0, maxFar = 0, res = 0;
        for (int i = 0; i < n - 1; i++) {
            //贪心策略：每次在能到达的所有位置中，选择下一步跳跃能到达的最远位置
            maxFar = Math.max(maxFar, nums[i] + i);
            if (i == end) {
                res++;
                end = maxFar;
            }
        }
        return res;
    }
}