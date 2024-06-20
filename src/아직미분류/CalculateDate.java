package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CalculateDate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        int answer;

        while (true) {
            answer = 15 * count + E;
            if ((answer - S) % 28 == 0 && (answer - M) % 19  == 0) {
                break;
            } else {
                count++;
            }
        }

        System.out.println(answer);

    }
}
