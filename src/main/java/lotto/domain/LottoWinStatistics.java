package lotto.domain;

import generic.Money;
import generic.Rate;
import java.util.Objects;

public class LottoWinStatistics {
    private static final double EMPTY_VALUE = 0.0;
    private static final double LOSS_RETURN_RATE = 1.0;
    private final Money price;
    private final LottoWinResultGroup winResultGroup;
    private final Rate returnRate;

    public LottoWinStatistics(final Money price, final LottoWinResultGroup winResultGroup) {
        this.price = price;
        this.winResultGroup = winResultGroup;
        this.returnRate = calculate();
    }

    private Rate calculate() {
        if (winResultGroup.totalWinningPrice().isZero()) {
            return Rate.valueOf(EMPTY_VALUE);
        }

        return winResultGroup.totalWinningPrice().divide(price);
    }

    public Rate getReturnRate() {
        return returnRate;
    }

    public long countByWinResult(final LottoWinResult lottoWinResult) {
        return winResultGroup.countByWinResult(lottoWinResult);
    }

    public boolean isLoss() {
        return returnRate.getValue() < LOSS_RETURN_RATE;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoWinStatistics)) {
            return false;
        }
        final LottoWinStatistics that = (LottoWinStatistics) o;
        return Objects.equals(price, that.price) && Objects.equals(winResultGroup, that.winResultGroup)
                && Objects.equals(returnRate, that.returnRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, winResultGroup, returnRate);
    }

    @Override
    public String toString() {
        return "LottoWinStatistics{" +
                "price=" + price +
                ", winResultGroup=" + winResultGroup +
                ", returnRate=" + returnRate +
                '}';
    }
}
