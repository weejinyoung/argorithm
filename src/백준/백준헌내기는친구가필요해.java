package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class 백준헌내기는친구가필요해 {

    private static int N, M;
    private static String[][] graph;

    private static List<int[]> getNeighbors(int x, int y) {
        List<int[]> neighbors = new ArrayList<>();
        if (x != M - 1) {
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

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            List<int[]> neighbors = getNeighbors(current[0], current[1]);
            for (int[] neighbor : neighbors) {
                if (!visited[neighbor[0]][neighbor[1]] && !graph[neighbor[0]][neighbor[1]].equals("X")) {
                    if (graph[neighbor[0]][neighbor[1]].equals("P")) {
                        answer++;
                    }
                    queue.add(neighbor);
                    visited[neighbor[0]][neighbor[1]] = true;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[M][N];
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (input[j].equals("I")) {
                    x = j;
                    y = i;
                }
                graph[j][i] = input[j];
            }
        }
        int answer = bfs(x, y);
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }
}
