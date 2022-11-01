package lottoauto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class LottoReturnRate {
    public static final int ZERO = 0;
    private BigDecimal returnRate;
    public LottoReturnRate(BigDecimal returnRate) {
        this.returnRate = returnRate;
    }
    public LottoReturnRate(long winningMoney, int payment) {
        validatePayment(payment);
        this.returnRate = new BigDecimal(String.valueOf(winningMoney)).divide(new BigDecimal(String.valueOf(payment)));
    }

    private void validatePayment(int payment) {
        if(payment <= ZERO ){
            throw new IllegalArgumentException("구매금액은 0보다 커야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoReturnRate that = (LottoReturnRate) o;
        return Objects.equals(returnRate, that.returnRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnRate);
    }

    @Override
    public String toString() {
        return returnRate.toPlainString();
    }
}
