package lotto.domain;

import java.util.Optional;

public enum Prize {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.countOfMatch = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int countOfMatch, boolean matchBonus) {
        Optional<Prize> prizeResult = Optional.empty();
        prizeResult = getSecondPrize(countOfMatch, matchBonus, prizeResult);
        for (Prize prize : values()) {
            prizeResult = getPrize(countOfMatch, prizeResult, prize);
        }
        return prizeResult.get();
    }

    private static Optional<Prize> getSecondPrize(int countOfMatch, boolean matchBonus, Optional<Prize> prizeResult) {
        if (countOfMatch == SECOND.countOfMatch && matchBonus) {
            prizeResult = Optional.of(SECOND);
        }
        return prizeResult;
    }

    private static Optional<Prize> getPrize(int countOfMatch, Optional<Prize> prizeResult, Prize prize) {
        boolean matchCondition = countOfMatch == prize.countOfMatch;
        if (matchCondition && prize != SECOND && !prizeResult.isPresent()) {
            prizeResult = Optional.of(prize);
        }
        return prizeResult;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}