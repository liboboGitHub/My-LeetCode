import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Offer113 {
    // 记录后续遍历结果
    List<Integer> postOrder = new ArrayList<>();
    boolean[] visited; // 防止重复遍历一个节点
    boolean[] curPath; // 记录当前路径
    boolean cycle = false; // 记录是否存在环

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        curPath = new boolean[numCourses];
        // 遍历每个课程
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        if (cycle) {
            return new int[]{};
        }

        // 无环图的后序遍历结果的反转就是该图的拓扑排序的顺序
        Collections.reverse(postOrder); // 反转集合
        int[] res = new int[numCourses];
        for (int i = 0; i < res.length; i++) {
            res[i] = postOrder.get(i);
        }
        return res;

    }


    // 从curNode节点开始DFS遍历
    private void traverse(List<Integer>[] graph, int curNode) {
        // 递归出口1：出现环
        if (curPath[curNode]) {
            cycle = true;
            return;
        }
        // 递归出口2：如果当前节点已经被遍历过了
        if (visited[curNode]) {
            return;
        }
        visited[curNode] = true;
        //类似于回溯，这里维护curPath, 如果以当前节点作为起始节点，出现环的必然不会走到curPath[curNode] = false这行代码
        curPath[curNode] = true;
        for (int j : graph[curNode]) {
            traverse(graph, j);
        }

        // 后序位置
        postOrder.add(curNode);
        curPath[curNode] = false;
    }

    // 根据题目要求构建图（使用领接表）
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
}
