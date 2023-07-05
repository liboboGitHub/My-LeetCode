import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer082 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
        }
        // 优化部分1： 数组是有序的，大于target即不用再遍历执行了
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 优化部分2
            if (sum + candidates[i] > target) {
                break;
            }
            track.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i + 1);
            track.removeLast();
            sum -= candidates[i];
        }

    }
}
