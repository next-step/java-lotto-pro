package lotto.model;

import java.util.Objects;

public class RateOfReturn {
    static final String NEGATIVE_VALUE_ERR_MSG = "수익률은 0보다 작은 값일 수 없습니다.";
    private static final int MIN = 0;
    private static final int BREAK_EVEN_RATE = 1;

    private final double rateOfReturn;

    public RateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
        validate();
    }

    private void validate() {
        if (rateOfReturn < MIN) {
            throw new IllegalArgumentException(NEGATIVE_VALUE_ERR_MSG);
        }
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
