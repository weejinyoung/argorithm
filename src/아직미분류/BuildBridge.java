package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuildBridge {

    // n! / r!(n-r)! 서로 다른 n개에서 r개를 선택하는 조합
    // n+1Cr+1 = nCr + nCr+1
    // nCr = n-1Cr-1 + n-1Cr
    // nC0 = nCn = 1
    static int[][] answer = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(dp(M, N)).append("\n");
        }
        System.out.println(sb);
    }

    // 서로 다른 M개에서 N개를 선택하자
    static int dp(int M, int N) {
        if (answer[M][N] > 0) {
            return answer[M][N];
        }
        if (M == N || N == 0) {
            return 1;
        }
        return answer[M][N] = dp(M-1, N-1) + dp(M-1, N);
    }
}
