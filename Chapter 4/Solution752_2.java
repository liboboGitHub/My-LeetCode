import java.util.*;

public class Solution752_2 {
    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>();
        Collections.addAll(deadend, deadends);
        Set<String> visited = new HashSet<>(); // 防止走回头路
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // 判断是否满足要求
                if (cur.equals(target)) {
                    return step;
                }
                if (deadend.contains(cur)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String u = up(cur, j);
                    if (!visited.contains(u)) {
                        queue.offer(u);
                        visited.add(u);
                    }
                    String d = down(cur, j);
                    if (!visited.contains(d)) {
                        queue.offer(d);
                        visited.add(d);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 向下转动
    private String down(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '0') {  // 特殊情况
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    // 向上转动
    private String up(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '9') {  // 特殊情况
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }
}
