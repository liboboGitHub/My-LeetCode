import java.util.LinkedList;
import java.util.List;

public class Solution39_2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    int curSum = 0;

    public List<List<Integer>> combinationSum(int[] dates, int target) {
        if (dates.length == 0) {
            return null;
        }

        backtrace(dates, 0, target);
        return res;
    }

    private void backtrace(int[] dates, int start, int target) {
        if (curSum == target) {
            res.add(new LinkedList<>());
        }
        if (start > dates.length) {
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = 0; i < dates.length; i++) {
            trace.addLast(dates[i]);
            curSum += dates[i];
            backtrace(dates, i + 1, target);
            trace.removeLast();
            curSum -= dates[i];
        }
    }
}
