package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class 아직미분류.Coin1 {
//
//    static int[] coin;
//    static int[] dp;
//    static boolean[][] visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        coin = new int[n];
//        dp = new int[k+1];
//        dp[0] = 1;
//        visited = new boolean[k+1][n];
//
//        for (int t = 0; t < n; t++) {
//            coin[t] = Integer.parseInt(br.readLine());
//        }
//
//        for (int i = 1; i <= k; i++) {
//            for (int j = 0; j < n; j++) {
//                if (coin[j] <= i && ) {
//                    System.out.println(i + " 의 가치를 채우기 위해 " + (i - coin[j]) + "의 가치를 채우는 방법의 수를 더합니다 더한 값는 " + dp[i - coin[j]]);
//                    dp[i] += dp[i - coin[j]];
//                }
//            }
//        }
//
//        System.out.println(dp[k]);
//
//    }
//}


public class Coin1 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;

        for(int i = 1 ; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= k; j++)
                dp[j] += dp[j - arr[i]];
        }

        System.out.println(dp[k]);
    }

}
