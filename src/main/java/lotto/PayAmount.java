package lotto;

public class PayAmount {

    private long payAmount;
    public PayAmount(long payAmount) {
        this.payAmount = payAmount;
    }

    public boolean payable(int lottoAmount) {
        return this.payAmount >= lottoAmount;
    }

    public void pay(int lottoAmount) {
        this.payAmount -= lottoAmount;
    }

    public double calculateProfitRate(int sumProfit) {
        if (sumProfit < 1) {
            return 0;
        }
        return (double) sumProfit / this.payAmount;
    }
}
