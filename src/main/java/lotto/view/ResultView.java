package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningStatistic;
import lotto.enums.Rank;

import java.util.Arrays;
import java.util.Collections;

import static lotto.view.message.ResultMessage.*;

public class ResultView {

    public static void printPurchaseCount(Lottos lottos) {
        String format = String.format(BUY_LOTTO.message(), lottos.count());
        System.out.println(format);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Collections.sort(lotto.getLotto());
            System.out.println(lotto.getLotto());
        }
        System.out.println();
    }

    public static void printWinningStatistic(WinningStatistic statistic) {
        System.out.println();
        System.out.println(WINNER_STATISTICS.message());
        System.out.println(LINE.message());

        Arrays.stream(Rank.values())
                .filter(Rank::win)
                .forEach(rank ->
                    printWinningStatistic(rank, statistic)
                );
    }

    private static void printWinningStatistic(Rank rank, WinningStatistic statistic) {
        String format = String.format(WINNER_MATCH_RESULT.message()
                , rank.matchingCount(), rank.prize(), statistic.count(rank));
        System.out.println(format);
    }

    public static void printRateOfReturn(WinningStatistic statistic, Money purchaseAmount) {
        double rate = statistic.calculateRateOfReturn(purchaseAmount);
        String format = String.format(TOTAL_RATE_RESULT.message(), rate);
        System.out.print(format);
    }
}
