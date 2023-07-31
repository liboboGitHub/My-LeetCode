import java.util.ArrayList;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        // 使用二分思想
        int m = s.length(), n = t.length();
        // 存储t中的每个字符的索引列表
        ArrayList<Integer>[] indexs = new ArrayList[256];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (indexs[c] == null) {
                indexs[c] = new ArrayList<>();
            }
            indexs[c].add(i);
        }

        // 遍历字符串s
        int j = 0; // 字符串t的指针
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (indexs[c] == null) {
                return false;
            }
            int pos = leftB(indexs[c], j);
            if (pos == -1) {
                return false;
            }
            j = indexs[c].get(pos) + 1;
        }
        return true;
    }

    // 搜索左侧边界的二分搜索
    private int leftB(ArrayList<Integer> index, int target) {
        int left = 0, right = index.size(); // 注意这个写法，不是right = index.size() - 1
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (target > index.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;  // 搜索左侧边界的二分搜索的关键之处
            }
        }
        if (left == index.size()) {
            return -1;
        }
        return left;
    }
}
