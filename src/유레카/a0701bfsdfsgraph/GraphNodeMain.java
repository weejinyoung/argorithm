package 유레카.a0701bfsdfsgraph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class GraphNodeMain {

    static int N;
    static Node[] g;
    static boolean[] v;

    static class Node {
        int vertex;
        Node link;
        Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
        @Override
        public String toString() {
            return vertex + "->" + link;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/a0701bfsdfsgraph"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int E = sc.nextInt();
        g = new Node[N];
        v = new boolean[N];
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from] = new Node(to, g[from]);
            g[to] = new Node(from, g[to]);
        }
        dfs(0);
        sc.close();
    }

    private static void dfs(int i) {
        v[i] = true;
        for (Node j = g[i]; j != null; j = j.link) {
            if (!v[j.vertex]) {
                dfs(j.vertex);
            }
        }
    }

    static void bfs(int i) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            i = q.poll();
            for (Node j = g[i]; j != null; j = j.link) {
                if (!v[j.vertex]) {
                    v[j.vertex] = true;
                    q.offer(j.vertex);
                }
            }
        }
    }
}
