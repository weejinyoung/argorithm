package 유레카.a0626listtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BJ1406 {

    static List<String> input;
    static int cursor;

    static void edit(String command) {
        switch (command.charAt(0)) {
            case 'L':
                if (cursor != 0) cursor--;
                break;
            case 'D':
                if (cursor != input.size()) cursor++;
                break;
            case 'B':
                if (cursor != 0) {
                    input.remove(cursor - 1);
                    cursor--;
                }
                break;
            case 'P':
                input.add(cursor, command.split(" ")[1]);
                cursor++;
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = new LinkedList<>(Arrays.asList(br.readLine().split("")));
        cursor = input.size();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            edit(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        input.forEach(sb::append);
        System.out.println(sb);
    }
}
