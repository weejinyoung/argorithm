package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FieldOfMelon {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> lengthMap = new LinkedHashMap<>();

        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            if (!lengthMap.containsKey(dir)) {
                lengthMap.put(dir, new LinkedList<>());
            }
            lengthMap.get(dir).add(Integer.parseInt(st.nextToken()));
        }

        int bigArea = 1;
        int smallArea = 1;
        boolean check = false;
        for (Integer key : lengthMap.keySet()) {
            List<Integer> lengthList = lengthMap.get(key);
            if (lengthList.size() == 1) {
                bigArea *= lengthList.get(0);
            } else {
                if (!check) {
                    smallArea *= lengthList.get(1);
                    check =true;
                } else {
                    smallArea *= lengthList.get(0);
                }
            }
        }

        System.out.println((bigArea - smallArea) * K);
    }
}
