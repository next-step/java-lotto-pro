package lotto.domain;

import static generic.Money.valueOf;

import generic.Money;
import java.util.Arrays;
import java.util.List;

public enum LottoWinResult {

    FIRST(6, Money.valueOf(2000000000)),
    SECOND(5, Money.valueOf(1500000)),
    THIRD(4, Money.valueOf(50000)),
    FOURTH(3, Money.valueOf(5000)),
    NO_WIN(-1, Money.valueOf(0)),
    ;

    public static final List<LottoWinResult> WIN_RESULTS = Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    private final int winningCount;
    private final Money winningMoney;


    LottoWinResult(final int winningCount, final Money winningMoney) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
    }

    public static LottoWinResult confirm(final int count) {
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
}
