package 유레카.a0701bfsdfsgraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1189 {

    static String[][] map;
    static boolean[][] visited;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int R, C, K;
    static int answer = 0;

    static void dfs(int i, int j, int depth) {
        if (i == 0 && j == C - 1 && depth == K) {
            System.out.println(i + " " + j + " 의 목표지점에 도착했습니다 현재 depth 는 " + depth);
            answer++;
            return;
        }
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj] && !map[ni][nj].equals("T")) {
                System.out.println(ni + " " + nj + " 를 탐색합니다 현재 depth 는 " + depth);
                dfs(ni, nj, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];
            }
        }
        dfs(R - 1, 0, 1);
        System.out.println(answer);
    }
}
