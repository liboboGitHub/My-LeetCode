import java.util.Arrays;
import java.util.Scanner;

/**
 * 归并排序
 * 稳定性：稳定
 * 时间复杂度：最佳：O(nlogn)， 最差：O(nlogn)， 平均：O(nlogn)
 * 空间复杂度：O(n)
 */
public class MergeSort {
    // 辅助数组：temp
    public static int[] temp;

    public static int[] mergeSort(int[] nums) {
        temp = new int[nums.length];
        sort(0, nums.length - 1, nums);
        return nums;
    }

    private static void sort(int low, int high, int[] nums) {
        if (low == high) {  // 递归出口
            return;
        }
        int mid = (high - low) / 2 + low;
        sort(low, mid, nums);
        sort(mid + 1, high, nums);
        merge(low, mid, high, nums);
    }

    private static void merge(int low, int mid, int high, int[] nums) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        // 双指针合并
        int p1 = low, p2 = mid + 1;
        for (int i = low; i <= high; i++) {
            // 此时：两边都是排好序的
            if (p1 == mid + 1) {  // 左侧的数组已经全部装到目标数组中了
                nums[i] = temp[p2++];
            } else if (p2 == high + 1) { // 右侧的数组已经全部装到目标数组中了
                nums[i] = temp[p1++];
            } else if (temp[p1] > temp[p2]) {
                nums[i] = temp[p2++];
            } else {
                nums[i] = temp[p1++];
            }
        }
    }

    public static void main(String[] args) {
        // int[] test = new int[]{1, 5, 4, 78, 59, 1, 6, 85, 42};
        Scanner in = new Scanner(System.in);
        // 输入数组大小
        int N = in.nextInt();
        int[] test = new int[N];
        // 输入一个数组用
        for (int i = 0; i < N; i++) {
            if (in.hasNextInt()) {
                test[i] = in.nextInt();
            }
        }
        mergeSort(test);
        System.out.println(Arrays.toString(test));
    }
}
