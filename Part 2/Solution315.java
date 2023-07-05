import java.util.LinkedList;
import java.util.List;

public class Solution315 {

    // 要计算某个元素后面比它小的个数，实际上可以统计在归并排序过程中，从它的右侧转移到它左侧的元素的个数。
    public class Pair {
        int id;
        int value;

        public Pair(int value, int id) {
            this.value = value;
            this.id = id;
        }
    }

    // 归并排序的辅助数组
    public Pair[] temp;

    // 记录结果数组
    public int[] count;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int n = nums.length;
        temp = new Pair[n];
        count = new int[n];
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        sort(arr, 0, n - 1);
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void sort(Pair[] nums, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(Pair[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == high + 1) {
                nums[k] = temp[i++];
                count[nums[k].id] += j - mid - 1;
            } else if (temp[i].value > temp[j].value) {
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
                count[nums[k].id] += j - mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution315 solution315 = new Solution315();
        int[] nums = {5, 2, 6, 1};
        solution315.countSmaller(nums);
    }
}
