import java.math.BigInteger;

class NDigitGame {
    public String solution(int n, int t, int m, int p) {
        int i = 0;
        int j = 0;
        int k = 0;
        StringBuilder sb = new StringBuilder();
        loop:
        while (true) {
            String[] result = toNDigitString(n, i).split("");
            for (String element : result) {
                j++;
                if ((m == p && j % m == 0) || j % m == p) {
                    sb.append(element);
                    k++;
                    if (k == t) {
                        break loop;
                    }
                }
            }
            i++;
        }

        return sb.toString();
    }

    String toNDigitString(int n, int num) {
        BigInteger bigInteger = new BigInteger(String.valueOf(num));
        return bigInteger.toString(n).toUpperCase();
    }
}
