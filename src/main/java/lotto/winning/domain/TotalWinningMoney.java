package lotto.winning.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalWinningMoney {

    private List<WinningMoney> winningMonies = new ArrayList<>();

    protected TotalWinningMoney() {}

    public TotalWinningMoney(int threeMatchCount, int fourMatchCount, int fiveMatchCount, int sixMatchCount) {
        winningMonies.add(new WinningMoney(3, threeMatchCount));
        winningMonies.add(new WinningMoney(4, fourMatchCount));
        winningMonies.add(new WinningMoney(5, fiveMatchCount));
        winningMonies.add(new WinningMoney(6, sixMatchCount));
    }

    public List<WinningMoney> getCalculators() {
        return this.winningMonies;
    }

    public long sum() {
        long sum = 0;
        for (WinningMoney winningMoney : this.winningMonies) {
            sum += winningMoney.calculate();
        }
        return sum;
    }
}
