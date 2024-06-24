package 유레카.a0624stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BfsDfsDepth {

    static final int[] di = {-1, 0, 1, 0}; // 상우하좌
    static final int[] dj = {0, 1, 0, -1};
    static int N = 5, C = 0;
    static int[][] a;
    static boolean[][] v;

    static void dfs(int i, int j, int depth) {
        v[i][j] = true;
        a[i][j] = C++;
        for(int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
                dfs(ni, nj, depth + 1);
            }
        }
    }

//    static void bfs(int i, int j, int depth) {
//        ArrayDeque<int[]> q = new ArrayDeque<>();
//        v[i][j] = true;
//        q.offer(new int[]{i, j, depth});
//        while (!q.isEmpty()) {
//            int[] ij = q.poll();
//            i = ij[0];
//            j = ij[1];
//            a[i][j] = C++;
//            for (int d = 0; d < 4; d++) {
//                int ni = i + di[d];
//                int nj = j + dj[d];
//                if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
//                    v[ni][nj] = true;
//                    q.offer(new int[]{ni, nj, depth + 1});
//                }
//            }
//        }
//    }

    static void bfs(int i, int j, int depth) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i, j, depth});
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            a[i][j] = C++;
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
                    v[ni][nj] = true;
                    q.offer(new int[]{ni, nj, depth + 1});
                }
            }
        }
    }


    public static void main(String[] args) {
        C = 1;
        a = new int[N][N];
        v = new boolean[N][N];
        dfs(N / 2, N / 2, 0);
//        bfs(N / 2, N / 2);
        for (int[] b : a) {
            System.out.println(Arrays.toString(b));
        }

    }
}
