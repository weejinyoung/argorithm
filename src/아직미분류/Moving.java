package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Moving {

    static int N;
    static int M;
    static int[][] maze;
    static int[][] mazeDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N+1][M+1];
        mazeDp = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        mazeDp[1][1] = maze[1][1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0) {
                    mazeDp[i+1][j+1] = mazeDp[i+1][j] + maze[i+1][j+1];
                    continue;
                }
                if (j == 0) {
                    mazeDp[i+1][j+1] = mazeDp[i][j+1] + maze[i+1][j+1];
                    continue;
                }
                int temp = Math.max(mazeDp[i][j+1], mazeDp[i+1][j]) + maze[i+1][j+1];
                mazeDp[i+1][j+1] = Math.max(temp, mazeDp[i][j] + maze[i+1][j+1]);
            }
        }

        System.out.println(mazeDp[N][M]);
    }
}
