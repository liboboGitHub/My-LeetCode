public class InsertionSort {

    /**
     * 插入排序（核心：找到当前元素的插入的位置：前面的元素都小于等于它）
     * 稳定性：稳定
     * 时间复杂度：最佳：O(n) ，最差：O(n^2)， 平均：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 默认第一个元素已经拍好序了
            int preIndex = i - 1;
            int cur = nums[i];
            while (preIndex >= 0 && cur < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = cur;
        }
        return nums;
    }
}
