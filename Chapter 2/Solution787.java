import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution787 {
    HashMap<Integer, List<int[]>> hashMap = new HashMap<>();
    int[][] memo;
    int src, dst;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++; // 节点变成边
        this.src = src;
        this.dst = dst;
        // 初始化备忘录
        memo = new int[n][k + 1];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        // 构建入度索引表
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            hashMap.putIfAbsent(to, new LinkedList<>());
            hashMap.get(to).add(new int[]{from, price});
        }
        // dp函数的定义：从src到dst且在k步以内的最小成本
        return dp(dst, k);
    }

    private int dp(int dst, int k) {
        if (dst == src) {
            return 0;
        }
        // 限制条件
        if (k == 0) {
            return -1;
        }
        if (memo[dst][k] != -1) {
            return memo[dst][k];
        }

        int res = Integer.MAX_VALUE;
        if (hashMap.containsKey(dst)) {
            for (int[] index : hashMap.get(dst)) {
                int from = index[0];
                int price = index[1];
                int subProblem = dp(from, k - 1);
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
                if (res != Integer.MAX_VALUE) {
                    memo[dst][k] = res;
                }
            }
        }
        return memo[dst][k];
    }
}

