package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.enums.Rank;
import lotto.domain.WinningStatistic;

import java.util.Arrays;
import java.util.Collections;

public class ResultView {

    public static void printPurchaseCount(Lottos lottos) {
        System.out.println(lottos.count() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Collections.sort(lotto.getLotto());
            System.out.println(lotto.getLotto());
        }
    }

    public static void printWinningStatistic(WinningStatistic statistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.values())
                .filter(Rank::win)
                .forEach(rank ->
                    printWinningStatistic(rank, statistic)
                );
    }

    private static void printWinningStatistic(Rank rank, WinningStatistic statistic) {
        String format = String.format("%d개 일치 (%d원) - %d개"
                , rank.matchingCount(), rank.prize(), statistic.count(rank));
        System.out.println(format);
    }

    public static void printRateOfReturn(WinningStatistic statistic, double purchaseAmount) {
        double rate = statistic.calculateRateOfReturn(purchaseAmount);
        System.out.print("총 수익률은 " + rate + "입니다.");
    }
}
