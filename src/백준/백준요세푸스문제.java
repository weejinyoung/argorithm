package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준요세푸스문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            count++;
            if (count == K) {
                sb.append(poll).append(", ");
                count = 0;
                continue;
            }
            queue.add(poll);
        }

        System.out.println(sb.delete(sb.length()-2, sb.length()).append(">"));
    }
}
