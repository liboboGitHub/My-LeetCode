public class SelectionSort {

    /**
     * 选择排序（核心：每一轮都寻找最小的元素，放在已排序的
     * 稳定性：不稳定
     * 时间复杂度：最佳：O(n^2) ，最差：O(n^2)， 平均：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        return nums;
    }
}
