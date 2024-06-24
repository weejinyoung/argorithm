package 유레카.a0621combsubs;

import java.io.*;
import java.util.*;

public class PermMain {

    private static int N = 4;
    private static int R = 3;
    private static int C = 0;
    private static int[] a = {1,2,3,4};
    private static int[] b = new int[R];
    private static boolean[] visited = new boolean[N];

    private static void perm(int cnt) {
        if(cnt == R) {
            System.out.println(Arrays.toString(b));
            C++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            b[cnt] = a[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws Exception {
        C = 0;
        perm(0);
        System.out.println(C);
    }
}
