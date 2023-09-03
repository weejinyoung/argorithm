import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindParentTreeNode {
    static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static Map<Integer, Integer> parents = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= N ; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[][] edges = new int[N-1][2];
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        findParentByBfs();

        for (int i = 2; i <= graph.size(); i++) {
            System.out.println(parents.get(i));
        }

    }

    static void findParentByBfs() {
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
                    parents.put(neighbor, current);
                }
            }
        }
    }
}
