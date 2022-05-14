package lotto_auto.model;

public class ProfitRate {
    private final double rate;

    public ProfitRate(Money money, Profit profit) {
        if (isZero(money, profit)) {
            this.rate = 0;
            return;
        }
        this.rate = (float) profit.getProfit() / money.getMoney();
    }

    private boolean isZero(Money money, Profit profit) {
        return money.getMoney() == 0 || profit.getProfit() == 0;
    }
    public String printRate() {
        return String.format("%.2f",rateFloor());
    }

    private double rateFloor() {
        double forCutHundredths = 100.0;
        return Math.floor(rate* forCutHundredths)/ forCutHundredths;
    }
}
