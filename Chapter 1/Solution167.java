public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        // 左右指针（具有顺序的数组）
        int left = 0, right = numbers.length - 1;
        // TODO:为什么是 < ,而不是<= ?  题目中要求：不可以重复使用相同的元素。
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
