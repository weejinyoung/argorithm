package 유레카.a0628backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ2578 {


    static Map<Integer, int[]> numberMapper = new HashMap<>();
    static int[] colSum = new int[5];
    static int[] rowSum = new int[5];
    static int[] crossSum = new int[2];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                colSum[j] += number;
                rowSum[i] += number;
                if(i == j) crossSum[0] += number;
                if(i + j == 4) crossSum[1] += number;
                numberMapper.put(number, new int[] {i, j});
            }
        }

//        Arrays.stream(colSum).forEach(System.out::println);

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                int[] index = numberMapper.get(number);
                System.out.println(Arrays.toString(index));

                colSum[index[1]] -= number;
//                System.out.println(index[1] + "번째 컬럼 합에서 " + number + " 를 뺀다 남은 컬럼합은 " + colSum[index[1]]);
                if(colSum[index[1]] == 0) count++;

                rowSum[index[0]] -= number;
//                System.out.println(index[0] + "번째 로우 합에서 " + number + " 를 뺀다 남은 로우합은 " + rowSum[index[0]]);
                if(rowSum[index[0]] == 0) count++;

                if(index[0] == index[1]) {
                    crossSum[0] -= number;
                    System.out.println("왼 -> 오 로 내려가는 대각 합에서 " + number + " 를 뺀다 남은 대각합은 " + crossSum[0]);

                }
                if(crossSum[0] == 0) count++;

                if(index[0] + index[1] == 4) crossSum[1] -= number;
                if(crossSum[1] == 0) count++;

                if (count >= 3) {
                    System.out.println((i * 5) + j + 1);
                    return;
                }
            }
        }
    }
}
