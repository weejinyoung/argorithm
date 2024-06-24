package 유레카.a0624stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2468 {
    static final int[] di = {-1, 0, 1, 0}; // 상우하좌
    static final int[] dj = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int answer = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int N;

    static void bfs(int i, int j, int height) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int d = 0; d < 4; d++) {
                int ni = current[0] + di[d];
                int nj = current[1] + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N
                        && !visited[ni][nj] && map[ni][nj] >= height) {
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }

    static void getAnswer() {
        for (int height = min; height <= max; height++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] >= height) {
                        count++;
                        bfs(i, j, height);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                }
                if (map[i][j] < min) {
                    min = map[i][j];
                }
            }
        }
        getAnswer();
        System.out.println(answer);
    }
}
