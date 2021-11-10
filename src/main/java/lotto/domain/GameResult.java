package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    public static final int DEFAULT_VALUE = 0;
    public static final int INCREASE_AMOUNT = 1;
    public static final int PRIZE_MONEY_DEFAULT = 0;

    private final Map<Integer, Integer> gameResult;

    public GameResult() {
        gameResult = new HashMap<>();
    }

    public void add(int sameNumberCount) {
        gameResult.put(sameNumberCount, gameResult.getOrDefault(sameNumberCount, DEFAULT_VALUE) + INCREASE_AMOUNT);
    }

    public int getPrize() {
        int prizeMoney = PRIZE_MONEY_DEFAULT;
        for (Prize prize : Prize.values()) {
            prizeMoney += gameResult.getOrDefault(prize.getCountOfMatch(), DEFAULT_VALUE) * prize.getPrizeMoney();
        }
        return prizeMoney;
    }

    public Integer getMatchCount(int matchCount) {
        return gameResult.getOrDefault(matchCount, DEFAULT_VALUE);
    }
}
