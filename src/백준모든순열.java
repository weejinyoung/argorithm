import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준모든순열 {

    private static StringBuilder answer = new StringBuilder();
    private static int[] arr;
    private static boolean[] visited;
    private static int N;

    private static void backtracking(int depth) {
        // depth 가 처음 주어진 N 값이 된다면 arr 에 있는 값들을 answer 에 append
        if (depth == N) {
            System.out.println("depth 가 " + N + " 입니다.");
            for (int elmnt : arr) {
                answer.append(elmnt).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            System.out.println("i 는 " + i + " 입니다.");
            if (!visited[i]) {
                System.out.println(i + " 번째 것은 방문하지 않았네요.");
                visited[i] = true;
                arr[depth] = i + 1;
                System.out.println(depth + " 번째 값은 이제 "  + (i+1) + " 입니다.");
                backtracking(depth + 1);
                System.out.println("호출이 돌아왔습니다. 이제 " + i + " 번째 것을 미방문 처리하겠습니다.");
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N];
        backtracking(0);
        System.out.println(answer);
    }
}
