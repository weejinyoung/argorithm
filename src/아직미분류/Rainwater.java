package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rainwater {

    static int[][] blocks;
    static int H;
    static int W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        blocks = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            stackBlock(i, Integer.parseInt(st.nextToken()));
        }

        for (int i = H - 1; i >= 0; i--) {

        }


    }

    private static void stackBlock(int x, int num) {
        for (int i = W - 1; i > W - num; i--) {
            blocks[i][x] = 1;
        }
    }



}
