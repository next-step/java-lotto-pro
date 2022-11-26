package lotto2.view;

import lotto2.model.*;
import lotto2.model.enums.LottoPrize;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public void printListOfLotto(ManualLottoCount manualLottoCount, int automaticLottoCount, List<Lotto> lottoBucket) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoCount.count(), automaticLottoCount);
        for (Lotto lotto : lottoBucket) {
            printEachLotto(lotto);
        }
    }

    private void printEachLotto(Lotto lotto) {
        System.out.print(lotto + "\n");
    }

    public void printStatistics(List<WinningRankCountDto> winningRankCounts) {
        System.out.print("\n당첨 통계\n" +
                "---------\n");
        for (WinningRankCountDto eachWinningRankCount : winningRankCounts) {
            if (eachWinningRankCount.getLottoPrize() == LottoPrize.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n",
                        eachWinningRankCount.getLottoPrize().getNumberMatch(),
                        eachWinningRankCount.getLottoPrize().getPrize(),
                        eachWinningRankCount.getCount()
                );
                continue;
            }
            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    eachWinningRankCount.getLottoPrize().getNumberMatch(),
                    eachWinningRankCount.getLottoPrize().getPrize(),
                    eachWinningRankCount.getCount()
            );
        }
    }

    public void printProfitRatio(double profitRatio) {
        System.out.printf("총 수익률은 %s입니다.\n", decimalFormat.format(profitRatio));
    }
}
