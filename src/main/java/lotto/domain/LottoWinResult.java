package lotto.domain;

import generic.Money;
import java.util.Arrays;
import java.util.List;

public enum LottoWinResult {

    FIRST(6, Money.valueOf(2_000_000_000)),
    SECOND(5, Money.valueOf(30_000_000)),
    THIRD(5, Money.valueOf(1_500_000)),
    FOURTH(4, Money.valueOf(50_000)),
    FIFTH(3, Money.valueOf(5_000)),
    NO_WIN(-1, Money.valueOf(0)),
    ;

    public static final List<LottoWinResult> WIN_RESULTS = Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    private final int winningCount;
    private final Money winningMoney;

    LottoWinResult(final int winningCount, final Money winningMoney) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
    }

    public static LottoWinResult confirm(final int count, final boolean bonusCorrect) {
        if (isSecond(count, bonusCorrect)) {
            return SECOND;
        }

        return findWinResult(count);
    }

    private static boolean isSecond(final int count, final boolean bonusCorrect) {
        return count == SECOND.winningCount && bonusCorrect;
    }

    private static LottoWinResult findWinResult(final int count) {
        return WIN_RESULTS.stream()
                .filter(winResult -> winResult.winningCount == count)
                .findFirst()
                .orElse(NO_WIN);
    }

    public Money price(final Long value) {
        return this.winningMoney.times(value);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public boolean isSecond() {
        return this == SECOND;
    }
}
