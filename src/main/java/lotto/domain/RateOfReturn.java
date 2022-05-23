package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RateOfReturn {
    private static final int SCALE = 2;
    private static final int CRITERIA = 1;

    private BigDecimal rateOfReturn;

    public RateOfReturn(int totalPrize, int money) {
        this.rateOfReturn = calculateRateOfReturn(totalPrize, money);
    }

    private BigDecimal calculateRateOfReturn(int totalPrize, int money) {
        return new BigDecimal(Integer.toString(totalPrize)).divide(new BigDecimal(Integer.toString(money)), SCALE, RoundingMode.HALF_UP);
    }

    public boolean isLoss() {
        return rateOfReturn.compareTo(new BigDecimal(Integer.toString(CRITERIA))) < 0;
    }

    public BigDecimal getRateOfReturn() {
        return rateOfReturn;
    }
}
