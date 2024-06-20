package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DogEatDog {

    static ArrayList<Integer> A;
    static ArrayList<Integer> B;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            A = new ArrayList<>();
            B = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                B.add(Integer.parseInt(st.nextToken()));
            }
            A.sort(Comparator.reverseOrder());
            B.sort(Comparator.naturalOrder());
            findAnswer();
        }
        answer.deleteCharAt(answer.length() - 1);
        System.out.println(answer);
    }

    static void findAnswer() {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(B.size() - 1);
        int sum = 0;

        for (int i = 0; i < A.size(); i++) {
            int low = 0;
            int high = dp.get(i);
            int current = A.get(i);
            int index = 0;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (current > B.get(mid)) {
                    low = mid + 1;
                    index = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            dp.add(index - 1);
            sum += index;
        }
        answer.append(sum).append("\n");
    }


}