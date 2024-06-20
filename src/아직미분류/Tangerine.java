package 아직미분류;

import java.util.*;

class Tangerine {
    public int solution(int k, int[] tangerine) {
        int sum = 0; // 고를 귤의 개수
        int cnt = 0; // 최솟값 카운트

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());

        for (int value : valueList) {
            if (sum + value >= k) {
                cnt++;
                break;
            } else {
                sum += value;
                cnt++;
            }
        }
        return cnt;
    }
}