package 프로그래머스;

import java.util.Arrays;

public class Pro테이블해시함수 {

    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return Integer.compare(o2[0], o1[0]);
            } else {
                return Integer.compare(o1[col - 1], o2[col - 1]);
            }
        });

        int answer = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                sum += data[i - 1][j] % i;
            }
            answer ^= sum;
        }

        System.out.println(answer);
    }
}

