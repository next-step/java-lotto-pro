package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final boolean bonus;
    private final Money winningMoney;

    LottoRank(int matchCount, double winningMoney) {
        this(matchCount, false, winningMoney);
    }

    LottoRank(int matchCount, boolean bonus, double winningMoney) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.winningMoney = new Money(winningMoney);
    }

    public static LottoRank of(int matchCount, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.matchCount == matchCount)
                .map(r -> SECOND.isMatchCountAndBonus(matchCount, hasBonus) ? SECOND : r)
                .findFirst()
                .orElse(MISS);
    }

    private boolean isMatchCountAndBonus(int matchCount, boolean bonus) {
        return this.matchCount == matchCount && this.bonus == bonus;
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
