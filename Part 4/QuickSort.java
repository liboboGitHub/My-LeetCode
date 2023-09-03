import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    /**
     * 快速排序（找到一个切分点，使得左边的都小于等于切分点，右边的都大于切分点）
     *
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums) {
        shuffer(nums); // 随机打乱数组
        sort(0, nums.length - 1, nums);
        return nums;
    }

    private static void sort(int low, int high, int[] nums) {
        if (low >= high) {
            return;
        }
        int p = position(nums, low, high); // 切分点的元素已经放到合适的位置
        sort(low, p - 1, nums);
        sort(p + 1, high, nums);
    }

    private static int position(int[] nums, int low, int high) {
        // 定义区间[low,i) <= pivot < (j,high],维护这个区间的定义
        int pivot = nums[low];
        int i = low + 1, j = high;
        while (i <= j) {
            while (i < high && nums[i] <= pivot) {  // 结束时：nums[i] > nums[pivot]
                i++;
            }
            while (j > low && nums[j] > pivot) {       // 结束时：nums[j] <= nums[pivot]
                j--;
            }
            if (i >= j) {
                break;
            }
            Swap(i, j, nums);
        }
        Swap(low, j, nums);
        return j;
    }

    private static void shuffer(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int s = i + random.nextInt(nums.length - i);
            Swap(i, s, nums);
        }
    }

    private static void Swap(int i, int s, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[s];
        nums[s] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 5, 4, 78, 59, 1, 6, 85, 42};
//        Scanner in = new Scanner(System.in);
//        // 输入数组大小
//        int N = in.nextInt();
//        int[] test = new int[N];
//        // 输入一个数组用
//        for (int i = 0; i < N; i++) {
//            if (in.hasNextInt()) {
//                test[i] = in.nextInt();
//            }
//        }
        quickSort(test);
        System.out.println(Arrays.toString(test));
    }
}
