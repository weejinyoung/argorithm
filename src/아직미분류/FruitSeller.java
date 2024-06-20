package 아직미분류;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


class FruitSeller {

    public int solution(int k, int m, int[] score) {
        int count = 0;
        int box = 0;
        int result = 0;

        List<Integer> scoreList = Arrays.stream(score)
                .boxed()
                .collect(Collectors.toList());

        scoreList.sort(Collections.reverseOrder());

        for (int startIndex = scoreList.indexOf(k); startIndex < scoreList.size(); startIndex++) {
            if (count < m) {
                box = scoreList.get(startIndex);
                count++;
            }
            if (count == m) {
                result += box * m;
                count = 0;
            }
        }

        return result;

    }
}
