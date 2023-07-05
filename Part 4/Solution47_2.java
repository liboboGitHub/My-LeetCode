import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution47_2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums);
        return res;
    }

    private void backtrace(int[] nums) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            trace.addLast(nums[i]);
            used[i] = true;
            backtrace(nums);
            trace.removeLast();
            used[i] = false;
        }
    }
}
