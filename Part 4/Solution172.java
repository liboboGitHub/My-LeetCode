public class Solution172 {
    public int trailingZeroes(int n) {
        // 只要分析n!能拆出多少个5，就有多少个0
        int res = 0;
        long div = 5;
        while (div <= n) {
            res += n / div;   // n / 5表示有多少个5的倍数，会包含一个5，n / 25，表示有多少个25的倍数，会多包含一个5，后面以此类推
            div *= 5;
        }
        return res;
    }
}
