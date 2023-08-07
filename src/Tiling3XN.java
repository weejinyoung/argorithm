import java.util.ArrayList;
import java.util.List;

public class Tiling3XN {
    public static List<List<Integer>> findCombinations(int n) {
        List<List<Integer>>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 3; j <= i; j += 3) {
                for (List<Integer> combination : dp[i - j]) {
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.add(j);
                    dp[i].add(newCombination);
                }
            }
            if (i % 3 == 0) {
                List<Integer> singleCombination = new ArrayList<>();
                singleCombination.add(i);
                dp[i].add(singleCombination);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> combinations = findCombinations(n);
        System.out.println("Combinations for " + n + ": " + combinations);
    }
}
