package 유레카.a0627greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {

    static int[][] map;
    static int white = 0;
    static int blue = 0;

    static void countPaper() {

    }

    static boolean search(int standardI, int standardJ, int length) {
        int standard = map[standardI][standardJ];
        for (int i = standardI; i < standardI + length; i++) {
            for (int j = standardJ; j < standardJ + length; j++) {
                if(map[i][j] != standard) return false;
            }
        }
        if (standard == 1) blue++;
        else white++;
        return true;
    }

    static void recursion(int standardI, int standardJ, int length) {
        if(length == 1) {
            if (map[standardI][standardJ] == 1) blue++;
            else white++;
            return;
        }

        if (search(standardI, standardJ, length)) return;

        recursion(standardI, standardJ, length / 2);
        recursion(standardI + (length / 2), standardJ, length / 2);
        recursion(standardI , standardJ + (length / 2), length / 2);
        recursion(standardI + (length / 2), standardJ + (length / 2), length / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
}
