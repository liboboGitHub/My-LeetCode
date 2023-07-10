public class Solution793 {
    public int preimageSizeFZF(int k) {
        int res = 0;
        // 满足条件时， 阶乘末尾有 k个0的最大值 - 阶乘末尾有 k个0的最小值 + 1 = res
        return (int) (right(k) - left(k) + 1);
    }

    // 二分搜索左侧边界值
    private long left(int k) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) > k) {
                hi = mid;
            } else if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid; // 继续往左侧收缩
            }
        }
        return lo;
    }

    // 二分搜索右侧边界值
    private long right(int k) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) > k) {
                hi = mid;
            } else if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else {
                lo = mid + 1; // 继续往右侧收缩
            }
        }
        return lo - 1;
    }

    // 判断n!有几个0
    private long trailingZeroes(long n) {
        long res = 0;
        long div = 5;
        while (div <= n) {
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
