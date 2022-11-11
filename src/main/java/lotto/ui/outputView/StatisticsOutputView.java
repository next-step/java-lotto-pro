package lotto.ui.outputView;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningMoney;

import java.util.Map;

public class StatisticsOutputView {

    public static final String RETURN_RATE = "총 수익률은 %f 입니다";
    public static final String MATCH_COUNT = " - %d 개";
    public static final String MONEY_PER = "(%d원)";

    public static void winningResult(Map<String, Lottos> lottos, WinningLotto winningLotto) {
        winningMoney(lottos, winningLotto);
        returnRate(lottos, winningLotto);
    }

    public static void winningMoney(Map<String, Lottos> lottos, WinningLotto winningLotto) {
        System.out.println("당첨통계");
        System.out.println("--------------");
        for (WinningMoney winningMoney : WinningMoney.values()) {
            print(lottos, winningMoney, winningLotto);
        }
    }

    private static void print(Map<String, Lottos> lottos, WinningMoney winningMoney, WinningLotto winningLotto) {
        if (winningMoney.isAbleToShow()) {
            System.out.print(winningMoney.getMessage());
            System.out.printf(MONEY_PER, winningMoney.getMoney());
            System.out.printf(MATCH_COUNT, lottos.get("auto").matchLottoCount(winningMoney, winningLotto) + lottos.get("manual").matchLottoCount(winningMoney, winningLotto));
            System.out.println();
        }
    }

    private static void returnRate(Map<String, Lottos> lottosMap, WinningLotto winningLotto) {
        Lottos lottos = new Lottos();
        lottos.addAll(lottosMap.get("manual").getLottos());
        lottos.addAll(lottosMap.get("auto").getLottos());
        System.out.printf(RETURN_RATE, lottos.returnRate(winningLotto));
    }
}
