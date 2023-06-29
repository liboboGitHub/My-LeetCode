import java.util.*;

public class Solution773 {
    public int slidingPuzzle(int[][] board) {
        // 基本思路： BFS
        int m = board.length, n = board[0].length;
        StringBuilder sb = new StringBuilder(); // 存储某种“状态”
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        // 将二维数组变成一维数组，然后存储一维数组对应下标的数字在二维数组中的相邻元素在当前一维数组中的索引
        int[][] indexNeighbor = neighbors(board);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        String start = sb.toString(), target = "123450";
        int step = 0;

        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                // 寻找0的位置
                int index = 0;
                while (cur.charAt(index) != '0') {
                    index++;
                }
                // 变换0的相邻元素
                for (int neighbor : indexNeighbor[index]) {
                    // 交换0与相邻元素
                    String newCur = Swap(neighbor, index, cur.toCharArray());
                    if (!visited.contains(newCur)) {
                        queue.offer(newCur);
                        visited.add(newCur);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String Swap(int neighbor, int index, char[] charArray) {
        char temp = charArray[index];
        charArray[index] = charArray[neighbor];
        charArray[neighbor] = temp;
        return new String(charArray);
    }


    private int[][] neighbors(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] indexNeighbor = new int[m * n][];
        for (int i = 0; i < m * n; i++) {
            List<Integer> list = new ArrayList<>();
            // 当前元素不是第一列元素，则把左邻居加入
            if (i % n != 0) {
                list.add(i - 1);
            }
            // 当前元素不是最后一列元素，则把右邻居加入
            if (i % n != n - 1) {
                list.add(i + 1);
            }
            // 当前元素不是第一行元素，将上邻居加入
            if (i - n >= 0) {
                list.add(i - n);
            }
            // 当前元素不是最后一行元素，将下邻居加入
            if (i + n < m * n) {
                list.add(i + n);
            }
            // Java 语言特性，将 List 类型转为 int[] 数组 (这步基本上想不到）
            indexNeighbor[i] = list.stream().mapToInt(Integer::intValue).toArray();
        }

        return indexNeighbor;
    }
}
