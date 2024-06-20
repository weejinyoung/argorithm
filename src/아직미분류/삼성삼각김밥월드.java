package 아직미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 삼성삼각김밥월드 {

    private static int findLevel(int target) {
        int level = 1;
        while ((level * (level + 1)) / 2 < target) {
            level++;
        }
        return level;
    }

    // (n*(a+l))/2
    private static int findDistance(int s, int e) {
        int top = Math.min(s, e);
        int bottom = Math.max(s, e);
        int topLevel = findLevel(top);
        int bottomLevel = findLevel(bottom);
        if (topLevel == bottomLevel) {
            return bottom - top;
        }
        int levelDiff = bottomLevel - topLevel;
        int left = top + ((levelDiff * (topLevel + ((topLevel + levelDiff) - 1))) / 2);
        int right = left + levelDiff;
        if (bottom >= left && bottom <= right) {
            return bottomLevel - topLevel;
        }
        if (bottom < left) {
            return (bottomLevel - topLevel) + (left - bottom);
        }
        return (bottomLevel - topLevel) + (bottom - right);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append("#").append(i).append(" ").append(findDistance(s, e)).append("\n");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
