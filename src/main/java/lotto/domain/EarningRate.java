package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EarningRate {
    public static final EarningRate ZERO = new EarningRate(BigDecimal.ZERO);

    private static final int DECIMAL_SCALE = 2;
    private final BigDecimal rate;

    public EarningRate(BigDecimal rate) {
        this.rate = rate.setScale(DECIMAL_SCALE, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EarningRate)) {
            return false;
        }
        EarningRate that = (EarningRate)o;
        return Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    public BigDecimal getRate() {
        return rate;
    }
}
