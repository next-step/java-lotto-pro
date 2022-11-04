package lotto.winning.ui.outputView;

import lotto.winning.domain.ReturnRate;
import lotto.winning.domain.TotalWinningMoneyCalculator;
import lotto.winning.domain.WinningMoneyCalculator;

public class WinningResultOutputVeiw {

    public static void winningMoney(TotalWinningMoneyCalculator totalWinningMoneyCalculator) {
        for (WinningMoneyCalculator calculator : totalWinningMoneyCalculator.getCalculators()) {
            System.out.print(calculator.getMatchCount() + "개 일치");
            System.out.print(calculator.calculate() + "원");
            System.out.println(calculator.getLottoCount() + "개");
        }
    }

    public static void returnRate(ReturnRate returnRate) {
        System.out.println("총 수익률은 " + returnRate.calculate() + "입니다");
    }
}
