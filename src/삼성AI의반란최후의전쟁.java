import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 삼성AI의반란최후의전쟁 {
    private static int[][] abilities;
    private static StringBuilder sb = new StringBuilder();
    private static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int i = 1; i <= test_case; i++) {
            int num = Integer.parseInt(br.readLine());

            abilities = new int[num][3];

            for(int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                abilities[j][0] = Integer.parseInt(st.nextToken());
                abilities[j][1] = Integer.parseInt(st.nextToken());
                abilities[j][2] = Integer.parseInt(st.nextToken());
            }

            if(num < 3) {
                sb.append("#").append(i).append(" -1").append("\n");
                continue;
            }

            boolean[] visited = new boolean[num];
            min = Integer.MAX_VALUE;

            getPermutation(visited, 0, 0, 3);

            sb.append("#").append(i).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

    private static int getMin(List<int[]> resultList) {
        int[] arr1 = resultList.get(0);
        int[] arr2 = resultList.get(1);
        int[] arr3 = resultList.get(2);

        int result1 = arr1[1] + arr1[2] + arr2[0] + arr2[2] + arr3[0] + arr3[1];
        int result2 = arr1[1] + arr1[2] + arr2[0] + arr2[1] + arr3[0] + arr3[2];
        int result3 = arr1[0] + arr1[2] + arr2[1] + arr2[2] + arr3[0] + arr3[1];
        int result4 = arr1[0] + arr1[2] + arr2[0] + arr2[1] + arr3[1] + arr3[2];
        int result5 = arr1[0] + arr1[1] + arr2[1] + arr2[2] + arr3[0] + arr3[2];
        int result6 = arr1[0] + arr1[1] + arr2[0] + arr2[2] + arr3[1] + arr3[2];

        return Math.min(Math.min(result1, result2), Math.min(Math.min(result3, result4), Math.min(result5, result6)));
    }

    private static void getPermutation(boolean[] visited, int start, int current, int target) {
        if(current == target) {
            getResult(visited);
            return;
        }

        for(int i = start; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                getPermutation(visited, i + 1, current + 1, target);
                visited[i] = false;
            }
        }
    }

    private static void getResult(boolean[] visit) {
        List<int[]> resultList = new ArrayList<>(3);
        int temp = 0;

        for(int i = 0; i < visit.length; i++) {
            if(visit[i]) {
                resultList.add(abilities[i]);
                continue;
            }

            int str = abilities[i][0];
            int intel = abilities[i][1];
            int dex = abilities[i][2];

            temp += Math.min(Math.min(str + intel, str + dex), intel + dex);
        }

        temp += getMin(resultList);

        min = Math.min(min, temp);
    }

}

