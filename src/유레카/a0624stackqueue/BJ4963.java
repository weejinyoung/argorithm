package 유레카.a0624stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4963 {

    static final int[] di = {-1, -1, 0, 1, 1, 1, 0, -1}; // 시계방향
    static final int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int w, h;

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int d = 0; d < 8; d++) {
                int ni = current[0] + di[d];
                int nj = current[1] + dj[d];
                if (0 <= ni && ni < h && 0 <= nj && nj < w && !visited[ni][nj] && map[ni][nj] == 1) {
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int d = 0; d < 8; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < h && 0 <= nj && nj < w && !visited[ni][nj] && map[ni][nj] == 1) {
                dfs(ni, nj);
            }
        }
    }

    static int getAnswer() {
        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    answer++;
                    dfs(i, j);
//                    bfs(i, j);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer.append(getAnswer()).append("\n");
        }
        answer.deleteCharAt(answer.length() - 1);
        System.out.println(answer);
    }
}
