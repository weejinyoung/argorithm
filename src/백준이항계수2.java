import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준이항계수2 {

    private static int[][] dp;

    private static void doPascalTriangle() {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }
    }

//    private static int combination(int n, int k) {
//        if (dp[n][k] > 0) {
//            return dp[n][k];
//        }
//        if (n == k || k == 0) {
//            return 1;
//        }
//        return combination(n - 1, k) + combination(n - 1, k - 1);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        doPascalTriangle();
        System.out.println(dp[N][K] % 10007);
    }
}
