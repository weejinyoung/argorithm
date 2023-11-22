import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreasureIsland {

    static String[][] island;
    static int height;
    static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        island = new String[height][width];

        for (int i = 0; i < height; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < width; j++) {
                island[i][j] = row[j];
            }
        }

        System.out.println(bfs());
    }

    private static List<int[]> getNeighbors(int[] current) {
        List<int[]> neighbor = new ArrayList<>();
        if (current[0] != 0) {
            neighbor.add(new int[]{current[0] - 1, current[1]});
        }
        if (current[0] != height - 1) {
            neighbor.add(new int[]{current[0] + 1, current[1]});
        }
        if (current[1] != 0) {
            neighbor.add(new int[]{current[0], current[1] - 1});
        }
        if (current[1] != width - 1) {
            neighbor.add(new int[]{current[0], current[1] + 1});
        }
        return neighbor;
    }

    private static int bfs() {
        int maxLevel = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (island[i][j].equals("L")) {
                    boolean[][] visited = new boolean[height][width];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    int depth = 0;

                    while (!queue.isEmpty()) {
                        int levelSize = queue.size();

                        for (int k = 0; k < levelSize; k++) {
                            int[] current = queue.poll();
                            List<int[]> neighbors = getNeighbors(current);

                            for (int[] neighbor : neighbors) {
                                if (!visited[neighbor[0]][neighbor[1]] && island[neighbor[0]][neighbor[1]].equals("L")) {
                                    queue.add(neighbor);
                                    visited[neighbor[0]][neighbor[1]] = true;
                                }
                            }
                        }
                        depth++;
                    }
                    maxLevel = Math.max(maxLevel, depth);
                }
            }
        }
        return maxLevel - 1;
    }
}
