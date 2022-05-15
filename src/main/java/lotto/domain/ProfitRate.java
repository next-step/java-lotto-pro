package lotto.domain;

import lotto.utils.DoubleSplit;

public class ProfitRate {

    private final double winnings;
    private final double purchaseAmount;

    public ProfitRate(int winnings, int purchaseAmount) {
        this.winnings = winnings;
        this.purchaseAmount = purchaseAmount;
    }

    public double getRate() {
        double rate = winnings / purchaseAmount;
        return Math.floor(rate * DoubleSplit.TWO_DECIMAL_PLACES.getDigit()) / DoubleSplit.TWO_DECIMAL_PLACES.getDigit();
    }
}
