package lotto.domain;

import lotto.utils.DoubleSplit;

public class Winnings {
    private long winningsPrice;

    public Winnings(long winningsPrice) {
        this.winningsPrice = winningsPrice;
    }

    public double profitRate(double purchaseAmount) {
        double rate =  this.getWinningsPrice() / purchaseAmount;
        return Math.floor(rate * DoubleSplit.TWO_DECIMAL_PLACES.getDigit()) / DoubleSplit.TWO_DECIMAL_PLACES.getDigit();
    }

    public long getWinningsPrice() {
        return winningsPrice;
    }
}
