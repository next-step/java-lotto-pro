package lotto;

import java.util.List;
import java.util.Objects;

public class LottoWinning {
    private final static double ROUNDING_DIGIT_VALUE = 100d;

    private final LottoPurchase lottoPurchase;
    private final int purchasePrice;
    private final int winningPrice;
    private final double profit;

    public LottoWinning(LottoPurchase lottoPurchase, List<Integer> answerList) {
        this.lottoPurchase = lottoPurchase;
        this.purchasePrice = this.lottoPurchase.issuedLottoPurchasePrice();
        this.winningPrice = this.lottoPurchase.calculateWinningLottoTotalPrice(answerList);
        this.profit = calculateProfit(this.winningPrice, this.purchasePrice);
    }

    private double calculateProfit(int winningPrice, int purchasePrice) {
        return Math.round(((double) winningPrice / (double) purchasePrice) * ROUNDING_DIGIT_VALUE) / ROUNDING_DIGIT_VALUE;
    }
    
    public double getProfit() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinning that = (LottoWinning) o;
        return Double.compare(that.profit, profit) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit);
    }
}
