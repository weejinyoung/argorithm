import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipItOver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            if (i == 0 || S.charAt(i) != S.charAt(i - 1)) {
                sb.append(S.charAt(i));
            }
        }

        int zeroCnt = 0;
        int oneCnt = 0;

        for (String element : sb.toString().split("")) {
            if (element.equals("0")) {
                oneCnt++;
            } else {
                zeroCnt++;
            }
        }

        System.out.println(Math.min(oneCnt, zeroCnt));


    }
}
