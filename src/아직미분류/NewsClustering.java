package 아직미분류;

import java.util.*;

class NewsClustering {


    String[] toMultipleSet(String target) {
        String[] targetUpperCaseSplit = target.toUpperCase().split("");
        List<String> targetMultipleSet = new ArrayList<>();

        for (int i = 0; i < target.length() - 1; i++) {
            if (targetUpperCaseSplit[i].matches("^[a-zA-Z]*$") && targetUpperCaseSplit[i + 1].matches("^[a-zA-Z]*$")) {
                targetMultipleSet.add(targetUpperCaseSplit[i] + targetUpperCaseSplit[i + 1]);
            }
        }
        return targetMultipleSet.toArray(String[]::new);
    }

    Map<String, Integer> getDuplicateMap(String[] target) {
        Map<String, Integer> targetDupMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            if (!targetDupMap.containsKey(target[i])) {
                targetDupMap.put(target[i], 1);
                for (int j = i + 1; j < target.length; j++) {
                    if (target[j].equals(target[i])) {
                        int count = targetDupMap.get(target[j]);
                        count++;
                        targetDupMap.replace(target[j], count);
                    }
                }
            }
        }
        return targetDupMap;
    }

    double getJacquardSimilarity(String[] first, String[] second) {
        Map<String, Integer> firstDupMap = getDuplicateMap(first);
        Map<String, Integer> secondDupMap = getDuplicateMap(second);
        int intersectionSize = 0;
        int unionSize = 0;

        Set<String> allKeySet = new HashSet<>(firstDupMap.keySet());
        allKeySet.addAll(secondDupMap.keySet());

        for (String key : allKeySet) {
            if (firstDupMap.containsKey(key) && secondDupMap.containsKey(key)) {
                intersectionSize += Math.min(firstDupMap.get(key), secondDupMap.get(key));
                unionSize += Math.max(firstDupMap.get(key), secondDupMap.get(key));
            } else if (firstDupMap.containsKey(key) && !secondDupMap.containsKey(key)) {
                unionSize += firstDupMap.get(key);
            } else if (!firstDupMap.containsKey(key) &&secondDupMap.containsKey(key)) {
                unionSize += secondDupMap.get(key);
            }
        }

        return intersectionSize == 0 && unionSize == 0 ? 1 : (double) intersectionSize / unionSize;
    }

    public int solution(String str1, String str2) {

        String[] str1MultipleSet = toMultipleSet(str1);
        String[] str2MultipleSet = toMultipleSet(str2);

        double jacquardSimilarity = getJacquardSimilarity(str1MultipleSet, str2MultipleSet);

        return (int) (jacquardSimilarity * 65536);
    }
}
