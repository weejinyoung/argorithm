package 유레카.a0704dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class DijkstraPQMain {

    static int N;
    static List<Integer>[] g;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int[]>[] g = new List[N]; for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int c = sc.nextInt();
                if(c!=0) g[i].add(new int[] {j, c}); // 인접정점번호, 비용
            }
        }
        
        boolean[] v = new boolean[N];
        int[] dist = new int[N];
        for(int i = 0; i < N; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[] {0,  dist[0]});
        dist[0] = 0;

        while(!pq.isEmpty()) {
            int[] vc = pq.poll();
            int minVertex = vc[0];
            int min = vc[1];

            if(v[minVertex]) continue;
            v[minVertex] = true;

            if (minVertex == N - 1) break;

            for (int[] j : g[minVertex]) {
                if (!v[j[0]] && dist[j[0]] > min + j[1]) {
                    dist[j[0]] = min + j[1];
                    pq.offer(new int[] {j[0], dist[j[0]]});
                }
            }
        }
        System.out.println(dist[N - 1]);
        sc.close();
    }

}

