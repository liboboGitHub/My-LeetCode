public class Solution191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            // n & (n - 1)可以去除n的二进制表示的最后一位1
            n = n & (n - 1);
            ++res;
        }
        return res;
    }
    
}
