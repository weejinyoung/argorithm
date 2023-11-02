import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNums2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int sum;
        for (int j = 0; j < N; j++) {
            sum  = arr[j];
            if (sum == M) {
                answer++;
                continue;
            }
            for (int k = j + 1; k < N; k++) {
                if (sum > M) {
                    break;
                } else {
                    sum += arr[k];
                    if (sum == M) {
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
