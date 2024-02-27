package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준거스름돈 {

    private static int[] dp;

    private static int findAnswer(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n == 0) {
            return 0;
        }
        return dp[n] = 1 + Math.min(findAnswer(n-2), findAnswer(n-5));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 5) {
            if (n == 1 || n == 3) {
                System.out.println(-1);
            }
            if (n == 2 || n == 5) {
                System.out.println(1);
            }
            if (n == 4) {
                System.out.println(2);
            }
            return;
        }
        dp = new int[n+1];
        dp[1] = Integer.MAX_VALUE;
        dp[2] = 1;
        dp[3] = Integer.MAX_VALUE;
        dp[4] = 2;
        dp[5] = 1;
        System.out.println(findAnswer(n));
    }
}
