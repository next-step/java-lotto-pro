package lotto.winning.ui.outputView;

import lotto.lotto.domain.LottoMoney;
import lotto.winning.domain.TotalWinningMoney;

import static lotto.winning.domain.WinningMoneyType.find;

public class WinningResultOutputView {

    public static void winningResult(TotalWinningMoney totalWinningMoney, LottoMoney lottoMoney) {
        winningMoney(totalWinningMoney);
        returnRate(lottoMoney, totalWinningMoney);
    }

    private static void returnRate(LottoMoney lottoMoney, TotalWinningMoney totalWinningMoney) {
        System.out.println("총 수익률은 " + totalWinningMoney.returnRate(lottoMoney.getNumber()) + "입니다");
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
}
