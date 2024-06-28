package 유레카.a0627greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1715 {

    // 묶음 간 결합이 일어났을 때, 해당 결합은 다음 결합에도 영향을 미친다 ex)
    // 따라서 모든 결합은 가장 작은 묶음 두개를 골라서 일어나야한다
    // 핵심, 두 카드 묶음을 하나의 묶음으로 합칠 때, 현재 가지고 있는 카드 묶음 중에서 항상 가장 작은 묶음 두개를 골라서 합쳐야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        // 마지막 묶음 하나가 남을 때까지 반복한다
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            count += first + second;
            pq.offer(first + second);
        }

        System.out.println(count);
    }
}
