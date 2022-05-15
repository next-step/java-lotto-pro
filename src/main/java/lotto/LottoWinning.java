package lotto;

import java.util.Objects;

public class LottoWinning {
    private double profit;

    public LottoWinning() {
    }

    public LottoWinning(double profit) {
        this.profit = profit;
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
