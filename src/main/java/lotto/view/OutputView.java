package lotto.view;

import lotto.consts.WinningEnum;
import lotto.domain.*;

import java.util.Arrays;

public class OutputView {

    public void printLottos(ManualLottos manualLottos, Lottos lottos) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottos.getSize(), lottos.getLottos().size());
        for (Lotto lotto : manualLottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.getLottoNumbers().stream().map(LottoNumber::getNumber).toArray()));
        }
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.getLottoNumbers().stream().map(LottoNumber::getNumber).toArray()));
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
