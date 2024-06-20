package 아직미분류;

class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int j = 0; j < prices.length; j++) {
            answer[j] = prices.length - 1 - j;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int k = i + 1; k < prices.length; k++) {
                if (prices[i] > prices[k]) {
                    answer[i] = k - i;
                    break;
                }
            }
        }

        return answer;

    }
}

