package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        boolean flag = false;
        while (queue.size() > 1) {
            int card = queue.poll();
            if (flag) {
                queue.add(card);
                flag = false;
            } else {
                sb.append(card).append(" ");
                flag = true;
            }
        }

        sb.append(queue.poll());

        System.out.println(sb);
    }
}
