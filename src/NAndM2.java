import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NAndM2 {
    static boolean[] isVisited;
    static int[] num;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[m + 1];
        num = new int[m + 1];
        dfs(1, -1);
    }

    static void dfs(int current, int prevNum) {
        if (current > m) {
            for (int i = 1; i <= m; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isVisited[current]) {
                continue;
            }
            if (prevNum >= i) {
                continue;
            }
            isVisited[current] = true;
            num[current] = i;
            prevNum = i;
            dfs(current + 1, prevNum);
            isVisited[current] = false;
        }
    }
}