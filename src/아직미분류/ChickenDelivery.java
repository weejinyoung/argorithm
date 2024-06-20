package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChickenDelivery {

    static int[][] graph;
    static int N;
    static int M;
    static ChickenDistance chickenDistance;

    static class ChickenDistance {

        private final Map<String, Integer> chickenDistanceFromHouse;
        private final PriorityQueue<Integer> chickenDistances;

        public ChickenDistance() {
            chickenDistanceFromHouse = new HashMap<>();
            chickenDistances = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addChickenDistanceFromHouse(int chickenX, int chickenY ) {
            String coordinate = chickenX + "" + chickenY;
            chickenDistanceFromHouse.put(coordinate, 0);
        }

        public int getDistance(int houseX, int houseY, int chickenX, int chickenY) {
            int chickenDistance = chickenDistanceFromHouse.get(chickenX + "" + chickenY);
            int distanceX = Math.abs(chickenX - houseX);
            int distanceY = Math.abs(chickenY - houseY);
            return chickenDistance + (distanceX + distanceY);
        }

        public void addChickenDistanceFromHouse(int houseX, int houseY, int chickenX, int chickenY) {
            chickenDistanceFromHouse.replace(chickenX + "" + chickenY, getDistance(houseX, houseY, chickenX, chickenY));
        }

        public void shutDownChickenStore() {
            int target = chickenDistanceFromHouse.size() - M;
            for (int i = 0; i < target; i++) {
                int distance = chickenDistances.poll();
                for (String key : chickenDistanceFromHouse.keySet()) {
                    if (distance == chickenDistanceFromHouse.get(key)) {
                        chickenDistanceFromHouse.remove(key);
                    }
                }
            }
        }

        public void initChickenDistances() {
            for (String key : chickenDistanceFromHouse.keySet()) {
                chickenDistances.add(chickenDistanceFromHouse.get(key));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        chickenDistance = new ChickenDistance();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 2) {
                    chickenDistance.addChickenDistanceFromHouse(i, j);
                }
                graph[i][j] = type;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    int[] chickenStore = bfs(i, j);
                    if (chickenStore != null) {
                        chickenDistance.addChickenDistanceFromHouse(i, j, chickenStore[0], chickenStore[1]);
                    }
                }
            }
        }

        chickenDistance.initChickenDistances();
        chickenDistance.shutDownChickenStore();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    int[] chickenStore = bfs(i, j);
                    if (chickenStore != null) {
                        sum += chickenDistance.getDistance(i, j, chickenStore[0], chickenStore[1]);
                    }
                }
            }
        }

        System.out.println(sum);
    }

    private static List<int[]> getNeighbors(int[] current) {
        List<int[]> neighbors = new ArrayList<>();
        if (current[0] != 0) {
            neighbors.add(new int[]{current[0] - 1, current[1]});
        }
        if (current[0] != N - 1) {
            neighbors.add(new int[]{current[0] + 1, current[1]});
        }
        if (current[1] != 0) {
            neighbors.add(new int[]{current[0], current[1] - 1});
        }
        if (current[1] != N - 1) {
            neighbors.add(new int[]{current[0], current[1] + 1});
        }
        return neighbors;
    }

    private static int[] bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (graph[current[0]][current[1]] == 2) {
                return current;
            }
            List<int[]> neighbors = getNeighbors(current);

            for (int[] neighbor : neighbors) {
                if (!visited[neighbor[0]][neighbor[1]]) {
                    queue.add(neighbor);
                    visited[neighbor[0]][neighbor[1]] = true;
                }
            }
        }
        return null;
    }
}
