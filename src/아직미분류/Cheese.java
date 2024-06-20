package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cheese {

    static int[][] graph;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        //List<int[]> cheeses = new ArrayList<>();
        int cheeseCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    //cheeses.add(new int[]{i, j});
                    cheeseCount++;
                }
                graph[i][j] = type;
            }
        }
        int time = 0;


        while (cheeseCount > 0) {
            time++;
            List<int[]> unsavedCheeses = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1) {
                        if (canMelt(i, j)) {
                            unsavedCheeses.add(new int[]{i, j});
                            cheeseCount--;
                        }
                    }
                }
            }
            for (int[] cheese : unsavedCheeses) {
                graph[cheese[0]][cheese[1]] = 0;
            }
        }

//
//        while (!cheeses.isEmpty()) {
//            count++;
//            List<int[]> savedCheeses = new ArrayList<>();
//            List<int[]> unsavedCheeses = new ArrayList<>();
//            for (int[] cheese : cheeses) {
//                if (!canMelt(cheese)) {
//                    savedCheeses.add(cheese);
//                } else {
//                    unsavedCheeses.add(cheese);
//                }
//            }
//            for (int[] cheese : unsavedCheeses) {
//                graph[cheese[0]][cheese[1]] = 0;
//            }
//            cheeses = savedCheeses;
//        }
        System.out.println(time);
    }

    private static boolean canMelt(int x, int y) {
        List<int[]> neighborAirs = getNeighborAirs(x, y);
        if (neighborAirs.size() >= 2) {
            return isOverThanTwoOutsideAir(neighborAirs);
        }
        return false;
    }

    private static List<int[]> getNeighborAirs(int x, int y) {
        List<int[]> neighbors = getNeighbors(x, y);
        List<int[]> airs = new ArrayList<>();
        for (int[] neighbor : neighbors) {
            if (graph[neighbor[0]][neighbor[1]] == 0) {
                airs.add(neighbor);
            }
        }
        return airs;
    }

    private static List<int[]> getNeighbors(int x, int y) {
        List<int[]> neighbors = new ArrayList<>();
        if (x != 0) {
            neighbors.add(new int[]{x - 1, y});
        }
        if (x != N - 1) {
            neighbors.add(new int[]{x + 1, y});
        }
        if (y != 0) {
            neighbors.add(new int[]{x, y - 1});
        }
        if (y != M - 1) {
            neighbors.add(new int[]{x, y + 1});
        }
        return neighbors;
    }

    private static boolean isOverThanTwoOutsideAir(List<int[]> neighborAirs) {
        int count = 0;
        for (int[] neighborAir : neighborAirs) {
            if (isOutsideAirByBfs(neighborAir[0], neighborAir[1])) {
                count++;
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOutsideAirByBfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == 0 || current[1] == 0) {
                return true;
            }
            List<int[]> neighbors = getNeighbors(current[0], current[1]);
            for (int[] neighbor : neighbors) {
                if (!visited[neighbor[0]][neighbor[1]] && graph[neighbor[0]][neighbor[1]] == 0) {
                    queue.add(neighbor);
                    visited[neighbor[0]][neighbor[1]] = true;
                }
            }
        }
        return false;
    }

}
