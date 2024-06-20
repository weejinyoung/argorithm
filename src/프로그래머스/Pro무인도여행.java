package 프로그래머스;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro무인도여행 {

    private static String[] maps;
    private static String[][] maps2;
    private static boolean[][] visited;

//    private static List<int[]> getNeighbors(int[] current) {
//        List<int[]> neighbor = new ArrayList<>();
//        if (current[0] != 0) {
//            neighbor.add(new int[]{current[0] - 1, current[1]});
//        }
//        if (current[0] != height - 1) {
//            neighbor.add(new int[]{current[0] + 1, current[1]});
//        }
//        if (current[1] != 0) {
//            neighbor.add(new int[]{current[0], current[1] - 1});
//        }
//        if (current[1] != width - 1) {
//            neighbor.add(new int[]{current[0], current[1] + 1});
//        }
//        return neighbor;
//    }

    private static List<Integer> answer = new ArrayList<>();

    private static void bfs(int x, int y) {
        if (maps2[x][y] == "X") {
            return;
        }
        Queue<String> queue = new LinkedList<>();

    }

    public static void main(String[] args) {
        maps = new String[]{"X591X", "X1X5X", "X231X", "1XXX1"};
        maps2 = new String[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            String[] split = maps[i].split("");
            for (int j = 0; j < split.length; j++) {
                maps2[i][j] = split[j];
            }
        }

        visited = new boolean[maps2.length][maps2[0].length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                bfs(i, j);
            }
        }




    }
}
