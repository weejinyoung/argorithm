package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MazeSearch {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;

    static List<int[]> getNeighbors(int[] index) {
        List<int[]> neighbor = new ArrayList<>();
        if (index[0] != 1) {
            neighbor.add(new int[]{index[0] - 1, index[1]});
        }
        if (index[0] != graph.length - 1) {
            neighbor.add(new int[]{index[0] + 1, index[1]});
        }
        if (index[1] != 1) {
            neighbor.add(new int[]{index[0], index[1] - 1});
        }
        if (index[1] != graph[0].length - 1) {
            neighbor.add(new int[]{index[0], index[1] + 1});
        }
        return neighbor;
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1,1});
        visited[1][1] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] current = queue.poll();
                if (N == current[0] && M == current[1]) {
                    return level;
                }
                for (int[] neighbor : getNeighbors(current)) {
                    if (graph[neighbor[0]][neighbor[1]] == 1 && !visited[neighbor[0]][neighbor[1]]) {
                        queue.add(neighbor);
                        visited[neighbor[0]][neighbor[1]] = true;
                    }
                }
            }
            level++;
        }
        return level++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1];
        graph = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(row[j - 1]);
            }
        }
        System.out.println(bfs() + 1);
    }
}
