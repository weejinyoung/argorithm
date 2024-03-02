package 백준;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준카드합체놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            pq.add(sum);
            pq.add(sum);
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
