package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준ABCDE {

    private static int N, M;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {

        }

    }
}
