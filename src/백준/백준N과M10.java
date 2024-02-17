package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준N과M10 {

    private static int N, M;
    private static int[] arr;
    private static int[] answer;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static void findAnswer(int depth, int start) {
        if (depth == M) {
            for (int elmnt : answer) {
                sb.append(elmnt).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = start; i < N; i++) {
            if (!visited[i] && before != arr[i]) {
                visited[i] = true;
                before = arr[i];
                answer[depth] = arr[i];
                findAnswer(depth+1, i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N ];
        answer = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        findAnswer(0, 0);
        System.out.println(sb);
    }
}
