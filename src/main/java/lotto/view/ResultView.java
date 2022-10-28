package lotto.view;

import lotto.Lotto;
import lotto.Lottos;
import lotto.message.LottoMessage;
import lotto.money.Money;
import lotto.statistic.LottoStatistic;
import lotto.statistic.LottoStatisticResults;
import lotto.win.WinRanking;

public class ResultView {
    private ResultView() {
    }

    public static void printPurchaseResult(Lottos lottos) {
        System.out.printf(LottoMessage.PURCHASE_RESULT, lottos.size());
        newLine();
        printLottos(lottos);
    }

    private static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
        newLine();
    }

    public static void printResult(LottoStatistic lottoStatistic) {
        newLine();
        System.out.println(LottoMessage.WINNING_STATISTIC);
        System.out.println(LottoMessage.DIVIDER_LINE);
        printStatisticResults(lottoStatistic.results());
        printProfit(lottoStatistic);
    }

    private static void printStatisticResults(LottoStatisticResults results) {
        for (WinRanking ranking : WinRanking.values()) {
            System.out.printf((LottoMessage.WINNING_STATISTIC_RESULT) + "%n", ranking.getMatchCount(),
                    ranking.getWinningMoney(), results.winningCount(ranking));
        }
    }

    private static void printProfit(LottoStatistic lottoStatistic) {
        Money priceOfOneLotto = Money.from(100);
        System.out.printf(LottoMessage.PROFIT, lottoStatistic.profit(priceOfOneLotto));
        if (lottoStatistic.isLossProfit(priceOfOneLotto)) {
            System.out.println(LottoMessage.LOSS);
        }
    }

    private static void newLine() {
        System.out.println();
    }
}
