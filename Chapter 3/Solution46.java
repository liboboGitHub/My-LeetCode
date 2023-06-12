import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrace(nums, trace, used);
        return res;
    }

    private void backtrace(int[] nums, LinkedList<Integer> trace, boolean[] used) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 做选择
            trace.addLast(nums[i]);
            used[i] = true;
            backtrace(nums, trace, used);
            // 撤销选择
            trace.removeLast();
            used[i] = false;
        }
    }

}
