package lotto.ui.outputView;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningMoney;

public class StatisticsOutputView {

    public static void winningResult(Lottos lottos, WinningLotto winningLotto) {
        winningMoney(lottos, winningLotto);
        returnRate(lottos, winningLotto);
    }

    public static void winningMoney(Lottos lottos, WinningLotto winningLotto) {
        System.out.println("당첨통계");
        System.out.println("--------------");
        for (WinningMoney winningMoney : WinningMoney.values()) {
            print(lottos, winningMoney, winningLotto);
        }
    }

    private static void print(Lottos lottos, WinningMoney winningMoney, WinningLotto winningLotto) {
        if (winningMoney.isShow()) {
            System.out.print(winningMoney.getMessage());
            System.out.print(" ("+winningMoney.getMoney() + "원)");
            System.out.println(" - " + lottos.matchLottoCount(winningMoney.getCount(), winningMoney.getIsMatchBonusBalls(), winningLotto) + "개");
        }
    }

    private static void returnRate(Lottos lottos, WinningLotto winningLotto) {
        System.out.println("총 수익률은 " + lottos.returnRate(winningLotto) + "입니다");
    }
}
