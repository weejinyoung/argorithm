import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 테스크 {
    private static int[][] resultArr;
    private static StringBuilder sb = new StringBuilder();
    private static int minWeight;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int cycle = 1; cycle <= testCase; cycle++) {
            int persons = Integer.parseInt(br.readLine());

            initResultArr(persons);

            for(int person = 0; person < persons; person++) {
                st = new StringTokenizer(br.readLine(), " ");

                int abilityA = Integer.parseInt(st.nextToken());
                int abilityB = Integer.parseInt(st.nextToken());
                int abilityC = Integer.parseInt(st.nextToken());

                resultArr[person][0] = abilityA;
                resultArr[person][1] = abilityB;
                resultArr[person][2] = abilityC;
            }

            if(persons < 3) {
                sb.append("#").append(cycle).append(" -1").append("\n");
                continue;
            }

            boolean[] visitArr = new boolean[persons];
            minWeight = Integer.MAX_VALUE;

            getPermutation(visitArr, 0, 0, 3);

            sb.append("#").append(cycle).append(" ").append(minWeight).append("\n");
        }

        System.out.println(sb);
    }

    private static void initResultArr(int height) {
        resultArr = new int[height][3];
    }

    private static void getPermutation(boolean[] visitArr, int start, int current, int target) {
        if(current == target) {
            getResult(visitArr);
            return;
        }

        for(int i = start; i < visitArr.length; i++) {
            if(!visitArr[i]) {
                visitArr[i] = true;
                getPermutation(visitArr, i + 1, current + 1, target);
                visitArr[i] = false;
            }
        }
    }

    private static void getResult(boolean[] visit) {
        List<int[]> resultList = new ArrayList<>(3);
        int weight = 0;

        for(int i = 0; i < visit.length; i++) {
            if(visit[i]) {
                resultList.add(resultArr[i]);
                continue;
            }

            int abilityA = resultArr[i][0];
            int abilityB = resultArr[i][1];
            int abilityC = resultArr[i][2];

            weight += Math.min(Math.min(abilityA + abilityB, abilityA + abilityC), abilityB + abilityC);
        }

        weight += getMinWeight(resultList);

        minWeight = Math.min(minWeight, weight);
    }

    private static int getMinWeight(List<int[]> resultList) {
        int[] arr1 = resultList.get(0);
        int[] arr2 = resultList.get(1);
        int[] arr3 = resultList.get(2);

        int arr1_0 = arr1[0];
        int arr1_1 = arr1[1];
        int arr1_2 = arr1[2];

        int arr2_0 = arr2[0];
        int arr2_1 = arr2[1];
        int arr2_2 = arr2[2];

        int arr3_0 = arr3[0];
        int arr3_1 = arr3[1];
        int arr3_2 = arr3[2];

        int result1 = arr1_1 + arr1_2 + arr2_0 + arr2_2 + arr3_0 + arr3_1;
        int result2 = arr1_1 + arr1_2 + arr2_0 + arr2_1 + arr3_0 + arr3_2;
        int result3 = arr1_0 + arr1_2 + arr2_1 + arr2_2 + arr3_0 + arr3_1;
        int result4 = arr1_0 + arr1_2 + arr2_0 + arr2_1 + arr3_1 + arr3_2;
        int result5 = arr1_0 + arr1_1 + arr2_1 + arr2_2 + arr3_0 + arr3_2;
        int result6 = arr1_0 + arr1_1 + arr2_0 + arr2_2 + arr3_1 + arr3_2;

        return Math.min(Math.min(result1, result2), Math.min(Math.min(result3, result4), Math.min(result5, result6)));
    }
}
