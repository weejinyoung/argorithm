import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PuttingNumberOnComplex {

    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }

        bfs();
        System.out.println(answer.size());
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println(integer);
        }

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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    int sum = 1;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        List<int[]> neighbors = getNeighbors(current);

                        for(int[] neighbor : neighbors) {
                            if (!visited[neighbor[0]][neighbor[1]] && graph[neighbor[0]][neighbor[1]] == 1) {
                                queue.add(neighbor);
                                visited[neighbor[0]][neighbor[1]] = true;
                                sum++;
                            }
                        }
                    }
                    answer.add(sum);
                }
            }
        }

    }
}