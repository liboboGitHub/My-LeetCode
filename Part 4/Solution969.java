import java.util.LinkedList;
import java.util.List;

public class Solution969 {

    List<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] arr) {
        // 核心思路：1.找到当前数组最大值，翻转，最大值到最上面，再翻转，最大值到最下面，以此递归
        sort(arr, arr.length);
        return res;
    }

    private void sort(int[] arr, int length) {
        // 递归出口
        if (length == 1) {
            return;
        }
        // 寻找最大值
        int maxValue = 0, maxIndex = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        // 翻转后最大值到最上面
        traverse(arr, 0, maxIndex);
        res.add(maxIndex + 1);
        // 翻转后最大值到最下面
        traverse(arr, 0, length - 1);
        res.add(length);

        // 递归
        sort(arr, length - 1);
    }
    private void traverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
