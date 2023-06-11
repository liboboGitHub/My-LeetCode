import java.util.*;

public class Solution210 {

    /********************************DFS版本（拓扑排序）*******************************/
    // 记录后续遍历结果
//    List<Integer> postOrder = new ArrayList<>();
//    boolean[] visited; // 防止重复遍历一个节点
//    boolean[] curPath; // 记录当前路径
//    boolean cycle = false; // 记录是否存在环
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        // 构建图
//        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
//        visited = new boolean[numCourses];
//        curPath = new boolean[numCourses];
//        // 遍历每个课程
//        for (int i = 0; i < numCourses; i++) {
//            traverse(graph, i);
//        }
//        if (cycle) {
//            return new int[]{};
//        }
//
//        // 无环图的后序遍历结果的反转就是该图的拓扑排序的顺序
//        Collections.reverse(postOrder); // 反转集合
//        int[] res = new int[numCourses];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = postOrder.get(i);
//        }
//        return res;
//
//    }
//
//
//    // 从curNode节点开始DFS遍历
//    private void traverse(List<Integer>[] graph, int curNode) {
//        // 递归出口1：出现环
//        if (curPath[curNode]) {
//            cycle = true;
//            return;
//        }
//        // 递归出口2：如果当前节点已经被遍历过了
//        if (visited[curNode]) {
//            return;
//        }
//        visited[curNode] = true;
//        //类似于回溯，这里维护curPath, 如果以当前节点作为起始节点，出现环的必然不会走到curPath[curNode] = false这行代码
//        curPath[curNode] = true;
//        for (int j : graph[curNode]) {
//            traverse(graph, j);
//        }
//
//        // 后序位置
//        postOrder.add(curNode);
//        curPath[curNode] = false;
//    }
//
//    // 根据题目要求构建图（使用领接表）
//    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
//        List<Integer>[] graph = new List[numCourses];
//        // 初始化数组中的每个list
//        for (int i = 0; i < numCourses; i++) {
//            graph[i] = new LinkedList<>();
//        }
//        // 填充
//        for (int[] g : prerequisites) {
//            // from -> to （完成from课程后才能去完成to课程）
//            int from = g[1], to = g[0];
//            // graph[from]存储的是它的 “入度”，也即是要完成当前课程的前修课程
//            graph[from].add(to);
//        }
//        return graph;
//    }
    /********************************DFS*******************************/


    /********************************BFS版本（拓扑排序）*******************************/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 入度数组（每个节点的入度）
        int[] indegee = new int[numCourses];
        for (int[] edge : prerequisites) {
            int form = edge[1], to = edge[0];  // form -> to,from 是 to 的入度
            indegee[to]++;
        }
        // 构建队列，将入度为0的节点入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegee[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS遍历图
        int count = 0; // 记录遍历过的节点
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 重要：队列元素的出队顺序就是拓扑排序的顺序
            res[count] = cur;
            count++;
            // cur节点指向的节点的入度减一
            for (int i : graph[cur]) {
                indegee[i]--;
                // 当某个节点的入度变为0，将其加入到队列中
                if (indegee[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        if (count != numCourses) {
            return new int[]{};// 返回空数组
        }
        return res;

    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        // 初始化数组中的每个list
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        // 填充
        for (int[] g : prerequisites) {
            // from -> to （完成from课程后才能去完成to课程）
            int from = g[1], to = g[0];
            // graph[from]存储的是它的 “入度”，也即是要完成当前课程的前修课程
            graph[from].add(to);
        }
        return graph;
    }
    /********************************BFS*******************************/
}
