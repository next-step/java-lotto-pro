package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    public static final int DEFAULT_VALUE = 0;
    public static final int INCREASE_AMOUNT = 1;
    public static final int PRIZE_MONEY_DEFAULT = 0;

    private final Map<Prize, Integer> gameResult;

    public GameResult() {
        gameResult = new HashMap<>();
    }

    public void add(Prize prize) {
        gameResult.put(prize, gameResult.getOrDefault(prize, DEFAULT_VALUE) + INCREASE_AMOUNT);
    }

    public int getPrize() {
        int prizeMoney = PRIZE_MONEY_DEFAULT;
        for (Prize prize : Prize.values()) {
            prizeMoney += gameResult.getOrDefault(prize, DEFAULT_VALUE) * prize.getPrizeMoney();
        }
        return prizeMoney;
    }

    public Integer getMatchCount(Prize prize) {
        return gameResult.getOrDefault(prize, DEFAULT_VALUE);
    }
}
