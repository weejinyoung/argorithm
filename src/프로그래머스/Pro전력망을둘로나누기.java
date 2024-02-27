package 프로그래머스;

import java.util.*;

public class Pro전력망을둘로나누기 {

    private static Map<String, List<String>> graph = new HashMap<>();
    private static boolean[] visited;
    private static int n;
    private static int[][] wires;

    private static int bfs(String start) {
        int sum = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited[Integer.parseInt(start)] = true;
        sum++;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String neighbor : graph.get(current)) {
                if (!visited[Integer.parseInt(neighbor)]) {
                    sum++;
                    queue.add(neighbor);
                    visited[Integer.parseInt(neighbor)] = true;
                }
            }
        }
        //System.out.println("it starts where index is " + start + " and sum is " + sum);
        return sum;
    }

    private static int findAnswer() {
        int answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            List<Integer> results = new ArrayList<>();
            graph.get(String.valueOf(wire[0])).remove(String.valueOf(wire[1]));
            graph.get(String.valueOf(wire[1])).remove(String.valueOf(wire[0]));
            visited = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    results.add(bfs(String.valueOf(i)));
                }
            }
            answer = Math.min(answer, Math.abs(results.get(0) - results.get(1)));
            graph.get(String.valueOf(wire[0])).add(String.valueOf(wire[1]));
            graph.get(String.valueOf(wire[1])).add(String.valueOf(wire[0]));
        }
        return answer;
    }

    public static void main(String[] args) {
        n = 9;
        wires = new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        for (int i = 1; i <= n; i++) {
            graph.put(String.valueOf(i), new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(String.valueOf(wire[0])).add(String.valueOf(wire[1]));
            graph.get(String.valueOf(wire[1])).add(String.valueOf(wire[0]));
        }
        System.out.println(findAnswer());
    }
}
