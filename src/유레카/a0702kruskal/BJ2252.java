package 유레카.a0702kruskal;

import java.util.*;
import java.io.*;
public class BJ2252 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            indegree[to]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        StringBuilder answer = new StringBuilder();

        while (!q.isEmpty()) {
            int current = q.poll();
            answer.append(current).append(" ");
            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        System.out.println(answer);
    }
}
