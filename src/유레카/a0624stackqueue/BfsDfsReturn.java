package 유레카.a0624stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BfsDfsReturn {

    static final int[] di = {-1, 0, 1, 0}; // 상우하좌
    static final int[] dj = {0, 1, 0, -1};
    static int N = 5, C = 0;
    static int[][] a;
    static boolean[][] v;

    static int dfs(int i, int j) {
        int cnt = 1;
        v[i][j] = true;
        a[i][j] = C++;
        for(int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
                cnt += dfs(ni, nj);
            }
        }
        return cnt;
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i, j});
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
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }

    public static void main(String[] args) {
        C = 1;
        a = new int[N][N];
        v = new boolean[N][N];
//        dfs(N / 2, N / 2);
    bfs(N / 2, N / 2);
        for (int[] b : a) {
            System.out.println(Arrays.toString(b));
        }

    }
}
