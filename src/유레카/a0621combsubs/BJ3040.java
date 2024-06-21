package 유레카.a0621combsubs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3040 {

    static int[] allKids = new int[9];
    static int[] candidateKids = new int[7];
    static StringBuilder realKids = new StringBuilder();

    static void comb(int cnt, int start) {
        if(cnt == 7) {
            int sum = 0;
            for(int i = 0; i < 7; i++) {
                sum += candidateKids[i];
            }
            if(sum == 100) {
                for(int i = 0; i < 7; i++) {
                    realKids.append(candidateKids[i]).append("\n");
                }
                realKids.deleteCharAt(realKids.length() - 1);
            }
            return;
        }
        for(int i = start; i < 9; i++) {
            candidateKids[cnt] = allKids[i];
            comb(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            allKids[i] = Integer.parseInt(br.readLine());
        }
        comb(0, 0);
        System.out.println(realKids);
    }
}
