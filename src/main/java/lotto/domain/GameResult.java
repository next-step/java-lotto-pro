package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
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
        return 3 + "개 일치 (" + Prize.THREE_MATCH_PRIZE.getPrizeMoney() + "원)- " + gameResult.get(3) + "개\n" +
                4 + "개 일치 (" + Prize.FOUR_MATCH_PRIZE.getPrizeMoney() + "원)- " + gameResult.get(4) + "개\n" +
                5 + "개 일치 (" + Prize.FIVE_MATCH_PRIZE.getPrizeMoney() + "원)- " + gameResult.get(5) + "개\n" +
                6 + "개 일치 (" + Prize.SIX_MATCH_PRIZE.getPrizeMoney() + "원)- " + gameResult.get(6) + "개";
    }

    public int getPrize() {
        return gameResult.get(3) * Prize.THREE_MATCH_PRIZE.getPrizeMoney()
                + gameResult.get(4) * Prize.FOUR_MATCH_PRIZE.getPrizeMoney()
                + gameResult.get(5) * Prize.FIVE_MATCH_PRIZE.getPrizeMoney()
                + gameResult.get(6) * Prize.SIX_MATCH_PRIZE.getPrizeMoney();
    }

    public Integer getMatchCount(int matchCount) {
        return gameResult.get(matchCount);
    }
}
