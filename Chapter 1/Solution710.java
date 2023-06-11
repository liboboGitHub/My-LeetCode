import java.util.HashMap;
import java.util.Random;

public class Solution710 {
    private int sz;
    private Random random;
    private HashMap<Integer, Integer> map;

    public Solution710(int n, int[] blacklist) {
        map = new HashMap<>();
        sz = n - blacklist.length;
        for (int i : blacklist) {
            map.put(i, 666);
        }
        int last = n - 1;
        for (int i : blacklist) {
            // 如果i已经在区间[sz,N)
            // 直接可以忽略，不需要映射
            if (i >= sz) {
                continue;
            }
            // last 位置是白名单
            while (map.containsKey(last)) {
                last--;
            }
            // 把黑名单元素映射到last位置，last的值就是白名单元素值
            map.put(i, last);
            last--;
        }
        random = new Random();
    }

    public int pick() {
        // 随机选取一个索引
        int index = random.nextInt(sz);
        // 如果这个索引命中了黑名单，需要查找映射该位置的白名单值
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return index;

    }
}