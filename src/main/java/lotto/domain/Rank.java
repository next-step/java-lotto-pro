package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),
    SECOND_WITH_BONUS(5, 1, 1_500_000),
    SECOND(5, 0, 1_500_000),
    THIRD(4, 0, 50_000),
    FOURTH(3, 0, 5_000);

    private final int matchingCount;
    private final int matchingBonusCount;
    private final Money winningMoney;

    Rank(int matchingCount, int matchingBonusCount, long winningMoney) {
        this.matchingCount = matchingCount;
        this.matchingBonusCount = matchingBonusCount;
        this.winningMoney = Money.of(winningMoney);
    }

    public static Rank of(int matchingCount, int matchingBonusCount) {
        return Arrays.stream(values())
                .filter(isMatched(matchingCount))
                .filter(isMatchedBonusCount(matchingBonusCount))
                .findFirst()
                .orElse(null);
    }

    private static Predicate<Rank> isMatched(int matchingCount) {
        return rank -> rank.matchingCount == matchingCount;
    }

    private static Predicate<Rank> isMatchedBonusCount(int matchingBonusCount) {
        return rank -> rank.matchingBonusCount == 0 || rank.matchingBonusCount == matchingBonusCount;
    }

    public int getCount(Record record) {
        return record.get(this);
    }

    public Money getWinningMoney(Record record) {
        return winningMoney.multiply(getCount(record));
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }
}
