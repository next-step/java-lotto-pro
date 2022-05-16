package lotto.domain;

import lotto.utils.DoubleSplit;

public class Winnings {
    private int winningsPrice;

    public Winnings(int winningsPrice) {
        this.winningsPrice = winningsPrice;
    }

    public double profitRate(double purchaseAmount) {
        double rate =  this.getWinningsPrice() / purchaseAmount;
        return Math.floor(rate * DoubleSplit.TWO_DECIMAL_PLACES.getDigit()) / DoubleSplit.TWO_DECIMAL_PLACES.getDigit();
    }

    public int getWinningsPrice() {
        return winningsPrice;
    }
}
