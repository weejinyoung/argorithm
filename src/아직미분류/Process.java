package 아직미분류;

import java.util.*;

class Process {

    public int solution(int[] priorities, int location) {

        Map<Integer, Integer> processMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            processMap.put(i, priorities[i]);
            pq.add(priorities[i]);
            q.add(i);
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            if (!processMap.get(current).equals(pq.peek())) {
                q.add(current);
            } else {
                pq.poll();
                answer.add(current);
            }
        }

        return (answer.indexOf(location) + 1);
    }
}
