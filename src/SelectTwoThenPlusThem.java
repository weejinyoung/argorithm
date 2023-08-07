import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class SelectTwoThenPlusThem {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int size = numbers.length;
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < size; i++) {
            for(int count = i + 1; count < size; count++) {
                resultSet.add(numbers[i] + numbers[count]);
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);

        int[] answer = new int[resultList.size()];
        int k = 0;
        for (int result : resultList) {
            answer[k++] = result;
        }
    }
}
