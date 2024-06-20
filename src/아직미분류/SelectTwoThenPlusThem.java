package 아직미분류;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
class SelectTwoThenPlusThem {
    public ArrayList<Integer> solution(int[] numbers) {
        int size = numbers.length;
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < size; i++) {
            for(int count = i + 1; count < size; count++) {
                resultSet.add(numbers[i] + numbers[count]);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>(resultSet);
        Collections.sort(answer);

        return answer;
    }
}

