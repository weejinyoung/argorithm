package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfWriting1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int cnt = 1;
        int len = 10;

        for (int i = 1; i <= N; i++) {
            if (i == len) {
                len *= 10;
                cnt++;
            }
            answer += cnt;
        }
        System.out.println(answer);

    }
}
