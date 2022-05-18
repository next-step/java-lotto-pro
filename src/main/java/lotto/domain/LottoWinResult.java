package lotto.domain;

import generic.Money;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public enum LottoWinResult {

    FIRST(6, Money.valueOf(2_000_000_000), ((count, isCorrectBonus) -> count == 6)),
    SECOND(5, Money.valueOf(30_000_000), ((count, isCorrectBonus) -> count == 5 && isCorrectBonus)),
    THIRD(5, Money.valueOf(1_500_000), ((count, isCorrectBonus) -> count == 5 && !isCorrectBonus)),
    FOURTH(4, Money.valueOf(50_000), ((count, isCorrectBonus) -> count == 4)),
    FIFTH(3, Money.valueOf(5_000), ((count, isCorrectBonus) -> count == 3)),
    NO_WIN(0, Money.valueOf(0), ((count, isCorrectBonus) -> count < 3)),
    ;

    public static final List<LottoWinResult> WIN_RESULTS = Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    private final int winningCount;
    private final Money winningMoney;
    private final BiPredicate<Integer, Boolean> winPredicate;

    LottoWinResult(final int winningCount, final Money winningMoney, final BiPredicate<Integer, Boolean> winPredicate) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
        this.winPredicate = winPredicate;
    }

    public static LottoWinResult confirm(final int count, final boolean bonusCorrect) {
        return WIN_RESULTS.stream()
                .filter(winResult -> winResult.winPredicate.test(count, bonusCorrect))
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
