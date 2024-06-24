package 유레카.a0624stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BfsDfsMain {

    static final int[] di = {1, 0, -1, 0}; // 상우하좌
    static final int[] dj = {0, 1, 0, -1};
    static int N = 5, C = 0;
    static int[][] a;
    static boolean[][] v;

    static void dfs(int i, int j) {
        v[i][j] = true;
        a[i][j] = C++;
        for(int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            for(int[] b: a) {
                System.out.println(Arrays.toString(b));
            }
            System.out.println();

            if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
                dfs(ni, nj);
            }
        }
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            if(v[i][j]) continue;
            v[i][j] = true;
            a[i][j] = C++;
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
                    v[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }

    public static void main(String[] args) {
        C = 1;
        a = new int[N][N];
        v = new boolean[N][N];
        dfs(N / 2, N / 2);


    }
}
