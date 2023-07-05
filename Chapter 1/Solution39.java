import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            sum += candidates[i];
            // 同一元素可重复使用
            backtrack(candidates, target, i);
            track.removeLast();
            sum -= candidates[i];
        }
    }
}
