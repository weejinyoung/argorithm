package 프로그래머스;

import java.util.*;

public class Pro가장먼노드 {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Map<Integer, List<Integer>> depthMap = new HashMap<>();

    public int solution(int n, int[][] edges) {

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return (bfs(n));
    }

    private static void addDepthMap(int depth, int target) {
        if (!depthMap.containsKey(depth)) {
            depthMap.put(depth, new ArrayList<>());
        }
        depthMap.get(depth).add(target);
    }

    private static int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(1);
        visited[1] = true;

        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                List<Integer> neighbors = graph.get(current);
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                        addDepthMap(depth, neighbor);
                    }
                }
            }
            depth++;
        }
        return depthMap.get(depth - 2).size();
    }
}
