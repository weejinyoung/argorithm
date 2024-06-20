package 아직미분류;

import java.util.Arrays;

import java.util.Arrays;


class FailureRate {

    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];

        // { 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수, 스테이지에 도달한 플레이어 수 }
        double[][] unsolvedPlayerAndReachedPlayer = new double[N][2];
        // { 스테이지 번호, 실패율 }
        double[][] stageAndFailureRate = new double[N][2];

        for (int j = 0; j < N; j++) {
            unsolvedPlayerAndReachedPlayer[j][0] = 0;
            unsolvedPlayerAndReachedPlayer[j][1] = 0;
            stageAndFailureRate[j][0] = 0;
            stageAndFailureRate[j][1] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int stage : stages) {
                // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
                if (i == stage) {
                    unsolvedPlayerAndReachedPlayer[i-1][0] = unsolvedPlayerAndReachedPlayer[i-1][0] + 1;
                }
                // 스테이지에 도달한 플레이어 수
                if (i <= stage) {
                    unsolvedPlayerAndReachedPlayer[i-1][1] = unsolvedPlayerAndReachedPlayer[i-1][1] + 1;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            stageAndFailureRate[k][0] = k+1;
            if (unsolvedPlayerAndReachedPlayer[k][1] == 0.0 || unsolvedPlayerAndReachedPlayer[k][0] == 0.0) {
                stageAndFailureRate[k][1] = 0;
            } else {
                // k+1 스테이지의 실패율
                stageAndFailureRate[k][1] = (unsolvedPlayerAndReachedPlayer[k][0]/unsolvedPlayerAndReachedPlayer[k][1]);
            }
        }

        Arrays.sort(stageAndFailureRate, (o1, o2) -> Double.compare(o2[1], o1[1]));


        for (int m = 0; m < N; m++) {
            answer[m] = (int)stageAndFailureRate[m][0];
        }

        return answer;

    }
}

