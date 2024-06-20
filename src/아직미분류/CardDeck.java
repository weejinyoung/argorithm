package 아직미분류;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class CardDeck {

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> cards1Queue = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cards2Queue = new LinkedList<>(Arrays.asList(cards2));

        for (String word : goal) {
            if (Objects.equals(cards1Queue.peek(), word)) {
                cards1Queue.poll();
            } else if (Objects.equals(cards2Queue.peek(), word)) {
                cards2Queue.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
