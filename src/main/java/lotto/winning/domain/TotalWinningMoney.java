package lotto.winning.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalWinningMoney {

    private List<WinningMoney> calculators = new ArrayList<>();

    public TotalWinningMoney(List<WinningMoney> calculators) {
        this.calculators = calculators;
    }

    public List<WinningMoney> getCalculators() {
        return this.calculators;
    }

    public long sum() {
        long sum = 0;
        for (WinningMoney winningMoney : this.calculators) {
            sum += winningMoney.calculate();
        }
        return sum;
    }
}
