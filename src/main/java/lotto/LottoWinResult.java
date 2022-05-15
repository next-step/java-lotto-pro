package lotto;

import static generic.Money.wons;

import generic.Money;
import java.util.Arrays;
import java.util.List;

public enum LottoWinResult {

    FIRST(6, wons(2000000000)),
    SECOND(5, wons(1500000)),
    THIRD(4, wons(50000)),
    FOURTH(3, wons(5000)),
    NO_WIN(-1, wons(0)),
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
