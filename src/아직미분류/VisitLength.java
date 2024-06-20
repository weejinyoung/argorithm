package 아직미분류;

import java.util.HashSet;
import java.util.Set;

public class VisitLength {

    Set<String> traceSet = new HashSet<>();
    StringBuilder trace = new StringBuilder();

    public int solution(String dirs) {
        int[] current = {0, 0};

        for (String dir : dirs.split("")) {
            switch (dir) {
                case "U" -> {
                    if (current[1] != 5) {
                        storeTrace(current[0], current[1], current[0], (current[1] + 1));
                        current[1]++;
                    }
                }
                case "D" -> {
                    if (current[1] != -5) {
                        storeTrace(current[0], current[1], current[0], (current[1] - 1));
                        current[1]--;
                    }
                }
                case "R" -> {
                    if (current[0] != 5) {
                        storeTrace(current[0], current[1], (current[0] + 1), current[1]);
                        current[0]++;
                    }
                }
                case "L" -> {
                    if (current[0] != -5) {
                        storeTrace(current[0], current[1], (current[0] - 1), current[1]);
                        current[0]--;
                    }
                }
            }
        }
        return (traceSet.size() / 2);
    }

    void storeTrace(int currentX, int currentY, int nextX, int nextY) {
        trace.append(currentX).append(currentY).append(nextX).append(nextY);
        traceSet.add(trace.toString());
        trace.setLength(0);
        trace.append(nextX).append(nextY).append(currentX).append(currentY);
        traceSet.add(trace.toString());
        trace.setLength(0);
    }
}