import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ExamRoom {

    // 将相邻两个人抽象成线段的两个端点，根据线段做调整
    public Map<Integer, int[]> start; // 线段p左端点
    public Map<Integer, int[]> end;   // 线段p右端点
    public TreeSet<int[]> pq;     // 存放线段的，有序
    public int n;

    public ExamRoom(int n) {
        this.n = n;
        start = new HashMap<>();
        end = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {
            int da = dis(a), db = dis(b);
            if (da == db) {  // 长度相同时，按照起点降序排序，这样就能将索引小的线段放到后面了，优先获取索引小的线段
                return b[0] - a[0];
            }
            return da - db;   // 升序排序
        });
        // 初始化pq
        addInteal(new int[]{-1, n});
    }

    private void addInteal(int[] ints) {
        pq.add(ints);
        start.put(ints[0], ints);
        end.put(ints[1], ints);
    }

    private void removeInteal(int[] ints) {
        pq.remove(ints);
        start.remove(ints[0]);
        end.remove(ints[1]);
    }

    // 计算线段长度
    private int dis(int[] d) {
        int x = d[0], y = d[1];
        if (x == -1) {
            return y;
        }
        if (y == n) {
            return n - x - 1;
        }
        return (y - x) / 2;  // 中点到端点的距离
    }


    public int seat() {
        int[] l = pq.last();
        int x = l[0], y = l[1], seat;
        if (x == -1) { // 一个人都没坐
            seat = 0;
        } else if (y == n) { // 坐了一个人，且在第一个位置上坐着，为了距离最远，这时坐在最后一个位置上
            seat = n - 1;
        } else {
            seat = (y - x) / 2 + x; // 坐在中间位置
        }
        int[] left = new int[]{x, seat};
        int[] right = new int[]{seat, y};
        removeInteal(l);
        addInteal(left);
        addInteal(right);
        return seat;
    }

    // 合并以p为端点的左右线段
    public void leave(int p) {
        int[] right = start.get(p);
        int[] left = end.get(p);
        int[] merge = new int[]{left[0], right[1]};
        removeInteal(left);
        removeInteal(right);
        addInteal(merge);
    }
}
