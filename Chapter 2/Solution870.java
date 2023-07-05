import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 构造优先队列（最大堆形式），辅助 nums2 降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]}); // 注意：为什么要使用i? 为了记录原来的nums2的元素顺序
        }
        // nums1 升序排序
        Arrays.sort(nums1);
        int left = 0, right = n - 1; // 记录最大（right）最小（left）值
        int[] res = new int[n];
        while (!maxpq.isEmpty()) {
            int[] cur = maxpq.poll();
            int index = cur[0];
            int curMaxVal = cur[1];
            if (curMaxVal < nums1[right]) {
                res[index] = nums1[right]; // 能干过，就在对应的位置上放上nums1的最大值
                right--;
            } else {
                res[index] = nums1[left]; // 干不过，让最小值去填充
                left++;
            }
        }
        return res;

    }

}
