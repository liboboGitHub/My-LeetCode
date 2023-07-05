import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40_2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    int traceSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        backtrace(candidates, 0, target);
        return res;
    }

    private void backtrace(int[] candidates, int start, int target) {
        if (traceSum == target) {
            res.add(new LinkedList<>(trace));
        }
        if (traceSum > target || start > candidates.length) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            trace.addLast(candidates[i]);
            traceSum += candidates[i];
            backtrace(candidates, i + 1, target);
            trace.removeLast();
            traceSum -= candidates[i];
        }
    }
}


