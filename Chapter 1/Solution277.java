import java.util.LinkedList;
import java.util.List;

public class Solution277 {
    public int findCelebrity(int n) {
        if (n == 1) {
            return 0;
        }
        int cand = 0; // 假设cand是名人
        for (int other = 0; other < n; other++) {
            // cand不是名人
            if (knows(cand, other) || !knows(other, cand)) {
                cand = other;
            } else {

            }
        }
        // 判断canda是否是名人
        for (int other = 0; other < n; other++) {
            if (cand == other) {
                continue;
            }
            if (knows(cand, other) || !knows(other, cand)) {
                return -1;
            }
        }
        return cand;
    }

    /*算法本身提供*/
    private boolean knows(int cand, int other) {
        return false;
    }
}
