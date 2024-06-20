package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준입국심사 {

    private static int N, M;
    private static int[] T;

    private static int findAnswer(int start, int end) {
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int k = 0; k < N; k++) {
            T[k] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(T);
    }
}
