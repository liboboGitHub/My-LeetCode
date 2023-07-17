import java.util.HashMap;

public class Solution659 {
    public boolean isPossible(int[] nums) {
        // 每个元素出现的次数，辅助子序列
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();
        // 初始化freq
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            // 是否加到当前序列的后面
            if (need.containsKey(num) && need.get(num) > 0) {
                freq.put(num, freq.get(num) - 1);
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            }
            // 能否重新起一个序列
            else if (freq.containsKey(num) && freq.get(num) > 0 && freq.containsKey(num + 1) && freq.get(num + 1) > 0 &&
                    freq.containsKey(num + 2) && freq.get(num + 2) > 0) {
                freq.put(num, freq.get(num) - 1);
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
