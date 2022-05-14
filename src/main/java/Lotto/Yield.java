package Lotto;

import java.math.BigDecimal;

public class Yield {
    BigDecimal sumMoney = BigDecimal.ZERO;
    int investment;
    double yield;

    public double getYield() {
        return yield;
    }

    private static final int FIRST_WiNNING_AMOUNT = 2_000_000_000;
    private static final int SECOND_WiNNING_AMOUNT = 1_500_000;
    private static final int THIRD_WiNNING_AMOUNT = 50_000;
    private static final int FOURTH_WiNNING_AMOUNT = 5_000;

    Yield(int money) {
        investment = money;
    }

    void yieldCalcution(LottoResult lottoResult) {
        if(lottoResult.getFirstCount() > 0)
            sumMoney = sumMoney.add(new BigDecimal(lottoResult.getFirstCount() * FIRST_WiNNING_AMOUNT));

        if(lottoResult.getSecondCount() > 0)
            sumMoney = sumMoney.add(new BigDecimal(lottoResult.getSecondCount() * SECOND_WiNNING_AMOUNT));

        if(lottoResult.getThirdCount() > 0)
            sumMoney = sumMoney.add(new BigDecimal(lottoResult.getThirdCount() * THIRD_WiNNING_AMOUNT));

        if(lottoResult.getFourthCount() > 0)
            sumMoney = sumMoney.add(new BigDecimal(lottoResult.getFourthCount() * FOURTH_WiNNING_AMOUNT));

        if(sumMoney.compareTo(BigDecimal.ZERO) == 1) {
            yield = sumMoney.divide(new BigDecimal(investment), 2, BigDecimal.ROUND_CEILING).doubleValue();
        }
    }
}
