package study.step3.domain.lottostatistics;

import study.step3.domain.lotto.Money;
import study.step3.domain.lotto.PurchaseMoney;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoRateOfReturn {

    public static final int WINNING_DIVIDE_PURCHASE_MONEY_SCALE = 2;
    public static final String REVENUE_RESULT = "수익";
    public static final String LOSS_RESULT = "손해";
    private final double rateOfReturn;

    public LottoRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public static LottoRateOfReturn of(PurchaseMoney purchaseMoney, Money winningMoney) {
        double rateOfReturn = BigDecimal.valueOf(winningMoney.money())
                .divide(BigDecimal.valueOf(purchaseMoney.money()), WINNING_DIVIDE_PURCHASE_MONEY_SCALE, RoundingMode.DOWN)
                .doubleValue();
        return new LottoRateOfReturn(rateOfReturn);
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
