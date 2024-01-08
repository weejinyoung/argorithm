import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준외판원순회2 {

    private static int[][] costs;
    private static int[] arr;
    private static boolean[] visited;
    private static int N;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        costs = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr = new int[N];
        visited = new boolean[N];
        backtracking(0);

        System.out.println(answer);
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                int cost = costs[arr[i - 1]][arr[i]];
                if (cost == 0) {
                    return;
                }
                sum += cost;
            }
            int returnCost = costs[arr[N - 1]][arr[0]];
            if (returnCost == 0) {
                return;
            }
            sum += returnCost;
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

}
