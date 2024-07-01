package 유레카.a0701bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ2178 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new int[]{0, 0, 1});
        int answer = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int depth = current[2];
            for (int d = 0; d < 4; d++) {
                int ni = current[0] + di[d];
                int nj = current[1] + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && map[ni][nj] == 1) {
                    if (ni == N - 1 && nj == M - 1) return depth + 1;
                    q.offer(new int[] {ni, nj, depth + 1});
                    visited[ni][nj] = true;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(bfs());
    }
}
