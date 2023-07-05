import java.util.HashMap;

public class Solution698_2 {
    // 回溯算法：以集合的视角
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //排除特殊情况
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k, used = 0;
        return backtrace(nums, 0, 0, k, used, target);
    }

    // 现在 k 号桶正在思考是否应该把 nums[start] 这个元素装进来；
    // 目前 k 号桶里面已经装的数字之和为 curSum；used 标志某一个元素是否已经被装到桶中；target 是每个桶需要达成的目标和。
    HashMap<Integer, Boolean> memo = new HashMap<>(); // 优化点一

    private boolean backtrace(int[] nums, int start, int curSum, int k, int used, int target) {
        // 递归出口
        if (k == 0) {
            return true;
        }
        if (curSum == target) {
            // 当前集合以及满足，看下一个集合的情况
            boolean res = backtrace(nums, 0, 0, k - 1, used, target);
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {  // used的第i位的数字是1，代表当前这个数字已经用过了
                continue;
            }
            if (nums[i] + curSum > target) {
                continue;
            }
            // 做选择
            used |= 1 << i;  // used的第i位变为1
            curSum += nums[i];
            if (backtrace(nums, i + 1, curSum, k, used, target)) {
                return true;
            }

            // 撤销选择
            used ^= 1 << i;
            curSum -= nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution698_2 test = new Solution698_2();
        int[] example = {4, 3, 2, 3, 5, 2, 1};
        test.canPartitionKSubsets(example, 4);

    }
}
