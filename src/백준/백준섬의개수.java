package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준섬의개수 {

    static int[][] island;
    static int height;
    static int width;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            if (height == 0 && width == 0) {
                break;
            }

            island = new int[height][width];
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();
        }

        System.out.println(sb);
    }

    private static List<int[]> getNeighbors(int[] current) {
        List<int[]> neighbor = new ArrayList<>();
        int x = current[0];
        int y = current[1];
        if (x != 0) {
            neighbor.add(new int[]{x - 1, y});
        }
        if (x != height - 1) {
            neighbor.add(new int[]{x + 1, y});
        }
        if (y != 0) {
            neighbor.add(new int[]{x, y - 1});
        }
        if (y != width - 1) {
            neighbor.add(new int[]{x, y + 1});
        }
        if (x != 0 && y != 0) neighbor.add(new int[]{x - 1, y - 1}); // 왼쪽 위 대각선
        if (x != 0 && y != width - 1) neighbor.add(new int[]{x - 1, y + 1}); // 오른쪽 위 대각선
        if (x != height - 1 && y != 0) neighbor.add(new int[]{x + 1, y - 1}); // 왼쪽 아래 대각선
        if (x != height - 1 && y != width - 1) neighbor.add(new int[]{x + 1, y + 1}); // 오른쪽 아래 대각선
        return neighbor;
    }

    private static void bfs() {
        int answer = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (island[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        List<int[]> neighbors = getNeighbors(current);

                        for (int[] neighbor : neighbors) {
                            if (!visited[neighbor[0]][neighbor[1]] && island[neighbor[0]][neighbor[1]] == 1) {
                                queue.add(neighbor);
                                visited[neighbor[0]][neighbor[1]] = true;
                            }
                        }
                    }
                }
            }
        }
        sb.append(answer).append("\n");
    }
}

