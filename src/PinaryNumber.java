import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {

    static long[][] dp = new long[90][90];
    static long answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(findAnswer(N));
    }

    static long findAnswer(int N) {
        if (N == 1 || N == 2) {
            return answer;
        } else {
            for (int i = 2; N >= (2 * i) - 1; i++) {
                System.out.println((N - i) + " 이 N-i 이고 " + (i - 1) + " 이 i-1 입니다.");
                answer += combination(N - i, i - 1);
            }
        }
        return answer;
    }

    static long combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }

}
