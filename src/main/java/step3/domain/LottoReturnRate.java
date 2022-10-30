package step3.domain;

import java.util.Objects;

public class LottoReturnRate {
    public static final int ZERO = 0;
    private double returnRate;
    public LottoReturnRate(){}
    public LottoReturnRate(double returnRate){
        this.returnRate = returnRate;
    }
    public void calculateReturnRate(int winningMoney, int payment) {
        validatePayment(payment);
        returnRate = winningMoney / (double)payment ;
    }

    private void validatePayment(int payment) {
        if(payment <= ZERO){
            throw new IllegalArgumentException("구매금액은 0보다 커야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoReturnRate that = (LottoReturnRate) o;
        return Double.compare(that.returnRate, returnRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnRate);
    }

    @Override
    public String toString() {
        return String.valueOf(returnRate);
    }
}
