package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] coins = new long[n + 1];
        long[] dp = new long[k + 1];

        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] > 0 && coins[i] <= k) {
                dp[(int) coins[i]] = 1;
            }
        }

        for (int i = 1; i <= k; i++) {
            if (dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE ) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}
