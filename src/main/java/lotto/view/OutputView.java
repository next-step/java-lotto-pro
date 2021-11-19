package lotto.view;

import lotto.consts.WinningEnum;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.ProfitRate;
import lotto.domain.WinningStats;

import java.util.Arrays;

public class OutputView {

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public void printWinningStats(WinningStats winningStats) {
        System.out.println("\n당첨 통계\n" +
                        "---------\n" +
                        String.format("%d개 일치 (%d원)- %d개\n", WinningEnum.FIFTH.getMatched(), WinningEnum.FIFTH.getPrize(), winningStats.getWinningStats().get(WinningEnum.FIFTH)) +
                        String.format("%d개 일치 (%d원)- %d개\n", WinningEnum.FOURTH.getMatched(), WinningEnum.FOURTH.getPrize(), winningStats.getWinningStats().get(WinningEnum.FOURTH)) +
                        String.format("%d개 일치 (%d원)- %d개\n", WinningEnum.THIRD.getMatched(), WinningEnum.THIRD.getPrize(), winningStats.getWinningStats().get(WinningEnum.THIRD)) +
                        String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개\n", WinningEnum.SECOND.getMatched(), WinningEnum.SECOND.getPrize(), winningStats.getWinningStats().get(WinningEnum.SECOND)) +
                        String.format("%d개 일치 (%d원)- %d개\n", WinningEnum.FIRST.getMatched(), WinningEnum.FIRST.getPrize(), winningStats.getWinningStats().get(WinningEnum.FIRST)));
    }

    public void printProfitRate(ProfitRate profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.", profitRate.getProfitRate());
    }
}
