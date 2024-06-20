package 아직미분류;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class PersonalInfoExpirationDate {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate[] limitDate = new LocalDate[privacies.length];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        List<Integer> answerList = new ArrayList<>();
        int[] answer;

        LocalDate todayDate = LocalDate.parse(today, formatter);

        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            termsMap.put(termSplit[0], Integer.parseInt(termSplit[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacySplit = privacies[i].split(" ");
            limitDate[i] = LocalDate.parse(privacySplit[0], formatter)
                    .plusMonths(termsMap.get(privacySplit[1]));
            if (!limitDate[i].isAfter(todayDate)) {
                answerList.add(i+1);
            }
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;

    }
}
