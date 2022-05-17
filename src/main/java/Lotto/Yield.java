package Lotto;

import Lotto.enums.CompareEnum;

import java.math.BigDecimal;
import java.util.Map;

public class Yield {
    private BigDecimal sumMoney = BigDecimal.ZERO;
    private int investment;
    private double yield;

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public int getInvestment() {
        return investment;
    }

    public double getYield() {
        return yield;
    }

    public Yield(int money) {
        investment = money;
    }

    void yieldCalcution(Map<CompareEnum, Integer> hitList) {
        CompareEnum.valuesExcludeNone()
                .stream()
                .filter(compareEnum -> hitList.get(compareEnum) != null && hitList.get(compareEnum) > 0)
                .forEach(compareEnum -> sumMoney = sumMoney.add(new BigDecimal(hitList.get(compareEnum) * compareEnum.getWinningAmount())));

        if(sumMoney.compareTo(BigDecimal.ZERO) == 1) {
            yield = sumMoney.divide(new BigDecimal(investment), 2, BigDecimal.ROUND_CEILING).doubleValue();
        }
    }
}
