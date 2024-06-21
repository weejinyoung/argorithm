package 유레카.a0621combsubs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15652 {

    static int N, M;
    static int[] arr;
    static int[] result;
    //static boolean[] visited;

    static void comb(int cnt, int start) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }
        for(int i = start; i < N; i++) {
            //if(visited[i]) continue;
            //visited[i] = true;
            result[cnt] = arr[i];
            comb(cnt + 1, i);
            //visited[i] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        //visited = new boolean[N];
        result = new int[M];
        comb(0, 0);
    }
}



