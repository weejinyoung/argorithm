public class IntegerTriangle {

    public int solution(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            int[] row = triangle[i];
            for (int j = 0; j < row.length; j++) {
                row[j] = Math.max(row[j]+ triangle[i+1][j], row[j] + triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
}