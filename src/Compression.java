import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Compression {
    public int[] solution(String msg) {

        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        String[] character = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int i = 0; i < character.length; i++) {
            dictionary.put(character[i], i + 1);
        }

        int i = msg.length() - 1;
        for (; i >= 0; i--) {
            if (dictionary.containsKey(msg)) {
                answerList.add(dictionary.get(msg));
                break;
            }
            String msgSubstring = msg.substring(0, i);
            if (dictionary.containsKey(msgSubstring)) {
                answerList.add(dictionary.get(msgSubstring));
                if (i != msg.length() - 1) {
                    String newWord = msg.substring(0, i + 1);
                    dictionary.put(newWord, dictionary.size() + 1);
                }
                msg = msg.substring(i);
                i = msg.length();
            }
        }

        int[] answerArray = new int[answerList.size()];

        for (int j = 0; j < answerList.size(); j++) {
            answerArray[j] = answerList.get(j);
        }

        return answerArray;
    }

}

