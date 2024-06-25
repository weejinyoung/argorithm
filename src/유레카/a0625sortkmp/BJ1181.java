package 유레카.a0625sortkmp;

import java.util.*;
import java.io.*;
import java.util.stream.*;


public class BJ1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        String[] input = set.toArray(new String[0]);

        Arrays.sort(input, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : Integer.compare(o1.length(), o2.length()));

        StringBuilder sb = new StringBuilder();
        Arrays.stream(input).forEach((o) -> sb.append(o).append("\n"));

        System.out.println(sb);
    }
}
