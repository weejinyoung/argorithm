package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준쉬운최단거리 {

    private static int[][] graph;
    private static int n;
    private static int m;

    private static List<int[]> getNeighbors(int[] target) {
        List<int[]> neighbors = new ArrayList<>();
        if (target[0] != 0) {
            neighbors.add(new int[]{target[0] - 1, target[1]});
        }
        if (target[0] != n - 1) {
            neighbors.add(new int[]{target[0] + 1, target[1]});
        }
        if (target[1] != 0) {
            neighbors.add(new int[]{target[0], target[1] - 1});
        }
        if (target[1] != m - 1) {
            neighbors.add(new int[]{target[0], target[1] + 1});
        }
        return neighbors;
    }

    private static void bfs(int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(target);
        visited[target[0]][target[1]] = true;
        graph[target[0]][target[1]] = 0;
        int depth = 1;

        while (!queue.isEmpty()) {
            int depthSize = queue.size();
            for (int i = 0; i < depthSize; i++) {
                int[] current = queue.poll();
                List<int[]> neighbors = getNeighbors(current);
                for (int[] neighbor : neighbors) {
                    if (!visited[neighbor[0]][neighbor[1]] && graph[neighbor[0]][neighbor[1]] != 0) {
                        queue.add(neighbor);
                        visited[neighbor[0]][neighbor[1]] = true;
                        graph[neighbor[0]][neighbor[1]] = depth;
                    }
                }
            }
            depth++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        int[] target = {0,0};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input == 1 ? -1 : input;
                if (graph[i][j] == 2) {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }
        bfs(target);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
