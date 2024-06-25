package 유레카.a0625sortkmp;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] a = {0, 4, 1, 3, 1, 2, 4, 1};
//        int m = a[0];
//        for (int i = 0; i < a.length; i++) {
//            if (m < a[i]) {
//                m = a[i];
//            }
//        }
        int m = Arrays.stream(a).max().getAsInt();
        System.out.println(Arrays.toString(a));
    }
}
