import java.util.*;

public class Solution752 {

    // 往上转动
    public String up(String s, int index) {
        char[] ch = s.toCharArray();
        if (ch[index] == '9') {
            ch[index] = '0';
        } else {
            ch[index] += 1;
        }
        return new String(ch);
    }

    // 往下转动
    public String down(String s, int index) {
        char[] ch = s.toCharArray();
        if (ch[index] == '0') {
            ch[index] = '9';
        } else {
            ch[index] -= 1;
        }
        return new String(ch);
    }


    public int openLock(String[] deadends, String target) {
        // 将题目中的字符串数组转换为集合形式，方便后面调用集合的方法，推荐使用
        Set<String> dead = new HashSet<>();
        Collections.addAll(dead, deadends);
        // 避免重复
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;

        // BFS 框架
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 判断是否包含死亡数字
                String cur = queue.poll();
                if (dead.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                // 添加下一次转动的情况
                for (int j = 0; j < 4; j++) {
                    String up = up(cur, j);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }
                    String down = down(cur, j);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }
            step++; // 注意位置，这里才真正选择了一次
        }
        return -1;
    }
}
