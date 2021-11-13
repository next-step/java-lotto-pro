package lotto.model;

import java.util.Objects;

import lotto.util.Validator;

public class RateOfReturn {
    private static final int BREAK_EVEN_RATE = 1;

    private final double rateOfReturn;

    public RateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
        Validator.validateNonNegative(this.rateOfReturn);
    }

    public boolean isLosingMoney() {
        return rateOfReturn < BREAK_EVEN_RATE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RateOfReturn that = (RateOfReturn)obj;
        return Double.compare(that.rateOfReturn, rateOfReturn) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateOfReturn);
    }

    @Override
    public String toString() {
        return String.format("%.2f", rateOfReturn);
    }
}
