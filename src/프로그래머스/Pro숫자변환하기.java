package 프로그래머스;

public class Pro숫자변환하기 {

    private static int result = Integer.MAX_VALUE;

    private static int n;
    private static int y;

    private static void recursion(int current, int count) {
        if (current > result) {
            return;
        }
        if(current == y) {
            result = Math.min(result, count);
        } else if(current < y) {
            recursion(current + n, count + 1);
            recursion(current * 2, count + 1);
            recursion(current * 3, count + 1);
        }
    }
    public static void main(String[] args) {
        int x = 10;
        y = 40;
        n = 30;
        recursion(x, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
