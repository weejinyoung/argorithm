package 유레카.a0704dijkstra;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class PrimMain1 {

    static int N;
    static List<Integer>[] g;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("~/study/argorithm/src/유레카/a0703prim/input_prim.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int[]>[] g = new List[N];for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int c = sc.nextInt();
                if(c!=0) g[i].add(new int[] {j, c}); // 인접정점번호, 비용
            }
        }
        boolean[] v = new boolean[N];
        int[] minEdge = new int[N];
        for(int i = 0; i < N; i++) minEdge[i] = Integer.MAX_VALUE;

        int sum = 0, cnt = 0;
        minEdge[0] = 0;
        System.out.println(Arrays.toString(minEdge));
        System.out.println();
        for (int i = 0; i < N; i++) {
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (!v[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j;
                }
            }
            v[minVertex] = true;
            sum += min;
            System.out.println(Arrays.toString(v));
            System.out.println("minVertex=" + minVertex);
            System.out.println("min=" + min + " sum=" + sum);
            if(cnt++ == N-1) break;

            for (int[] j : g[minVertex]) {
                if (!v[j[0]] && minEdge[j[0]] > j[1]) {
                    minEdge[j[0]] = j[1];
                }
            }
            System.out.println(Arrays.toString(minEdge));
            System.out.println();
        }
        System.out.println(sum);
        sc.close();
    }

}

