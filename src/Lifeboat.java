import java.util.*;

class Lifeboat {
    public int solution(int[] people, int limit) {
        int boat = 0;

        Arrays.sort(people);
        List<Integer> peopleList = new ArrayList<>();

        for (int i = people.length - 1; i >= 0; i--) {
            peopleList.add(people[i]);
        }

        Deque<Integer> pepleDeque = new ArrayDeque<>(peopleList);

        while (!pepleDeque.isEmpty()) {
            if (pepleDeque.peekFirst() + pepleDeque.peekLast() <= limit) {
                pepleDeque.pollFirst();
                pepleDeque.pollLast();
            } else {
                pepleDeque.pollFirst();
            }
            boat++;
        }

        return boat;

    }


}
