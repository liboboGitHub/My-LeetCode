import java.util.Arrays;
import java.util.Random;

public class Solution384 {
    private int[] nums;
    private Random random = new Random();

    public Solution384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;

    }

    // 洗牌算法
    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            // 随机生成[i,n)内的元素（索引）
            int j = i + random.nextInt(n - i);
            swap(i, j, copy);
        }
        return copy;

    }

    private void swap(int i, int j, int[] copy) {
        int temp = copy[i];
        copy[i] = copy[j];
        copy[j] = temp;
    }
}
