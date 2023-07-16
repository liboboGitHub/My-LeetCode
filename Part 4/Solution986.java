import java.util.ArrayList;
import java.util.List;

public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];

            // 相交
            if (b2 >= a1 && a2 >= b1) {
                int[] partRes = new int[2];
                partRes[0] = Math.max(a1, b1);
                partRes[1] = Math.min(a2, b2);
                res.add(partRes);
            }
            if (b2 > a2) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
