package lotto.domain;

import java.util.Objects;

public class RateOfReturn {

    private static final int STANDARD_RATE_OF_RETURN = 1;
    private static final int DEFAULT_RATE_OF_RETURN = 0;
    private final double rateOfReturn;

    private RateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public static RateOfReturn from(double rateOfReturn) {
        if (isPositive(rateOfReturn)) {
            return new RateOfReturn(DEFAULT_RATE_OF_RETURN);
        }
        return new RateOfReturn(rateOfReturn);
    }

    private static boolean isPositive(double rateOfReturn) {
        return rateOfReturn < DEFAULT_RATE_OF_RETURN;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public boolean isRateOfReturnLessThenStandard() {
        return rateOfReturn < STANDARD_RATE_OF_RETURN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateOfReturn that = (RateOfReturn) o;
        return Double.compare(that.getRateOfReturn(), getRateOfReturn()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRateOfReturn());
    }

    @Override
    public String toString() {
        return String.format("%.2f", rateOfReturn);
    }

}
