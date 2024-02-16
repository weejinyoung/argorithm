package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준과자나눠주기 {

    private static int M, N;
    private static int[] snacks;

    private static long findAnswer() {
        long left = 1;
        long right = snacks[N-1];
        long mid;
        long result = 0;

        while (left <= right) {
            long count = 0;
            mid = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                count += snacks[i]/mid;
            }
            if (count >= M) {
                if (result < mid) {
                    result = mid;
                }
                left = mid + 1;
             } else {
                right = mid - 1;
            }

        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snacks);
        System.out.println(findAnswer());
    }
}
