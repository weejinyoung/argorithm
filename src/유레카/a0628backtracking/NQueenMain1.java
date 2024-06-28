package 유레카.a0628backtracking;

import java.util.Scanner;

public class NQueenMain1 {

    // 1차원 배열의 인덱스는 col 의 번호라고 생각
    // 해당 인덱스가 가리키는 값은 row 의 번호
    // 따라서
    static int N, ans, col[];

    static boolean isAvailable(int rowNo) {
        // 같은
        for (int j = 0; j < rowNo; j++) {
            if (col[rowNo] == col[j] || col[rowNo] - col[j] == rowNo - j) return false;
        }
        return true;
    }

    static void nqueen(int rowNo) {
        if (!isAvailable(rowNo)) return;
        if (rowNo == N) {
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            col[rowNo] = i;
            nqueen(rowNo + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = 4;
        col = new int[N];
        sc.close();
    }
}

