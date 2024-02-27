package 프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro미로탈출 {

    private static String[][] map;
    private static int C, R;

    private static List<int[]> getNeighbors(int c, int r) {
        List<int[]> neighbors = new ArrayList<>();
        if (c != C - 1) {
            neighbors.add(new int[]{c + 1, r});
        }
        if (c != 0) {
            neighbors.add(new int[]{c - 1, r});
        }
        if (r != R - 1) {
            neighbors.add(new int[]{c, r+1});
        }
        if (r != 0) {
            neighbors.add(new int[]{c, r-1});
        }
        return neighbors;
    }

    private static int[] bfs(int startC, int startR, String target) {
        int[] crAndDepth = new int[3];
        boolean[][] visited = new boolean[C][R];
        Queue<int[]> queue = new LinkedList<>();
        int depth = 1;
        queue.add(new int[]{startC,startR});
        visited[startC][startR] = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                List<int[]> neighbors = getNeighbors(current[0], current[1]);

                for (int[] neighbor : neighbors) {
                    if (!visited[neighbor[0]][neighbor[1]] && !map[neighbor[0]][neighbor[1]].equals("X")) {
                        if (map[neighbor[0]][neighbor[1]].equals(target)) {
                            crAndDepth[0] = neighbor[0];
                            crAndDepth[1] = neighbor[1];
                            crAndDepth[2] = depth;
                            return crAndDepth;
                        }
                        queue.add(neighbor);
                        visited[neighbor[0]][neighbor[1]] = true;
                    }
                }
            }
            depth++;
        }
        crAndDepth[2] = -1;
        return crAndDepth;
    }

    private static int findAnswer(int startC, int startR) {
        int answer = 0;
        int[] leversCrAndDepth = bfs(startC, startR, "L");
        if (leversCrAndDepth[2] == -1) {
            return -1;
        }
        answer += leversCrAndDepth[2];
        int[] exitsCrAndDepth = bfs(leversCrAndDepth[0], leversCrAndDepth[1], "E");
        if (exitsCrAndDepth[2] == -1) {
            return -1;
        }
        answer += exitsCrAndDepth[2];
        return answer;
    }

    public static void main(String[] args) {
        String[] maps = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        C = maps.length;
        R = maps[0].length();
        map = new String[C][R];
        int startR = 0;
        int startC = 0;
        for (int i = 0; i < C; i++) {
            String[] row = maps[i].split("");
            for (int j = 0; j < R; j++) {
                if (row[j].equals("S")) {
                    startC = i;
                    startR = j;
                }
                map[i][j] = row[j];
            }
        }
        System.out.println(findAnswer(startC, startR));
    }
}
