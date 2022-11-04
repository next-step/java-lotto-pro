package lotto.winning.ui.outputView;

import lotto.lotto.domain.LottoMoney;
import lotto.winning.domain.ReturnRate;
import lotto.winning.domain.TotalWinningMoney;

import static lotto.winning.domain.WinningMoneyType.find;

public class WinningResultOutputVeiw {

    public static void winningResult(TotalWinningMoney totalWinningMoney, LottoMoney lottoMoney) {
        winningMoney(totalWinningMoney);
        returnRate(new ReturnRate(lottoMoney, totalWinningMoney));
    }

    public static void winningMoney(TotalWinningMoney totalWinningMoney) {
        System.out.println("당첨통계");
        System.out.println("--------------");
        for (Integer matchCount : totalWinningMoney.getWinningMonies().keySet()) {
            System.out.print(matchCount + "개 일치 ");
            System.out.print("(" + find(matchCount).getMoney() + "원)-");
            System.out.println(totalWinningMoney.getWinningMonies().get(matchCount).getNumber() + "개");
        }
    }

    public static void returnRate(ReturnRate returnRate) {
        System.out.println("총 수익률은 " + returnRate.calculate() + "입니다");
    }
}
