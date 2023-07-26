import jdk.internal.org.objectweb.asm.ClassReader;

public class Solution42 {
    // 双指针
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int n = height.length, res = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);  // 表示[0,...,left]最高柱子的高度
            rightMax = Math.max(rightMax, height[right]); // 表示[right,...,n-1]最高柱子的高度
            // 重点
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
