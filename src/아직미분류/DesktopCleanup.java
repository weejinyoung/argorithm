package 아직미분류;

import java.util.HashMap;
import java.util.Map;



class DesktopCleanup {
    Map<String, Integer> maxMinMap = new HashMap<>();

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        maxMinMap.put("maxX", 0);
        maxMinMap.put("maxY", 0);
        maxMinMap.put("minX", wallpaper.length);
        maxMinMap.put("minY", wallpaper[0].length());

        for (int i = 0; i < wallpaper.length; i++) {
            String[] split = wallpaper[i].split("");
            for (int k = 0; k < split.length; k++) {
                if (split[k].equals("#")) {
                    storeXY(i, k);
                }
            }
        }

        answer[0] = maxMinMap.get("minX");
        answer[1] = maxMinMap.get("minY");
        answer[2] = maxMinMap.get("maxX");
        answer[3] = maxMinMap.get("maxY");

        return answer;

    }

    void storeXY(int i, int k) {
        if (i + 1 > maxMinMap.get("maxX")) {
            maxMinMap.replace("maxX", i + 1);
        }
        if (i < maxMinMap.get("minX")) {
            maxMinMap.replace("minX", i);
        }
        if (k + 1 > maxMinMap.get("maxY")) {
            maxMinMap.replace("maxY", k + 1);
        }
        if (k < maxMinMap.get("minY")) {
            maxMinMap.replace("minY", k);
        }
    }

}
