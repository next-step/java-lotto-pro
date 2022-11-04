package lotto.winning.domain;

import lotto.winning.domain.TotalWinningMoneyCalculator;
import lotto.winning.domain.WinningMoneyCalculator;

import java.util.ArrayList;
import java.util.List;

public class TotalWinningMoneyCalculatorFixture {
    public static TotalWinningMoneyCalculator 당첨금액_5000() {
        List<WinningMoneyCalculator> winningMoneyCalculatorList = new ArrayList<>();
        winningMoneyCalculatorList.add(new WinningMoneyCalculator(3, 1));
        return new TotalWinningMoneyCalculator(winningMoneyCalculatorList);
    }
}
