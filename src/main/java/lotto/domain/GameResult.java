package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    public static final int THREE_MATCH_PRIZE = 5000;
    public static final int FOUR_MATCH_PRIZE = 50000;
    public static final int FIVE_MATCH_PRIZE = 1500000;
    public static final int SIX_MATCH_PRIZE = 2000000000;
    Map<Integer, Integer> gameResult;

    public GameResult() {
        gameResult = new HashMap<>();
        gameResult.put(3, 0);
        gameResult.put(4, 0);
        gameResult.put(5, 0);
        gameResult.put(6, 0);
    }

    public void add(int sameNumberCount) {
        if (gameResult.containsKey(sameNumberCount)) {
            gameResult.put(sameNumberCount, gameResult.get(sameNumberCount) + 1);
        }
        if (!gameResult.containsKey(sameNumberCount)) {
            gameResult.put(sameNumberCount, 1);
        }
    }

    @Override
    public String toString() {
        return 3 + "개 일치 (" + THREE_MATCH_PRIZE + "원)- " + gameResult.get(3) + "개\n" +
                4 + "개 일치 (" + FOUR_MATCH_PRIZE + "원)- " + gameResult.get(4) + "개\n" +
                5 + "개 일치 (" + FIVE_MATCH_PRIZE + "원)- " + gameResult.get(5) + "개\n" +
                6 + "개 일치 (" + SIX_MATCH_PRIZE + "원)- " + gameResult.get(6) + "개";
    }

    public int getPrize() {
        return gameResult.get(3) * THREE_MATCH_PRIZE
                + gameResult.get(4) * FOUR_MATCH_PRIZE
                + gameResult.get(5) * FIVE_MATCH_PRIZE
                + gameResult.get(6) * SIX_MATCH_PRIZE;
    }
}
