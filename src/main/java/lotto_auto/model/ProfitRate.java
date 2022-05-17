package lotto_auto.model;

public class ProfitRate {
    private final double rate;
    private static final int ZERO_VALUE = 0;

    public ProfitRate(Money money, int profit) {
        if (isZero(money, profit)) {
            this.rate = ZERO_VALUE;
            return;
        }
        this.rate = (double) profit / money.getMoney();
    }

    private boolean isZero(Money money, int profit) {
        return money.getMoney() == ZERO_VALUE || profit == ZERO_VALUE;
    }

    public String printRate() {
        return String.format("%.2f",rateFloor());
    }

    public boolean isNegativeProfitRate() {
        return !(rate > 1);
    }

    private double rateFloor() {
        double forCutHundredths = 100.0;
        return Math.floor(rate* forCutHundredths)/ forCutHundredths;
    }
}
