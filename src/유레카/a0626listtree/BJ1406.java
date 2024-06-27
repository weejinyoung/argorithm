package 유레카.a0626listtree;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1406 {

    static ListIterator<String> input;

    static void edit(String command) {
        switch (command.charAt(0)) {
            case 'L':
                if(input.hasPrevious()) input.previous();
                break;
            case 'D':
                if(input.hasNext()) input.next();
                break;
            case 'B':
                if (input.hasPrevious()) {
                    input.previous();
                    input.remove();
                }
                break;
            case 'P':
                input.add(String.valueOf(command.charAt(2)));
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new LinkedList<>(Arrays.asList(br.readLine().split("")));
        input = list.listIterator();

        ArrayDeque<Integer> aq = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();

        while (input.hasNext()) {
            input.next();
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            edit(br.readLine());
        }
        StringBuilder sb = new StringBuilder();

        list.forEach(sb::append);
        System.out.println(sb);
    }
}
