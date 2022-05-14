package lotto_auto.model;

public class Profit {
    int profit;

    Profit() {
        this.profit = 0;
    }

    void addProfit(int num) {
        this.profit += num;
    }

    public int getProfit() {
        return profit;
    }
}
