import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    List<List<Integer>> res = new LinkedList<>();
    // 存路径
    LinkedList<Integer> track = new LinkedList<>();

    //求序列的所有子集
    public List<List<Integer>> subsets(int[] nums) {
        // 回溯函数
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        // 回溯框架  剪枝：为了避免重复，遍历时只需要从它下一个节点开始
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 递归
            backtrack(nums, i + 1);
            // 撤销选择，真正递归
            track.removeLast();
        }
    }
}
