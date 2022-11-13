package lotto.ui.outputView;

import lotto.domain.LottosMap;
import lotto.domain.WinningLotto;
import lotto.domain.WinningMoney;

public class StatisticsOutputView {

    public static final String RETURN_RATE = "총 수익률은 %.2f 입니다";
    public static final String MATCH_COUNT = " - %d 개";
    public static final String MONEY_PER = "(%s원)";

    public static void winningResult(LottosMap lottos, WinningLotto winningLotto) {
        winningMoney(lottos, winningLotto);
        returnRate(lottos, winningLotto);
    }

    public static void winningMoney(LottosMap lottos, WinningLotto winningLotto) {
        System.out.println("당첨통계");
        System.out.println("--------------");
        for (WinningMoney winningMoney : WinningMoney.values()) {
            print(lottos, winningMoney, winningLotto);
        }
    }

    private static void print(LottosMap lottosMap, WinningMoney winningMoney, WinningLotto winningLotto) {
        if (winningMoney.isAbleToShow()) {
            System.out.print(winningMoney.getMessage());
            System.out.printf(MONEY_PER, winningMoney.getMoney());
            System.out.printf(MATCH_COUNT, lottosMap.matchLottoCount(winningMoney, winningLotto));
            System.out.println();
        }
    }

    private static void returnRate(LottosMap lottosMap, WinningLotto winningLotto) {
        System.out.printf(RETURN_RATE, lottosMap.returnRate(winningLotto));
    }
}
