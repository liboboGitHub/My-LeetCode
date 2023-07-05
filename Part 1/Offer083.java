import java.util.LinkedList;
import java.util.List;

public class Offer083 {
    /**
     * 回溯法解决全排列问题
     *
     * @param nums
     * @return
     */
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 选择列表
        boolean[] track = new boolean[nums.length];

        // 路径
        LinkedList<Integer> l = new LinkedList<>();

        recursion(nums, track, l);
        return res;
    }

    private void recursion(int[] nums, boolean[] track, LinkedList<Integer> l) {
        // 满足一个排列，递归结束的条件
        if (l.size() == nums.length) {
            res.add(new LinkedList(l));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 做选择
            if (track[i]) {
                continue;
            }
            l.add(nums[i]);
            track[i] = true;
            recursion(nums, track, l);
            // 撤销选择（维护状态，前面的递归返回后，说明此时已经到最后一个元素了，
            // “小递归”结束后，也就是在后序位置上将不可用的元素恢复，让下一次的“大递归”可用
            // 可以说后面这两行就是真正在回溯，也就是说在递归到底返回做的事情。
            l.removeLast();
            track[i] = false;
        }

    }
}
