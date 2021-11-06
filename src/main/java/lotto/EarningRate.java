package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import view.Printable;

public class EarningRate implements Printable {
    private final BigDecimal rate;

    public EarningRate(BigDecimal rate) {
        this.rate = rate.setScale(2, RoundingMode.HALF_UP);
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

    @Override
    public String makePrintableMessage() {
        return String.valueOf(rate);
    }
}
