package 아직미분류;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeBacktracking {

    static String input = "259";
    static Map<Integer, String[]> phone = new HashMap<>();
    static List<String> output = new ArrayList<>();

    public static void main(String[] args) {
        phone.put(1, new String[]{" "});
        phone.put(2, new String[]{"a", "b", "c"});
        phone.put(3, new String[]{"d", "e", "f"});
        phone.put(4, new String[]{"g", "h", "i"});
        phone.put(5, new String[]{"j", "k", "l"});
        phone.put(6, new String[]{"m", "n", "o"});
        phone.put(7, new String[]{"p", "q", "r", "s"});
        phone.put(8, new String[]{"t", "u", "v"});
        phone.put(9, new String[]{"w", "x", "y", "z"});

        backtracking(0, "");

        output.forEach(System.out::println);
    }

    private static void backtracking(int index, String letter) {
        if (index >= input.length()) {
            output.add(letter);
            return;
        }
        int num = Integer.parseInt(String.valueOf(input.charAt(index)));
        String[] chars = phone.get(num);
        for (String s : chars) {
            backtracking(index + 1, letter + s);
        }
    }
}
