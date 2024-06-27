package 유레카.a0627greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ11399 {

    // 현재 걸리는 사람의 시간이 뒤에서 기다리고 있는 사람의 대기시간에 영향을 끼친다
    // 가장 빨리 뽑는 사람을 맨 앞에 놔야 뒷 사람들이 기다리는 시간의 합이 적다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] people = new int[N];
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);
        int temp = people[0];
        int result = 0;
        for (int i = 1; i < N; i++) {
            temp += people[i];
            result += temp;
        }
        System.out.println(result);
    }
}
