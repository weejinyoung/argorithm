package 유레카.a0701bfsdfsgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphIntArray {

    public static void main(String[] args) {
        int[][] a = new int[32_537][32_537];

        int[] ia = new int[3];
        ia[0] = 'A';
        System.out.println(Arrays.toString(ia));
        System.out.println();

        List<Integer>[] la = new List[3];
        System.out.println(Arrays.toString(la));
        for (int i = 0; i < la.length; i++) la[i] = new ArrayList<>();
        la[0].add(123);
    }
}
