import java.util.Arrays;

public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        // 对所有区间的起点升序排序，起点相同按终点降序排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        // 区间
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 遍历当前区间的左右端点
            if (interval[0] >= left && interval[1] <= right) {
                res++;
            }
            if (interval[0] <= right && interval[1] >= right) {
                // 更新右边界
                right = interval[1];
            }
            if (interval[0] >= right) {
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - res;
    }
}
