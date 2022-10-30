package step3.domain;

public class Rate {
    private final double rate;
    private static final int ZERO_VALUE = 0;

    public Rate(Money money, int profit) {
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

    private double rateFloor() {
        double forCutHundredths = 100.0;
        return Math.floor(rate* forCutHundredths)/ forCutHundredths;
    }
}
