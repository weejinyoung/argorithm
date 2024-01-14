package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준도영이가만든맛있는음식 {

    private static int[][] ingredients;
    private static int N;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] visited;

    private static void backtracking(int depth) {
        if (depth == N) {
            int sour = 1;
            int bitter = 0;
            int cnt = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    cnt++;
                    sour *= ingredients[i][0];
                    bitter += ingredients[i][1];
                }
            }
            if(cnt == 0) return;
            if(answer > Math.abs(sour - bitter))
                answer = Math.abs(sour - bitter);
            return;
        }
        visited[depth] = true;
        backtracking(depth + 1);
        visited[depth] = false;
        backtracking(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ingredients = new int[N][2];
        visited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                ingredients[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0);
        System.out.println(answer);
    }
}
