package lotto.model.domain;

public class Profit {

    private double profit;

    public Profit(long buyAmount, long winAmount) {
        this.profit = Math.floor(winAmount * 1.0 / buyAmount * 100) / 100.0;
    }

    public double getProfit() {
        return profit;
    }
}
