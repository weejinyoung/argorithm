package 유레카.a0704dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrimMain {

    static int N;
    static List<Integer>[] g;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int[]>[] g = new List[N]; for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int c = sc.nextInt();
                if(c!=0) g[i].add(new int[] {j, c}); // 인접정점번호, 비용
            }
        }
        
        boolean[] v = new boolean[N];
        int[] w = new int[N];
        for(int i = 0; i < N; i++) w[i] = Integer.MAX_VALUE;

        int sum = 0, cnt = 0;
        w[0] = 0;
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            // 최소 가중치 간선 찾기
            for (int j = 0; j < N; j++) {
                if (!v[j] && min > w[j]) {
                    min = w[j];
                    minVertex = j;
                }
            }

            // 최소 가중치 간선
            v[minVertex] = true;
            sum += min;
            if(cnt++ == N-1) break;

            for (int[] j : g[minVertex]) {
                if (!v[j[0]] && w[j[0]] > j[1]) {
                    w[j[0]] = j[1];
                }
            }
        }
        System.out.println(sum);
        sc.close();
    }

}

