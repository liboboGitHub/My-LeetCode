import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    /**
     * 冒泡排序（核心：两两相邻比较，大的交换到后面）
     * 稳定性：稳定
     * 时间复杂度：最佳：O(n) ，最差：O(n^2)， 平均：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums 待排序数组
     * @return 排好序的数组
     */
    public static int[] bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) { // 已经排好序了
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // int[] test = new int[]{1, 5, 4, 78, 59, 1, 6, 85, 42};
        Scanner in = new Scanner(System.in);
        // 输入数组大小
        int N = in.nextInt();
        int[] test = new int[N];
        // 输入一个数组
        for (int i = 0; i < N; i++) {
            if (in.hasNextInt()) {
                test[i] = in.nextInt();
            }
        }
        bubbleSort(test);
        System.out.println(Arrays.toString(test));
    }
}