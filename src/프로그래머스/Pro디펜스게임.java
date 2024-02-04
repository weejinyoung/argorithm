package 프로그래머스;

import java.util.*;

class Pro디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if (k == enemy.length) {
            return enemy.length;
        }

        int count = 0;
        int remain = n;
        int i;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
        for (i = 0; i < enemy.length; i++) {
            int current = enemy[i];
            pq.add(current);
            remain -= current;

            if (remain < 0) {
                if (count < k) {
                    remain += pq.poll();
                    count++;
                } else {
                    break;
                }
            }
        }

        answer = i;

        return answer;
    }
}