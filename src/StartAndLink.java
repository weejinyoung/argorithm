import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartAndLink {

    static StringBuilder answer = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int N = 4;
        int[][] chemistryChart = new int[N][N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            String[] chemistryString = br.readLine().split(" ");
            for (int k = 0; k < N; k++) {
                chemistryChart[i][k] = Integer.parseInt(chemistryString[k]);
            }
        }
        
    }

    static void dfs(Map<Integer, ArrayList<Integer>> graph, int start) {
        stack.push(start);
        visited.add(start);
        answer.append(start).append(" ");

        while (!stack.isEmpty()) {

            int current = stack.peek();
            boolean hasNeighbor = false;
            ArrayList<Integer> neighbors = graph.get(current);
            Collections.sort(neighbors);

            for(int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    hasNeighbor = true;
                    stack.push(neighbor);
                    visited.add(neighbor);
                    answer.append(neighbor).append(" ");
                    break;
                }
            }

            if(!hasNeighbor) {
                stack.pop();
            }
        }

        System.out.println(answer);
    }
}
