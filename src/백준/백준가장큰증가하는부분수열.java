package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준가장큰증가하는부분수열 {

    private static int N;
    private static int[] A;
    private static int[] dp;

    private static int findAnswer() {
        int answer = dp[1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if(A[j] < A[i]) {
                    dp[i] = Math.max(dp[j]+A[i], dp[i]);
                    answer = Math.max(answer, dp[i]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = A[i];
        }
        System.out.println(findAnswer());
    }
}