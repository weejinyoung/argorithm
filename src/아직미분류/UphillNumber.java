package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UphillNumber {

    static long[][] arr;

    static long findAnswer(int t) {
        for (int j = 0; j < 10; j++) {
            arr[0][j] = 1;
        }
        for (int i = 1; i < t; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    long sum = 0;
                    for (int k = 0; k < 10; k++) {
                        sum += arr[i-1][k];
                    }
                    arr[i][0] = sum;
                } else {
                    arr[i][j] = arr[i][j-1] - arr[i-1][j-1];
                }
            }
        }

        long answer = 0;
        for (int m = 0; m < 10; m++) {
            answer += arr[t-1][m];
        }

        return answer % 10007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new long[T][10];
        System.out.println(findAnswer(T));
    }
}
