package lotto.view;

import lotto.consts.LottoNumberConst;
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
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.printf("%d개 일치 (%d원)- %d개\n", LottoNumberConst.LOTTO_NUMBER_SIZE - 3, WinningEnum.FIFTH.getPrize(), winningStats.getWinningStats().get(WinningEnum.FIFTH));
        System.out.printf("%d개 일치 (%d원)- %d개\n", LottoNumberConst.LOTTO_NUMBER_SIZE - 2, WinningEnum.FOURTH.getPrize(), winningStats.getWinningStats().get(WinningEnum.FOURTH));
        System.out.printf("%d개 일치 (%d원)- %d개\n", LottoNumberConst.LOTTO_NUMBER_SIZE - 1, WinningEnum.THIRD.getPrize(), winningStats.getWinningStats().get(WinningEnum.THIRD));
        System.out.printf("%d개 일치 (%d원)- %d개\n", LottoNumberConst.LOTTO_NUMBER_SIZE, WinningEnum.FIRST.getPrize(), winningStats.getWinningStats().get(WinningEnum.FIRST));
    }

    public void printProfitRate(ProfitRate profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.", profitRate.getProfitRate());
    }
}
