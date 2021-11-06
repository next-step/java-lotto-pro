package lotto;

import java.util.Objects;

public class EarningRate {
    private final double rate;

    public EarningRate(double rate) {
        this.rate = rate;
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
        return Double.compare(that.rate, rate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }
}
