package lotto;

import java.util.List;

public class TotalWinningMoneyCalculator {

    private List<WinningMoneyCalculator> calculators;

    public TotalWinningMoneyCalculator(List<WinningMoneyCalculator> calculators) {
        this.calculators = calculators;
    }

    public long sum() {
        long sum = 0;
        for (WinningMoneyCalculator winningMoneyCalculator : this.calculators) {
            sum += winningMoneyCalculator.calculate();
        }
        return sum;
    }
}
