package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindSpecificDistanceCity {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()))
                    .add(Integer.parseInt(st.nextToken()));
        }

        bfs(K, X);
        if (answer.isEmpty()) {
            System.out.print(-1);
            return;
        }
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            if (i == answer.size() - 1) {
                System.out.print(answer.get(i));
            } else {
                System.out.println(answer.get(i));
            }
        }


    }

    static void bfs(int K, int X) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;

        queue.add(X);
        visited.add(X);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int current = queue.poll();
                if (level == K) {
                    answer.add(current);
                }
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            level++;
        }
    }

}


