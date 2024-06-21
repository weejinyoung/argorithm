package 유레카.a0621combsubs;


import java.util.*;

public class CombMain {

    static int R = 3;
    static int C = 0;
    static int N = 4;
    static int[] a = {1, 2, 3, 4};
    static int[] b = new int[R];
   //  static boolean[] v = new boolean[N];

    static void comb(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(b));
            C++;
            return;
        }
        for (int i = start; i < N; i++) {
            b[cnt] = a[i];
            comb(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        C = 0;
        comb(0, 0);
        System.out.println(C);
    }
}
