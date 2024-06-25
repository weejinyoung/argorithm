package 유레카.a0625sortkmp;

import java.util.Arrays;

public class MergeSort {

    static int[] a = {69, 10, 30, 2, 16, 8, 31, 22};
    static int[] s;

    private static void mergeSort(int L, int R) {
        if (L < R) {
            int M = (L + R) / 2;
            mergeSort(L, M);
            mergeSort(M + 1, R);
            merge(L, M, R);
            System.out.println(Arrays.toString(a));
        }
    }

    private static void merge(int L, int M, int R) {
        int i = L, j = M + 1, k = L;
        while (i <= M && j <= R) {
           if(a[i] <= a[j]) s[k++] = a[i++];
           else s[k++] = a[j++];
        }
        if (i < M) for (int l = j; l <= R; l++) s[k++] = a[l];
        else for(int l = j; l <= M; l++) s[k++] = a[l];


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        s = new int[a.length];
    }
}
