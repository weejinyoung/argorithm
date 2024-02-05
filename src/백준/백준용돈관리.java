package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준용돈관리 {

    private static int N;
    private static int M;
    private static int[] costs;

    private static int getCount(int target) {
        int remain = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (remain < costs[i]) {
                count++;
                remain = target;
            }
            remain -= costs[i];
        }
        return count;
    }

    private static int findAnswer(int low, int high) {
        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (getCount(mid) > M) {
                low = mid + 1;
            } else {
                answer = mid;
                high = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int max = 0;
        int sum = 0;
        costs = new int[N];
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(br.readLine());
            sum += costs[i];
            max = Math.max(costs[i], max);
        }
        System.out.println(findAnswer(max, sum));
    }
}
