import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준점프 {

    private static int N;
    private static int[][] board;
    private static long[][] dp;

    private static void makeAnswer() {
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    if (i + board[i][j] <= N) {
                        dp[i + board[i][j]][j] += dp[i][j];
                    }
                    if (j + board[i][j] <= N) {
                        dp[i][j + board[i][j]] += dp[i][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeAnswer();
        System.out.println(dp[N-1][N-1]);
    }
}
