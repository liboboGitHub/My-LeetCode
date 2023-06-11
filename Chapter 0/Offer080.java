import java.util.LinkedList;
import java.util.List;

public class Offer080 {
    List<List<Integer>> res = new LinkedList<>();
    // 存路径
    LinkedList<Integer> track = new LinkedList<>();

    // 问题等价于：大小为k的子集
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }


    private void backtrack(int start, int n, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
        }

        // 标准回溯  剪枝：为了避免重复
        for (int i = start; i <= n; i++) {
            // 做选择（前序位置）
            track.addLast(i);
            // 递归
            backtrack(i + 1, n, k);
            // 撤销选择（后序位置）
            track.removeLast();
        }
    }
}
