package study.step3.domain.lottostatistics;

public class LottoRateOfReturn {

    private static final String REVENUE_RESULT = "수익";
    private static final String LOSS_RESULT = "손해";
    private final double rateOfReturn;

    public LottoRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public double rate() {
        return this.rateOfReturn;
    }

    public String result() {
        return this.rateOfReturn > 0 ? REVENUE_RESULT : LOSS_RESULT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoRateOfReturn that = (LottoRateOfReturn) o;

        return Double.compare(that.rateOfReturn, rateOfReturn) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(rateOfReturn);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return String.valueOf(rateOfReturn);
    }
}
