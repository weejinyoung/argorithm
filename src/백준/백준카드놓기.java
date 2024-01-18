package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 백준카드놓기 {

    private static String[] cards;
    private static String[] arr;
    private static boolean[] visited;
    private static Set<String> results = new HashSet<>();
    private static int n, k;

    private static void backtracking(int start, int depth) {
        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(arr[i]);
            }
            results.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                arr[depth] = cards[i];
                visited[i] = true;
                backtracking(start + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new String[n];
        arr = new String[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }
        backtracking(0,0);
        System.out.println(results.size());
    }
}
