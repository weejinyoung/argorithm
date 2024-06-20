package 아직미분류;

import java.util.LinkedList;
import java.util.Queue;

class MakesSumOfTwoQueuesEqual {
    public long solution(int[] queue1, int[] queue2) {
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        long queue1Sum = 0;
        long queue2Sum = 0;

        for (int i = 0; i < queue1.length; i++) {
            queue1Sum += queue1[i];
            queue2Sum += queue2[i];
            queueA.add(queue1[i]);
            queueB.add(queue2[i]);
        }

        long time = 0;

        while (true) {
            if (time >= 600000 || queueA.isEmpty() || queueB.isEmpty()) {
                return -1;
            }
            if (queue1Sum == queue2Sum) {
                return time;
            } else if (queue1Sum > queue2Sum) {
                int polled = queueA.poll();
                queueB.add(polled);
                queue1Sum = queue1Sum - polled;
                queue2Sum = queue2Sum + polled;
            } else {
                int polled = queueB.poll();
                queueA.add(polled);
                queue1Sum = queue1Sum + polled;
                queue2Sum = queue2Sum - polled;
            }
            time++;
        }

    }
}