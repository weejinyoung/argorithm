import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int match = 0;
        int numOf0 = 0;
        int[] answer = new int[2];

        List<Integer> winNumList = Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toList());

        for (int lotto : lottos) {
            if (lotto == 0) {
                numOf0++;
            } else if (winNumList.contains(lotto)) {
                match++;
            }
        }

        if (match < 2) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - match;
        }
        answer[0] = 7 - match - numOf0;
        if(answer[0] == 7) {
            answer[0] = 6;
        }

        return answer;

    }
}
