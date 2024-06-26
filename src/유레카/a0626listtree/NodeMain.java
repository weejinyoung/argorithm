package 유레카.a0626listtree;

import java.util.Scanner;

public class NodeMain {

    static class Node {
        int vertex;
        Node link;

        Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

        @Override
        public String toString() {
//            return vertex + "->" + link;
            return (char) (vertex + 'A') + vertex + "->" + link;
        }
    }

    static int N;
    static Node[] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int E = sc.nextInt();
        g = new Node[N];
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from] = new Node(to, g[from]);
            //g[to] = new Node(from, g[to]);
        }
//        for(Node n : g) System.out.println(n);
        for (int i = 0; i < N; i++) {
            for (Node j = g[i]; j != null; j = j.link) {

            }

        }
        sc.close();
    }
}
