package 유레카.a0624stackqueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueueTest {
    public static void main(String[] args) {
//        Queue<String> queue = new LinkedList<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("강호동");
        queue.offer("저팔계");
        queue.offer("강호동");
        queue.offer("강호동");
        queue.poll();
        System.out.println(queue.peek() + " " + queue.size());
        System.out.println(queue.poll() + " " + queue.size());
        System.out.println(queue.poll() + " " + queue.size());



        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("저팔계");
        stack.push("강호동");
        stack.push("손오공");
        stack.push("사오정");
        stack.push("홍길동");
        System.out.println(stack.peek() + " " + stack.size());
        System.out.println(stack.pop() + " " + stack.size());
        System.out.println(stack.pop() + " " + stack.size());
    }
}
