package lotto_auto.model;

import lotto_auto.dto.Profit;

public class ProfitRate {
    private final double rate;
    private static final int ZERO_VALUE = 0;

    public ProfitRate(Money money, Profit profit) {
        if (isZero(money, profit)) {
            this.rate = ZERO_VALUE;
            return;
        }
        this.rate = (float) profit.getProfit() / money.getMoney();
    }

    private boolean isZero(Money money, Profit profit) {
        return money.getMoney() == ZERO_VALUE || profit.getProfit() == ZERO_VALUE;
    }
    public String printRate() {
        return String.format("%.2f",rateFloor());
    }

    private double rateFloor() {
        double forCutHundredths = 100.0;
        return Math.floor(rate* forCutHundredths)/ forCutHundredths;
    }
}
