package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MineCraft {

    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        int max = 256;
        int min = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] < min) {
                    min = graph[i][j];
                }
                if (graph[i][j] > max) {
                    max = graph[i][j];
                }
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        for (int i = min; i <= max; i++) {
            int blocks = B;
            int time = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k] > i) {
                        time += (graph[j][k] - i) * 2;
                        blocks += (graph[j][k] - i);
                    } else if (graph[j][k] < i){
                        time += (i - graph[j][k]);
                        blocks -= (i - graph[j][k]);
                    }
                }
            }

            if (blocks >= 0 && minTime >= time) {
                minTime = time;
                height = i;
            }
        }

        System.out.println(minTime + " " + height);

    }
}
