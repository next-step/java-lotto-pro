package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    public static final int DEFAULT_VALUE = 0;
    public static final int INCREASE_AMOUNT = 1;
    private final Prize threeMatchPrize = Prize.THREE_MATCH_PRIZE;
    private final Prize fourMatchPrize = Prize.FOUR_MATCH_PRIZE;
    private final Prize fiveMatchPrize = Prize.FIVE_MATCH_PRIZE;
    private final Prize sixMatchPrize = Prize.SIX_MATCH_PRIZE;
    Map<Integer, Integer> gameResult;

    public GameResult() {
        gameResult = new HashMap<>();
    }

    public void add(int sameNumberCount) {
        gameResult.put(sameNumberCount, gameResult.getOrDefault(sameNumberCount, DEFAULT_VALUE) + INCREASE_AMOUNT);
    }

    public int getPrize() {
        return gameResult.getOrDefault(threeMatchPrize.getMatchCount(), DEFAULT_VALUE) * threeMatchPrize.getPrizeMoney()
                + gameResult.getOrDefault(fourMatchPrize, DEFAULT_VALUE) * fourMatchPrize.getPrizeMoney()
                + gameResult.getOrDefault(fiveMatchPrize, DEFAULT_VALUE) * fiveMatchPrize.getPrizeMoney()
                + gameResult.getOrDefault(sixMatchPrize, DEFAULT_VALUE) * sixMatchPrize.getPrizeMoney();
    }

    public Integer getMatchCount(int matchCount) {
        return gameResult.getOrDefault(matchCount, DEFAULT_VALUE);
    }
}
