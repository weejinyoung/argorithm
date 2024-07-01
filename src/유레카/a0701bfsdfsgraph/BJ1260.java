package 유레카.a0701bfsdfsgraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1260 {

    static int N, M, V;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] v;
    static StringBuilder answer = new StringBuilder();

    static void dfs(int i) {
        v[i] = true;
        List<Integer> neighbors = graph.get(i);
        neighbors.sort(Comparator.naturalOrder());
        for (int neighbor : neighbors) {
            if (!v[neighbor]) {
                answer.append(neighbor).append(" ");
                dfs(neighbor);
            }
        }
    }

    static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(V);
        v[V] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            List<Integer> neighbors =  graph.get(current);
            neighbors.sort(Comparator.naturalOrder());
            for (int neighbor : neighbors) {
                if (!v[neighbor]) {
                    q.offer(neighbor);
                    v[neighbor] = true;
                    answer.append(neighbor).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        v = new boolean[N + 1];
        answer.append(V).append(" ");
        dfs(V);
        System.out.println(answer);
        answer = new StringBuilder();
        answer.append(V).append(" ");
        v = new boolean[N + 1];
        bfs();
        System.out.println(answer);
    }
}
