package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준양 {

    // 글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대를 의미한다.
    private static String[][] garden;
    private static boolean[][] visited;
    private static int C, R, sheep, wolf;
    private static int[] sheepAndWolf;

    private static List<int[]> getNeighbors(int c, int r) {
        List<int[]> neighbors = new ArrayList<>();
        if (r != 0) {
            neighbors.add(new int[]{c, r - 1});
        }
        if (r != R - 1) {
            neighbors.add(new int[]{c, r + 1});
        }
        if (c != 0) {
            neighbors.add(new int[]{c - 1, r});
        }
        if (c != C - 1) {
            neighbors.add(new int[]{c + 1, r});
        }
        return neighbors;
    }

    private static void checkGarden(int c, int r) {
        if (garden[c][r].equals("o")) {
            sheepAndWolf[0]++;
        }
        if (garden[c][r].equals("v")) {
            sheepAndWolf[1]++;
        }
    }

    private static void battle() {
        if (sheepAndWolf[0] > sheepAndWolf[1]) {
            wolf -= sheepAndWolf[1];
        } else {
            sheep -= sheepAndWolf[0];
        }
    }


    private static void bfs(int c, int r) {
        sheepAndWolf = new int[2];
        checkGarden(c, r);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{c, r});
        visited[c][r] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            List<int[]> neighbors = getNeighbors(current[0], current[1]);
            for (int[] neighbor : neighbors) {
                if (!visited[neighbor[0]][neighbor[1]] && !garden[neighbor[0]][neighbor[1]].equals("#")) {
                    checkGarden(neighbor[0], neighbor[1]);
                    queue.add(neighbor);
                    visited[neighbor[0]][neighbor[1]] = true;
                }
            }
        }
        battle();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        garden = new String[C][R];
        visited = new boolean[C][R];
        sheep = 0;
        wolf = 0;

        for (int i = 0; i < C; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < R; j++) {
                if (row[j].equals("o")) {
                    sheep++;
                }
                if (row[j].equals("v")) {
                    wolf++;
                }
                garden[i][j] = row[j];
            }
        }

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (!garden[i][j].equals("#") && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }
}
