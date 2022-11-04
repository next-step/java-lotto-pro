package lotto.winning.ui.outputView;

import lotto.lotto.domain.LottoMoney;
import lotto.winning.domain.ReturnRate;
import lotto.winning.domain.TotalWinningMoney;
import lotto.winning.domain.WinningMoney;

public class WinningResultOutputVeiw {

    public static void winningMoney(TotalWinningMoney totalWinningMoney) {
        for (WinningMoney calculator : totalWinningMoney.getCalculators()) {
            System.out.print(calculator.getMatchCount() + "개 일치");
            System.out.print(calculator.calculate() + "원");
            System.out.println(calculator.getLottoCount() + "개");
        }
    }

    public static void returnRate(ReturnRate returnRate) {
        System.out.println("총 수익률은 " + returnRate.calculate() + "입니다");
    }

    public static void winningResult(TotalWinningMoney totalWinningMoney, LottoMoney lottoMoney) {
        winningMoney(totalWinningMoney);
        returnRate(new ReturnRate(lottoMoney, totalWinningMoney));
    }
}
