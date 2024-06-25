package 유레카.a0625sortkmp;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueMain {

    static class Car implements Comparable<Car> {

        String name;
        int year;

        Car(String name, int year) {
            this.name = name;
            this.year = year;
        }

        @Override
        public int compareTo(@NotNull Car o) {
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Car> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.year)));
        pq.offer(new Car("아반뗴", 2015));
        pq.offer(new Car("그렌저", 2007));
        pq.offer(new Car("소나타", 2024));
        pq.offer(new Car("아반뗴", 2015));
        pq.offer(new Car("그렌저", 2007));
        pq.offer(new Car("소나타", 2024));

        System.out.println(pq);

//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        pq.offer(22);
//        pq.offer(11);
//        pq.offer(33);
//        pq.offer(22);
//        pq.offer(11);
//        pq.offer(33);
//        System.out.println(pq);
//        while (!pq.isEmpty()) System.out.println(pq.poll());
//        System.out.println();
    }
}
