package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final Money winningMoney;

    LottoRank(int matchCount, double winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = new Money(winningMoney);
    }

    public static LottoRank of(int matchCount, boolean hasBonus) {
        if (isSecond(matchCount, hasBonus)) {
            return SECOND;
        }
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isSecond(int matchCount, boolean hasBonus) {
        return matchCount == SECOND.matchCount && hasBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public Money sumWinningMoney(Money moneySum) {
        return winningMoney.sumMoney(moneySum);
    }
}
