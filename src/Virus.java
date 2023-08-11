import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int colleague = Integer.parseInt(br.readLine());
        int listSize = Integer.parseInt(br.readLine());

        int[][] list = new int[listSize][2];
        for (int i = 0; i < listSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int i = 1 ; i <= colleague ; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : list) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        bfs(graph);
    }

    static void bfs(Map<Integer, ArrayList<Integer>> graph) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(1);
        visited.add(1);

        while (!queue.isEmpty()) {

            int current = queue.poll();
            ArrayList<Integer> neighbors = graph.get(current);
            Collections.sort(neighbors);

            for(int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}
