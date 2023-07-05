import java.util.LinkedList;
import java.util.List;

public class Solution78_2 {
    List<List<Integer>> res = new LinkedList<>(); // 记录结果
    LinkedList<Integer> trace = new LinkedList<>(); // 记录当前路径

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        // 组合问题，元素不能重复使用
        backtrace(nums, 0);
        return res;
    }

    private void backtrace(int[] nums, int start) {
        if (start == nums.length) {
            return;
        }
        if (start < nums.length) {
            res.add(new LinkedList<>(trace));
        }
        for (int i = start; i < nums.length; i++) {
            trace.addLast(nums[i]);
            backtrace(nums, i + 1);
            trace.removeLast();
        }
    }
}
