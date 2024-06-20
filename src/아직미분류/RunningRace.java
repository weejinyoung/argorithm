package 아직미분류;

import java.util.*;

public class RunningRace {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        Map<String, Integer> playerHashSet = new HashMap<>();

        int rank = 0;
        for (String player : players) {
            playerHashSet.put(player,rank++);
        }

        for (String calling : callings) {
            pass(playerHashSet, players, calling);
        }

    }

    static void pass(Map<String, Integer> playerHashSet, String[] players, String calledPlayer) {
        int calledPlayerRank = playerHashSet.get(calledPlayer);
        String aheadPlayer = players[calledPlayerRank-1];
        playerHashSet.put(aheadPlayer, calledPlayerRank);
        playerHashSet.put(calledPlayer, calledPlayerRank-1);
        players[calledPlayerRank-1] = calledPlayer;
        players[calledPlayerRank] = aheadPlayer;
    }
}
