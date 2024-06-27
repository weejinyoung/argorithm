package 유레카.a0627greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {

    static int[][] map;
    static int white = 0;
    static int blue = 0;

    static boolean isCovered(int si, int sj, int l) {
        for (int i = si; i < si + l; i++) {
            for (int j = sj; j < sj + l; j++) {
                if (map[i][j] != map[si][sj]) return false;
            }
        }
        if (map[si][sj] == 1) blue++;
        else white++;
        return true;
    }

    static void recursion(int si, int sj, int l) {
        if (isCovered(si, sj, l)) return;
        recursion(si, sj, l / 2);
        recursion(si + (l / 2), sj, l / 2);
        recursion(si, sj + (l / 2), l / 2);
        recursion(si + (l / 2), sj + (l / 2), l / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
}

