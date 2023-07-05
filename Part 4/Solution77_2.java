import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution77_2 {
    List<List<Integer>> res = new LinkedList<>(); // 记录结果
    LinkedList<Integer> trace = new LinkedList<>(); // 记录当前路径

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) {
            return null;
        }
        // 组合问题，元素不能重复使用
        backtrace(0, n, k);
        return res;
    }

    private void backtrace(int start, int n, int k) {
        if (trace.size() == k) {
            res.add(new LinkedList<>(trace));
        }
        if (start >= n) {
            return;
        }
        for (int i = start; i < n; i++) {
            trace.addLast(i);
            backtrace(i + 1, n, k);
            trace.removeLast();
        }
    }
}
