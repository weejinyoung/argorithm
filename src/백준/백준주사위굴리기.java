package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준주사위굴리기 {

    private static int N, M, x, y, K;
    private static int[] orders;
    private static int[][] map;
    private static StringBuilder sb = new StringBuilder();

    // 동0 서1 남2 북3 위4 아래5
    private static int[] dice = new int[6];

    private static boolean isEnd(int order) {
        if (order == 1 && y == M - 1) {
            return true;
        }
        if (order == 2 && y == 0) {
            return true;
        }
        if (order == 3 && x == 0) {
            return true;
        }
        if (order == 4 && x == N -1) {
            return true;
        }
        return false;
    }

    private static void roll(int order) {
        int east = dice[0];
        int west = dice[1];
        int south = dice[2];
        int north = dice[3];
        int up = dice[4];
        int down = dice[5];
        switch (order) {
            case 1 : {
                dice[0] = up;
                dice[1] = down;
                dice[4] = west;
                dice[5] = east;
                if (map[x][y + 1] == 0) {
                    map[x][y + 1] = dice[5];
                } else {
                    dice[5] = map[x][y + 1];
                    map[x][y + 1] = 0;
                }
                y++;
                break;
            }
            case 2 : {
                dice[0] = down;
                dice[1] = up;
                dice[4] = east;
                dice[5] = west;
                if (map[x][y - 1] == 0) {
                    map[x][y - 1] = dice[5];
                } else {
                    dice[5] = map[x][y - 1];
                    map[x][y - 1] = 0;
                }
                y--;
                break;
            }
            case 3 : {
                dice[2] = down;
                dice[3] = up;
                dice[4] = south;
                dice[5] = north;
                if (map[x - 1][y] == 0) {
                    map[x - 1][y] = dice[5];
                } else {
                    dice[5] = map[x - 1][y];
                    map[x - 1][y] = 0;
                }
                x--;
                break;
            }
            case 4 : {
                dice[2] = up;
                dice[3] = down;
                dice[4] = north;
                dice[5] = south;
                if (map[x + 1][y] == 0) {
                    map[x + 1][y] = dice[5];
                } else {
                    dice[5] = map[x + 1][y];
                    map[x + 1][y] = 0;
                }
                x++;
            }
        }
    }

    private static void findAnswer() {
        for (int order : orders) {
            if (!isEnd(order)) {
                roll(order);
                sb.append(dice[4]).append("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        orders = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        findAnswer();

        System.out.println(sb);
    }
}
