package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DfsBfs {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수
        int N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());
        // 탐색을 시작할 정점의 번호
        int V = Integer.parseInt(st.nextToken());

        int[][] edges = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int i = 1 ; i <= N ; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(graph, V);
        bfs(graph, V);
    }

    static void dfs(Map<Integer, ArrayList<Integer>> graph, int start) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(start);
        visited.add(start);
        answer.append(start).append(" ");

        while (!stack.isEmpty()) {

            int current = stack.peek();
            boolean hasNeighbor = false;
            ArrayList<Integer> neighbors = graph.get(current);
            Collections.sort(neighbors);

            for(int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    hasNeighbor = true;
                    stack.push(neighbor);
                    visited.add(neighbor);
                    answer.append(neighbor).append(" ");
                    break;
                }
            }

            if(!hasNeighbor) {
                stack.pop();
            }
        }

        System.out.println(answer);
    }

    static void bfs(Map<Integer, ArrayList<Integer>> graph, int start) {
        StringBuilder answer = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        answer.append(start).append(" ");

        while (!queue.isEmpty()) {

            int current = queue.poll();
            ArrayList<Integer> neighbors = graph.get(current);
            Collections.sort(neighbors);

            for(int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    answer.append(neighbor).append(" ");
                }
            }
        }

        System.out.println(answer);

    }
}
