import java.util.Arrays;

public class Solution698 {

    // 回溯算法：以数字的视角
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 特殊情况判断
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
        int target = sum / k;
        int[] subCollectionSum = new int[k];
        return backtrace(nums, 0, target, subCollectionSum);
    }

    private boolean backtrace(int[] nums, int index, int target, int[] subCollectionSum) {
        if (index == nums.length) {
            // 遍历每个子集是否符合要求
            for (int subCollection : subCollectionSum) {
                if (subCollection != target) {
                    return false;
                }
            }
            return true;
        }
        // 测试将当前的数字放进每个集合里
        for (int i = 0; i < subCollectionSum.length; i++) {
            if (subCollectionSum[i] + nums[index] > target) {
                continue;
            }
            // 加入当前集合
            subCollectionSum[i] += nums[index];
            // 递归下一个数字
            if (backtrace(nums, index + 1, target, subCollectionSum)) {
                return true;
            }
            // 退出当前集合
            subCollectionSum[i] -= nums[index];
        }
        return false;
    }

}
