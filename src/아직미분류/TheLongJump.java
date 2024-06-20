package 아직미분류;

class TheLongJump {
    long[] dp = new long[2001];

    public long solution(int n) {
        return recursion(n);
    }

    long recursion(int n) {
        if (dp[n] > 0) {
            return dp[n];
        }
        if (n == 1) {
            return dp[1] = 1;
        }
        if (n == 2) {
            return dp[2] = 2;
        }
        return dp[n] = (recursion(n-2) + recursion(n-1)) % 1234567;
    }

}