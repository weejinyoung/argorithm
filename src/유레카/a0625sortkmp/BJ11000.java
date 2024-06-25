package 유레카.a0625sortkmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        // 강의 시작 시간으로 오름차순 정렬하는데 만약 시작시간이 같다면 종료시간이 더 빠른 강의 순으로 오름차순 정렬한다
        Arrays.sort(input, (o1, o2) -> o1[0] == o2[0] ?  Integer.compare(o2[1], o1[1]) : Integer.compare(o2[0], o1[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(input[0][1]);

        for (int i = 1; i < input.length; i++) {
            if (input[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(input[i][1]);
        }

        System.out.println(pq.size());
    }
}
