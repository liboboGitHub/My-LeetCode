import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // 对所有区间的起点升序排序，起点相同按终点降序排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int lastRight = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= left && interval[1] <= right) {
                continue;
            }
            if (interval[0] <= right && interval[1] >= right) {
                // 更新右边界
                right = interval[1];
            }
            if (interval[0] >= right) {
                int[] partRes = {left, right};
                res.add(partRes);
                lastRight = right;
                left = interval[0];
                right = interval[1];
            }
        }
        if (left >= lastRight) {
            int[] partRes = {left, right};
            res.add(partRes);
        }
        // List转换为二维数组
        return res.toArray(new int[0][]);
    }
}
