import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution90_2 {
    List<List<Integer>> res = new LinkedList<>(); // 记录结果
    LinkedList<Integer> trace = new LinkedList<>(); // 记录当前路径

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(trace));
        if (start > nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 防止出现重复，剪枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            trace.addLast(nums[i]);
            backtrack(nums, i + 1);
            trace.removeLast();
        }
    }


}
