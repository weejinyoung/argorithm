import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Painting {

    static int[][] graph;
    static boolean[][] visited;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static List<int[]> getNeighbors(int[] index) {
        List<int[]> neighbor = new ArrayList<>();
        if (index[0] != 0) {
            neighbor.add(new int[]{index[0] - 1, index[1]});
        }
        if (index[0] != graph.length - 1) {
            neighbor.add(new int[]{index[0] + 1, index[1]});
        }
        if (index[1] != 0) {
            neighbor.add(new int[]{index[0], index[1] - 1});
        }
        if (index[1] != graph[0].length - 1) {
            neighbor.add(new int[]{index[0], index[1] + 1});
        }
        return neighbor;
    }

    static void bfs() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    int max = 1;
                    answer[0]++;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        List<int[]> neighbors = getNeighbors(current);

                        for(int[] neighbor : neighbors) {
                            if (!visited[neighbor[0]][neighbor[1]] && graph[neighbor[0]][neighbor[1]] == 1) {
                                queue.add(neighbor);
                                visited[neighbor[0]][neighbor[1]] = true;
                                max++;
                            }
                        }
                    }
                    answer[1] = Math.max(answer[1], max);
                }
            }
        }

    }
}
