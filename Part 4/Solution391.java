import java.util.Arrays;
import java.util.HashSet;

public class Solution391 {
    public boolean isRectangleCover(int[][] rectangles) {
        // 左下角定点坐标
        int X1 = Integer.MAX_VALUE;  // 初始化为最大值
        int Y1 = Integer.MAX_VALUE;

        // 右上角的定点坐标
        int X2 = Integer.MIN_VALUE; // 初始化为最小值
        int Y2 = Integer.MIN_VALUE;
        int curArea = 0;
        HashSet<String> points = new HashSet<>();
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            X1 = Math.min(X1, x1);
            Y1 = Math.min(Y1, y1);
            X2 = Math.max(X2, x2);
            Y2 = Math.max(Y2, y2);
            // 当前小矩形的面积（面积角度）
            curArea += (x2 - x1) * (y2 - y1);
            // 每个小矩阵的四个角的坐标（角的角度）
            String p1 = x1 + "," + y1, p2 = x1 + "," + y2, p3 = x2 + "," + y1, p4 = x2 + "," + y2;
            for (String p : Arrays.asList(p1, p2, p3, p4)) {
                if (points.contains(p)) {
                    points.remove(p);
                } else {
                    points.add(p);
                }
            }
        }
        // 需要拼成的面积
        int expectArea = (X2 - X1) * (Y2 - Y1);
        // 保证面积
        if (curArea != expectArea) {
            return false;
        }
        // 保证顶点的个数
        if (points.size() != 4) {
            return false;
        }
        // 保证四个顶点是需要的
        if (!points.contains(X1 + "," + Y1) || !points.contains(X1 + "," + Y2) || !points.contains(X2 + "," + Y1) || !points.contains(X2 + "," + Y2)) {
            return false;
        }
        return true;
    }
}
