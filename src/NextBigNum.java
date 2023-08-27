
class NextBigNum {

    public int solution(int n) {
        int numOf1InN = changeToBinaryAndCount1(n);
        int numOf1InAnswer = 0;
        int answer = n;

        while (true) {
            answer++;
            numOf1InAnswer = changeToBinaryAndCount1(answer);
            if (numOf1InAnswer == numOf1InN) {
                break;
            }
        }

        return answer;

    }

    static int changeToBinaryAndCount1(int target) {
        return Integer.bitCount(target);
    }

}