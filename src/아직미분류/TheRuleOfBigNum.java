package 아직미분류;

import java.io.*;
import java.util.*;

public class TheRuleOfBigNum {

    private static int N;
    private static int M;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        K = Integer.parseInt(st1.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            arr.add(temp);
        }

        Collections.sort(arr);
        int max = arr.get(N-1);
        int nextMax = arr.get(N-2);
        int times = M / K;
        int last = M % K;

        int result = (max * times * K) + (last * nextMax);

        System.out.println(result);
    }
}
