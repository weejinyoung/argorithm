import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EnglishShiritori {
    public int[] solution(int n, String[] words) {
        Stack<String> stack = new Stack<>();
        Map<Integer, String> lastCharMap = new HashMap<>();
        int[] answer = new int[2];

        String[] firstWordSplit = words[0].split("");
        String firstWordsLastChar = firstWordSplit[firstWordSplit.length - 1];
        lastCharMap.put(0, firstWordsLastChar);
        stack.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String[] wordSplit = words[i].split("");
            if (stack.contains(words[i]) || !lastCharMap.get(i - 1).equals(wordSplit[0])) {
                int person = (i + 1) % n == 0 ? n : (i + 1) % n;
                int count = (i / n) + 1;
                answer[0] = person;
                answer[1] = count;
                break;
            } else {
                String wordsLastChar = wordSplit[wordSplit.length - 1];
                lastCharMap.put(i, wordsLastChar);
                stack.add(words[i]);
            }
        }
        return answer;
    }
}
