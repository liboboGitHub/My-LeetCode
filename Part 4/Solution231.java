public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        // n & (n - 1)可以去除n的二进制表示的最后一位1
        if (n <= 0) {
            return false;
        }
        // 2^n的二进制表示中只有一位1
        return (n & (n - 1)) == 0;
    }
}
