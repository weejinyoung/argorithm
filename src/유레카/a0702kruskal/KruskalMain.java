package 유레카.a0702kruskal;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalMain {

    static int N;
    static int[][] g;
    static int[] p;

    static void make() {
        p = new int[N];
        for (int i = 0; i < N; i++) p[i] = i;
    }

    static int find(int a) {
        if(p[a] == a) return a;
        return /*p[a] =*/  find(p[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        p[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/a0702kruskal/input_kruskal.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int E = sc.nextInt();
        System.out.println(N + " " + E);
        g = new int[N][3];
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            g[i] = new int[]{from, to, cost};
        }
        Arrays.sort(g);
        make();
        int sum = 0, cnt = 0;
        for (int[] e : g) {
            if (union(e[0], e[1])) {
                sum += e[2];
                if(++cnt == N-1) break;
            }
        }
        System.out.println(sum);
        sc.close();

    }
}
