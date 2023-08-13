import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Wedding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int colleagueNum = Integer.parseInt(br.readLine());
        int colleagueRelationshipListSize = Integer.parseInt(br.readLine());

        int[][] colleagueRelationshipList = new int[colleagueRelationshipListSize][2];
        for (int i = 0; i < colleagueRelationshipListSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colleagueRelationshipList[i][0] = Integer.parseInt(st.nextToken());
            colleagueRelationshipList[i][1] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, ArrayList<Integer>> colleagueRelationshipGraph = new HashMap<>();

        for(int i = 1 ; i <= colleagueNum ; i++) {
            colleagueRelationshipGraph.put(i, new ArrayList<>());
        }

        for(int[] colleagueRelationship : colleagueRelationshipList) {
            colleagueRelationshipGraph.get(colleagueRelationship[0]).add(colleagueRelationship[1]);
            colleagueRelationshipGraph.get(colleagueRelationship[1]).add(colleagueRelationship[0]);
        }

        //bfs(colleagueRelationshipGraph);
        bfsWithLevel(colleagueRelationshipGraph, 1);
    }

    public static void bfsWithLevel(Map<Integer, ArrayList<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        int answer = 0;
        int count = 0;

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty() && count < 2) {
            int levelSize = queue.size(); // 현재 레벨의 크기

            for (int i = 0; i < levelSize; i++) {
                int currentNode = queue.poll();
                List<Integer> neighbors = graph.get(currentNode);

                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        answer++;
                    }
                }
            }
            count++;
        }
        System.out.println(answer);
    }


}
