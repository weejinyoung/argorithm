package 유레카.a0702kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
public class BJ24391 {


    static int[] p;
    static int N, M;

    static int find(int target) {
        if(p[target] == target) return target;
        return find(target);
    }

    static boolean union(int from, int to) {
        int fromRoot = find(from);
        int toRoot = find(to);
        if(fromRoot == toRoot) return false;
        p[toRoot] = fromRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
        }

    }
}
