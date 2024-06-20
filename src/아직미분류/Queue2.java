package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Queue2 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder results = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String order = br.readLine();

            if (order.contains("push")) {
                String[] orders = order.split(" ");
                String input = orders[1];
                queue.offer(Integer.parseInt(input));
            } else {
                switch (order) {
                    case "pop" : {
                        if (queue.isEmpty()) {
                            results.append(-1).append("\n");
                        } else {
                            results.append(queue.poll()).append("\n");
                        }
                        break;
                    }
                    case "size" : {
                        results.append(queue.size()).append("\n");
                        break;
                    }
                    case "empty" : {
                        if (queue.isEmpty()) {
                            results.append(1).append("\n");
                        } else {
                            results.append(0).append("\n");
                        }
                        break;
                    }
                    case "front" : {
                        if (queue.isEmpty()) {
                            results.append(-1).append("\n");
                        } else {
                            results.append(queue.peek()).append("\n");
                        }
                        break;
                    }
                    case "back" : {
                        if (queue.isEmpty()) {
                            results.append(-1).append("\n");
                        } else {
                            results.append(((LinkedList<Integer>) queue).peekLast()).append("\n");
                        }
                    }
                    break;
                }
            }

        }
        System.out.println(results);
    }
}
