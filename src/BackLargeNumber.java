public class BackLargeNumber {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        int[] answers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int target = numbers[i];
            boolean isFind = false;
            for (int j = i; j < numbers.length; j++) {
                if (target < numbers[j]) {
                    answers[i] = numbers[j];
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                answers[i] = -1;
            }
        }

        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }
}
