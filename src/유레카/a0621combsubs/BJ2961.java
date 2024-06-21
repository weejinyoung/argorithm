package 유레카.a0621combsubs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ2961 {

    static int N ;
    static int[] ingredientsIndex;
    static int[][] ingredientsTaste;
    static int answer = Integer.MAX_VALUE;

    static int getTasteSum(int[] selectedIndexes) {
        int sourSum = 1;
        int bitterSum = 0;
        for(int index : selectedIndexes) {
            int[] sourAndBitter = ingredientsTaste[index];
            sourSum *= sourAndBitter[0];
            bitterSum += sourAndBitter[1];
        }
        return Math.abs(sourSum - bitterSum);
    }

    static int[] toIntArray(String indexes) {
        String[] indexStringArray = indexes.split("");
        int[] indexIntArray = new int[indexStringArray.length];
        for(int i = 0; i < indexStringArray.length; i++) {
            indexIntArray[i] = Integer.parseInt(indexStringArray[i]);
        }
        return indexIntArray;
    }

    static void subs(int cnt, String indexes) {
        if (cnt == N) {
            if(indexes.isEmpty()) {
                return;
            }
            int[] indexIntArr = toIntArray(indexes);
            int tasteSum = getTasteSum(indexIntArr);
            answer = Math.min(answer, tasteSum);
            return;
        }
        subs(cnt + 1, indexes + ingredientsIndex[cnt]);
        subs(cnt + 1, indexes);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ingredientsIndex = new int[N];
        ingredientsTaste = new int[N][2];

        for(int i = 0; i < N; i++) {
            ingredientsIndex[i] = i;
        }

        ingredientsTaste = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                ingredientsTaste[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subs(0, "");
        System.out.println(answer);
    }
}

