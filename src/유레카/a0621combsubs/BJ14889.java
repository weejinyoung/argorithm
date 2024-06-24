package 유레카.a0621combsubs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {

    static int N;
    static int[][] synergy;
    static int[] employee;
    static int[] startTeam;
    static int[] linkTeam;

    static int getSynergySum(int i, int j) {
        return synergy[i][j] + synergy[j][i];
    }


    // TODO start 와 link 가 반대가 되는 경우는 세지 않아야 하는데..!
    static void getLinkTeam(int[] startTeam) {
        linkTeam = new int[N / 2];
        int index = 0;
        for(int i = 0; i < N; i++) {
            if(startTeam[index] != i) {
                linkTeam[index] = i;
                index++;
            }
        }
    }

//    static int getDiff() {
//
//    }

    static void comb(int cnt, int start) {
        if(cnt == N / 2) {


        }

        for(int i = start; i < N * 2; i++) {
            startTeam[cnt] = employee[i];
            comb(cnt + 1, i + 1);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        synergy = new int[N][N];
//        selected = new boolean[N * 2];
        employee = new int[N * 2];
        for(int i = 0; i < N * 2; i++) {
            employee[i] = i;
        }
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        comb();
    }
}
