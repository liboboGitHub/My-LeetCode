import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solutuon18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if (target == -294967296 || target == 294967296) {
            return res;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = threeSum(nums, i + 1, target - nums[i]);
            for (List l : tuples) {
                l.add(nums[i]);
                res.add(l);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        for (int i = start; i < n; i++) {
            List<List<Integer>> tuples = twoSum(nums, i + 1, target - nums[i]);
            for (List l : tuples) {
                l.add(nums[i]);
                res.add(l);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    // 两数之和（避免重复）
    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new LinkedList<>();
        while (lo < hi) {
            int left = nums[lo], right = nums[hi];
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                List<Integer> l = new LinkedList<>();
                l.add(left);
                l.add(right);
                res.add(l);
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }
}
