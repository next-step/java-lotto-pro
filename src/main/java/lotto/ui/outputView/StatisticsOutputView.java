package lotto.ui.outputView;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.domain.WinningMoney;

import static lotto.domain.WinningMoney.find;

public class StatisticsOutputView {

    public static void winningResult(Statistics statistics) {
        winningMoney(statistics);
        returnRate(statistics);
    }

    private static void returnRate(Statistics statistics) {
        System.out.println("총 수익률은 " + statistics.returnRate() + "입니다");
    }

    public static void winningMoney(Statistics statistics) {
        System.out.println("당첨통계");
        System.out.println("--------------");
        for (WinningMoney winningMoney : WinningMoney.values()) {
            if (winningMoney.equals(WinningMoney.NONE)) {
                continue;
            }
            System.out.print(winningMoney.getMessage());
            System.out.print(winningMoney.getMoney() + "원");
            if (winningMoney.getCount() == 5) {
                Lottos lottos = statistics.lottosMap().get(winningMoney.getCount());
                Lottos five_bonus = new Lottos();
                Lottos five = new Lottos();
                for (Lotto lotto : lottos.getLottos()) {
                    if (lotto.getNumbers().contains(statistics.getWinningNumber().getBonusBall().getNumber())) {
                        five_bonus.add(lotto);
                    } else {
                        five.add(lotto);
                    }
                }
            }
            System.out.println(statistics.lottosMap().get(winningMoney.getCount()).getLottos().size() + "개");
        }
    }
}
