package 아직미분류;

class PickingGround {
    int solution(int[][] land) {

        for (int i = land.length - 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(max, land[i + 1][k]);
                    }
                }
                land[i][j] += max;
            }
        }

        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, land[0][i]);
        }

        return max;
    }
}