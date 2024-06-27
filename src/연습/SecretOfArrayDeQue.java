package 연습;

import java.util.*;
public class SecretOfArrayDeQue {

    // Stack : Last In First Out, 마지막으로 들어온 놈이

    static void printAdd() {

    }

    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();

        dq.add(1);             //  add -> addLast [1]
        dq.offerFirst(2);   // [2, 1]
        dq.push(3);         // [3,2,1]
        dq.offer(4);        // [3,2,1,4]
        dq.offerLast(5);    // [3,2,1,4,5]
        dq.addFirst(6);     // [6,3,2,1,4,5]
        dq.remove();           // remove -> removeFirst [3,2,1,4,5]
        dq.pollLast();         // [3,2,1,4]

        LinkedList<Integer> list = new LinkedList<>();
        list.listIterator();
        System.out.println(dq);
    }
}
