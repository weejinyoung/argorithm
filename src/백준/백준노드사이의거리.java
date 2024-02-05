package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준노드사이의거리 {

    private static int N;
    private static int M;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static boolean[] visited;
    private static int[][] costs;
    private static StringBuilder sb = new StringBuilder();

    public static void dfs(int current, int end, int sum) {
        if (current == end) {
            sb.append(sum).append("\n");
            return;
        }
        visited[current] = true;
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, end, sum + costs[current][neighbor]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        costs = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            graph.get(second).add(first);
            costs[first][second] = distance;
            costs[second][first] = distance;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            dfs(start, end, 0);
        }

        System.out.println(sb);
    }
}
