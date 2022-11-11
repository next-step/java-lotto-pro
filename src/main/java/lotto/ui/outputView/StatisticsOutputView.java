package lotto.ui.outputView;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningMoney;

import java.util.Map;

public class StatisticsOutputView {

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
        if (winningMoney.isShow()) {
            System.out.print(winningMoney.getMessage());
            System.out.print(" (" + winningMoney.getMoney() + "원)");
            System.out.println(" - " + (lottos.get("auto").matchLottoCount(winningMoney, winningLotto) + lottos.get("manual").matchLottoCount(winningMoney, winningLotto)) + "개");
        }
    }

    private static void returnRate(Map<String, Lottos> lottosMap, WinningLotto winningLotto) {
        Lottos lottos = new Lottos();
        lottos.addAll(lottosMap.get("manual").getLottos());
        lottos.addAll(lottosMap.get("auto").getLottos());
        System.out.println("총 수익률은 " + lottos.returnRate(winningLotto) + "입니다");
    }
}
