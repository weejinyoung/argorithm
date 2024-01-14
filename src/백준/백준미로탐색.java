package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준미로탐색 {

    private static int[][] graph;
    private static int N;
    private static int M;

    private static List<int[]> getNeighbors(int[] current) {
        List<int[]> neighbor = new ArrayList<>();
        if (current[0] != 0) {
            neighbor.add(new int[]{current[0] - 1, current[1]});
        }
        if (current[0] != N - 1) {
            neighbor.add(new int[]{current[0] + 1, current[1]});
        }
        if (current[1] != 0) {
            neighbor.add(new int[]{current[0], current[1] - 1});
        }
        if (current[1] != M - 1) {
            neighbor.add(new int[]{current[0], current[1] + 1});
        }
        return neighbor;
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int depth = 1;
        queue.add(new int[]{0,0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                List<int[]> neighbors = getNeighbors(current);

                for (int[] neighbor : neighbors) {
                    if (!visited[neighbor[0]][neighbor[1]] && graph[neighbor[0]][neighbor[1]] == 1) {
                        if (neighbor[0] == N - 1 && neighbor[1] == M - 1) {
                            return depth + 1;
                        }
                        queue.add(neighbor);
                        visited[neighbor[0]][neighbor[1]] = true;
                    }
                }
            }
            depth++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }

        System.out.println(bfs());
    }
}
