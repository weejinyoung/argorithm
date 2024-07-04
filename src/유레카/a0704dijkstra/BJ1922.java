package 유레카.a0704dijkstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<int[]>[] g = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            g[from].add(new int[]{to, cost});
            g[to].add(new int[]{from, cost});
        }
        boolean[] visited = new boolean[N + 1];
        int sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();

            int node = edge[0];
            int cost = edge[1];

            if (visited[node]) continue;
            visited[node] = true;
            sum += cost;
            System.out.println("neighbor " + node + " cost " + sum);

            for (int[] neighbor : g[node]) {
                if (!visited[neighbor[0]]) {
                    pq.offer(neighbor);
                }
            }
        }

        System.out.println(sum);
    }
}
