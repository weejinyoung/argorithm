package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준숨바꼭질 {

    public static void main(String[] args) throws IOException {
        int MAX = 200000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[MAX];
        int[] count = new int[MAX];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        isVisited[N] = true;
        count[K] = 0;

        while (!queue.isEmpty()) {
            int current = queue.remove();

            if (current + 1 < MAX) {
                if (!isVisited[current + 1]) {
                    queue.add(current + 1);
                    isVisited[current + 1] = true;
                    count[current + 1] = count[current] + 1;
                }
            }

            if (current - 1 >= 0) {
                if (!isVisited[current - 1]) {
                    queue.add(current - 1);
                    isVisited[current - 1] = true;
                    count[current - 1] = count[current] + 1;
                }
            }

            if (current * 2 < MAX) {
                if (!isVisited[current * 2]) {
                    queue.add(2 * current);
                    isVisited[current * 2] = true;
                    count[2 * current] = count[current] + 1;
                }
            }
        }

        System.out.println(count[K]);
    }
}
