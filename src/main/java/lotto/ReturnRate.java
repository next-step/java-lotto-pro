package lotto;

public class ReturnRate {

    private final LottoPurchaseAmount lottoPurchaseAmount;
    private final TotalWinningMoneyCalculator winningMoneyCalculator;

    public ReturnRate(LottoPurchaseAmount lottoPurchaseAmount, TotalWinningMoneyCalculator winningMoneyCalculator) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
        this.winningMoneyCalculator = winningMoneyCalculator;
    }

    public double calculate() {
        return (double) winningMoneyCalculator.sum() / (double) lottoPurchaseAmount.getNumber();
    }
}
