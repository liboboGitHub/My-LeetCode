public class Solution1094 {
    /**
     * 构建差分数组
     */
    public class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /* 给闭区间 [i, j] 增加 val（可以是负数）*/
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = diff[i] + res[i - 1];
            }
            return res;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];    // 车站数
        Difference diff = new Difference(nums);
        for (int[] T : trips) {
            int val = T[0];
            int i = T[1];
            int j = T[2] - 1;
            diff.increment(i, j, val);
        }
        int[] bool = diff.result(); // 每一站的载客量
        for (int j : bool) {
            if (j > capacity) {
                return false;
            }
        }
        return true;
    }
}
