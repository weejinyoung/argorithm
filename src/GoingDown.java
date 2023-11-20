import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoingDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        int[][] maxDp = new int[N][N];
        int[][] minDp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            maxDp[N-1][i] = graph[N-1][i];
            minDp[N-1][i] = graph[N-1][i];
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int maxTemp = maxDp[i+1][j];
                int minTemp = minDp[i+1][j];
                if (j != 0) {
                    maxTemp = Math.max(maxTemp, maxDp[i+1][j-1]);
                    minTemp = Math.min(minTemp, minDp[i+1][j-1]);
                }
                if (j != N - 1) {
                    maxTemp = Math.max(maxTemp, maxDp[i+1][j+1]);
                    minTemp = Math.min(minTemp, minDp[i+1][j+1]);
                }
                maxDp[i][j] = graph[i][j] + maxTemp;
                minDp[i][j] = graph[i][j] + minTemp;
            }
        }

        int maxTemp = maxDp[0][0];
        int minTemp = minDp[0][0];
        for (int i = 0; i < N; i++) {
            maxTemp = Math.max(maxTemp, maxDp[0][i]);
            minTemp = Math.min(minTemp, minDp[0][i]);
        }
        System.out.println(maxTemp + " " + minTemp);
    }
}
