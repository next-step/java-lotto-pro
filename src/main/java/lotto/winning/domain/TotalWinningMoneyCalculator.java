package lotto.winning.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalWinningMoneyCalculator {

    private List<WinningMoneyCalculator> calculators = new ArrayList<>();

    public TotalWinningMoneyCalculator(List<WinningMoneyCalculator> calculators) {
        this.calculators = calculators;
    }

    public List<WinningMoneyCalculator> getCalculators() {
        return this.calculators;
    }

    public long sum() {
        long sum = 0;
        for (WinningMoneyCalculator winningMoneyCalculator : this.calculators) {
            sum += winningMoneyCalculator.calculate();
        }
        return sum;
    }
}
