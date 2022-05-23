package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    MISS(0, 0, (matchCount, bonus) -> matchCount < 3),
    FIFTH(3, 5_000, (matchCount, bonus) -> matchCount == 3),
    FOURTH(4, 50_000, (matchCount, bonus) -> matchCount == 4),
    THIRD(5, 1_500_000, (matchCount, bonus) -> matchCount == 5 && !bonus),
    SECOND(5, 30_000_000,(matchCount, bonus) -> matchCount == 5 && bonus),
    FIRST(6, 2_000_000_000, (matchCount, bonus) -> matchCount == 6);

    private final int matchCount;
    private final Money winningMoney;
    private final BiPredicate<Integer, Boolean> matchingExp;

    LottoRank(int matchCount, double winningMoney, BiPredicate<Integer, Boolean> exp) {
        this.matchCount = matchCount;
        this.winningMoney = new Money(winningMoney);
        this.matchingExp = exp;
    }

    public static LottoRank of(int matchCount, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.matchingExp.test(matchCount, hasBonus))
                .findFirst()
                .orElse(MISS);
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
