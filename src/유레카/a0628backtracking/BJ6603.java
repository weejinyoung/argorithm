package 유레카.a0628backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ6603 {

    static int k;
    static int[] S;
    static int[] result;

    static void comb(int cnt, int start) {
        if (cnt == 6) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(result).forEach((o) -> sb.append(o).append(" "));
            System.out.println(sb.deleteCharAt(sb.length() - 1));
            return;
        }
        for (int i = start; i < k; i++) {
            result[cnt] = S[i];
            comb(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] inputTemp = br.readLine().split(" ");
            k = Integer.parseInt(inputTemp[0]);
            if (k == 0) break;
            S = new int[k];
            Arrays.sort(S);
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(inputTemp[i + 1]);
            }
            result = new int[6];
            comb(0, 0);
            System.out.println();
        }
    }
}
