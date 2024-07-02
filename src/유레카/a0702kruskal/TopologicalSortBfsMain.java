package 유레카.a0702kruskal;

import java.io.FileInputStream;
import java.util.*;


public class TopologicalSortBfsMain {

    static int N, M;
    static List<Integer>[] g;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/a702kruskal/input_topologicalsort.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        g = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            g[i] = new ArrayList<>();
        }
        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from].add(to);
            indegree[to]++; // 진입차수
        }
        System.out.println(Arrays.toString(indegree));
        bfs();
        sc.close();
    }

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        //PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N + 1; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            System.out.println(i + " ");
            for (int j : g[i]) {
                if (--indegree[j] == 0) q.offer(j);
            }
        }
    }
}

