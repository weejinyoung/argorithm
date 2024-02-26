package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준인구이동 {

    private static int N, L, R;
    private static int[][] graph;
    private static boolean[][] visited;

    private static List<int[]> getNeighbors(int x, int y) {
        List<int[]> neighbors = new ArrayList<>();
        if (x != N - 1) {
            neighbors.add(new int[]{x+1, y});
        }
        if (x != 0) {
            neighbors.add(new int[]{x-1, y});
        }
        if (y != N - 1) {
            neighbors.add(new int[]{x, y+1});
        }
        if (y != 0) {
            neighbors.add(new int[]{x, y-1});
        }
        return neighbors;
    }

    private static boolean canBeCoalition(int currentX, int currentY, int neighborX, int neighborY) {
        int target = Math.abs(graph[currentX][currentY] - graph[neighborX][neighborY]);
        return !visited[neighborX][neighborY] && target >= L && target <= R;
    }

    private static void movePopulation(List<int[]> coalition) {
        int coalitionsNum = coalition.size();
        int coalitionsPopulation = 0;
        for (int[] country : coalition) {
            coalitionsPopulation += graph[country[0]][country[1]];
        }
        int resultPopulation = coalitionsPopulation / coalitionsNum;
        for (int[] country : coalition) {
            graph[country[0]][country[1]] = resultPopulation;
        }
    }

    private static int findDays() {
        int days = 0;
        while (true) {
            visited = new boolean[N][N];
            List<List<int[]>> coalitions = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[j][i]) {
                        List<int[]> candidateOfCoalition = findCandidateOfCoalitionByBfs(j, i);
                        if (candidateOfCoalition.size() != 1) {
                            coalitions.add(candidateOfCoalition);
                        }
                    }
                }
            }
            if (coalitions.isEmpty()) {
                break;
            } else {
                for (List<int[]> coalition : coalitions) {
                    movePopulation(coalition);
                }
                days++;
            }
        }
        return days;
    }

    private static List<int[]> findCandidateOfCoalitionByBfs(int x, int y) {
        List<int[]> coalition = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        coalition.add(new int[]{x,y});
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            List<int[]> neighbors = getNeighbors(current[0], current[1]);
            for (int[] neighbor : neighbors) {
                if (canBeCoalition(current[0], current[1], neighbor[0], neighbor[1])) {
                    coalition.add(new int[]{neighbor[0], neighbor[1]});
                    queue.add(neighbor);
                    visited[neighbor[0]][neighbor[1]] = true;
                }
            }
        }
        return coalition;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(findDays());
    }
}
