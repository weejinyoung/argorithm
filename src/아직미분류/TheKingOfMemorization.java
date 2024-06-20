package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class TheKingOfMemorization {


    static Integer[] note1;
    static int[] note2;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            answer = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            note1 = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                note1[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            note2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                note2[k] = Integer.parseInt(st.nextToken());
            }
            findAnswer();
            answer.deleteCharAt(answer.length() - 1);
            System.out.println(answer);
        }

    }

    static void findAnswer() {
        Set<Integer> note1Set = new HashSet<>(List.of(note1));
        for (int note2Num : note2) {
            if (note1Set.contains(note2Num)) {
                answer.append(1).append("\n");
            } else {
                answer.append(0).append("\n");
            }
        }
    }
}
