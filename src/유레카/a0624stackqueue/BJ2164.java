package 유레카.a0624stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = N; i > 0; i--) {
            dq.add(i);
        }
        boolean flag = false;
        while (dq.size() > 1) {
            if(flag) {
                dq.offerFirst(dq.pollLast());
                flag = false;
                continue;
            }
            dq.pollLast();
            flag = true;
        }
        System.out.println(dq.getFirst());
    }
}
