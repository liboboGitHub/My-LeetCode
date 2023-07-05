import java.util.LinkedList;
import java.util.List;

public class Solution216 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;

    // 归类：属于组合问题
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || k > n) {
            return res;
        }
        backtrack(k, n, 1);
        return res;
    }

    private void backtrack(int k, int target, int start) {
        if (track.size() == k && sum == target) {
            res.add(new LinkedList<>(track));
        }
        if (sum > target || track.size() > k) {
            return;
        }
        for (int i = start; i < 10; i++) {
            track.addLast(i);
            sum += i;
            backtrack(k, target, i + 1);
            track.removeLast();
            sum -= i;
        }
    }
}
