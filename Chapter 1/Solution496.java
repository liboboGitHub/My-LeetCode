import java.util.HashMap;
import java.util.Stack;

public class Solution496 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        // 倒着入栈（为什么？因为要求的是当前元素的后面第一个大元素，顺着入栈，只能看到前面的信息，看不到后面的信息
        for (int i = nums.length - 1; i >= 0; i--) {
            // 当前元素后面小于等于它的值出栈，这些值没用
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                res[i] = s.peek();
            } else {
                res[i] = -1;
            }
            s.push(nums[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterNums2 = new int[nums2.length];
        nextGreaterNums2 = nextGreaterElements(nums2);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(nums2[i], nextGreaterNums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }
}
