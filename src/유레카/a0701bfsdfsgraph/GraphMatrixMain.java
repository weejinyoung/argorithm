package 유레카.a0701bfsdfsgraph;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

public class GraphMatrixMain {

    static int N;
    static int[][] g;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/a0701bfsdfsgraph"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int E = sc.nextInt();
        g = new int[N][N];
        v = new boolean[N];
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from][to] = 1;
            g[to][from] = 1;
        }
        dfs(0);
        sc.close();
    }

    static void bfs(int i) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            i = q.poll();
            for (int j = 0; j < N; j++) {
                if (g[i][j] != 0 && !v[j]) {
                    v[j] = true;
                    q.offer(j);
                }
            }

        }
    }

    private static void dfs(int i) {
        v[i] = true;
        System.out.print((char) (i + 'A') + " ");
        for (int j = N - 1; j >= 0; j--) {
            if (g[i][j] != 0 && !v[j]) {
                dfs(j);
            }
        }
    }
}
