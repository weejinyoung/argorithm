package 유레카.a0624stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class BJ2667 {

    static final int[] di = {-1, 0, 1, 0}; // 상우하좌
    static final int[] dj = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N;

    static int bfs(int i, int j) {
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int d = 0; d < 4; d++) {
                int ni = current[0] + di[d];
                int nj = current[1] + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && map[ni][nj] == 1) {
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                    count++;
                }
            }
        }
        return count;
    }

    static int dfs(int i, int j, int cnt) {
        int sum = cnt;
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && map[ni][nj] == 1) {
                sum += dfs(ni, nj, cnt + 1);
            }
        }
        return sum;
    }

    static StringBuilder getAnswer() {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    answer.add(bfs(i, j));
//                    answer += bfs(i, j);
                }
            }
        }
        answer.sort(Integer::compare);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int element : answer) {
            sb.append(element).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(getAnswer());
    }
}
