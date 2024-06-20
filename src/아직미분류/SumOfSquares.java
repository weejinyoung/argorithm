package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSquares {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            double squareRoot = Math.sqrt(i);
            if (squareRoot == (int) squareRoot) {
                dp[i] = 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; (2*j) <= i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        System.out.println(dp[N]);
    }


}
