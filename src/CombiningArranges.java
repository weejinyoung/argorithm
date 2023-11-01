import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombiningArranges {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            B[j] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int l = 0;
        int r = 0;
        while (true) {
            if (l == N) {
                for (int k = r; k < M; k++) {
                    sb.append(B[k]).append(" ");
                }
                break;
            } else if (r == M) {
                for (int t = l; t < N; t++) {
                    sb.append(A[t]).append(" ");
                }
                break;
            } else {
                if (A[l] >= B[r]) {
                    sb.append(B[r]).append(" ");
                    r++;
                } else {
                    sb.append(A[l]).append(" ");
                    l++;
                }
            }
        }

        System.out.println(sb);
    }
}
