import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        // 根据end升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int x_end = intvs[0][1];
        for (int[] intv : intvs) {
            if (intv[0] >= x_end) {
                count++;
                x_end = intv[1];
            }
        }
        return count;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }
}
