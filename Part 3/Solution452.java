import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        // 根据end升序排序
        Arrays.sort(intvs, (o1,o2)->{
            if(o1[1]>o2[1]) return 1;
            if(o1[1]<o2[1]) return -1;
            return 0;
        });
        int count = 1;
        int x_end = intvs[0][1];
        for (int[] intv : intvs) {
            if (intv[0] > x_end) {
                count++;
                x_end = intv[1];
            }
        }
        return count;
    }

    public int findMinArrowShots(int[][] points) {

        return  intervalSchedule(points);
    }
}
