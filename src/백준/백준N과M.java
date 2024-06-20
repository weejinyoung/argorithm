package 백준;

import java.io.*;
import java.util.*;

public class 백준N과M {

    private static int N;
    private static int M;
    private static int C;
    private static boolean[] visited;
    private static int[] arr;
    private static int[] result;

    private static void permutation(int n) {
        if(n == M) {
            System.out.println();
            C++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[n] = arr[i];
            permutation(n + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        result = new int[M];
        arr = new int[N];
        for(int i = 1; i <= N; i++) {
            arr[i-1] = i;
        }
        permutation(0);
    }
}
