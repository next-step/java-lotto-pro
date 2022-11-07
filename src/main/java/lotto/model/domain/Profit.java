package lotto.model.domain;

public class Profit {

    private double profit;

    public Profit(long buyAmount, long winAmount) {
        this.profit = Math.floor(winAmount * 1.0 / buyAmount * 100) / 100.0;
    }

    public void print() {
        System.out.print("총 수익률은 " + this.profit + "입니다.");
        if (profit < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println();
    }

    public double getProfit() {
        return profit;
    }
}
