package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HumanComputerInteraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String name = br.readLine();
        int q = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int sInx = Integer.parseInt(st.nextToken());
            int eIdx = Integer.parseInt(st.nextToken());
            sb.append(countChar(name.substring(sInx, eIdx + 1), c)).append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    public static int countChar(String str, char c) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
