public class JumpAndTeleport {
    public int solution(int n) {
        int consumption = 1;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n - 1;
                consumption++;
            }
        }

        return consumption;
    }
}
