package 아직미분류;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Clothes {
    public int solution(String[][] clothes) {

        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] cloth : clothes) {
            if (!clothesMap.containsKey(cloth[1])) {
                clothesMap.put(cloth[1], 1);
            } else {
                int value = clothesMap.get(cloth[1]);
                clothesMap.replace(cloth[1], value + 1);
            }
        }

        Iterator<Integer> it = clothesMap.values().iterator();
        int answer = 1;

        while(it.hasNext())
            answer *= it.next().intValue() + 1;

        return answer - 1;

    }

}
