package lotto.view;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.profit.Profit;
import lotto.domain.win.WinRanking;
import lotto.message.LottoMessage;

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

    public static void printResult(Lottos lottos, List<LottoNumber> winningNumbers) {
        newLine();
        System.out.println(LottoMessage.WINNING_STATISTIC);
        System.out.println(LottoMessage.DIVIDER_LINE);
        printStatisticResults(lottos, winningNumbers);
        printProfit(Profit.of(lottos, winningNumbers));
    }

    private static void printStatisticResults(Lottos lottos, List<LottoNumber> winningNumbers) {
        for (WinRanking ranking : WinRanking.values()) {
            System.out.printf((LottoMessage.WINNING_STATISTIC_RESULT) + "%n", ranking.getMatchCount(),
                    ranking.getWinningMoney(), lottos.winningCount(winningNumbers, ranking.getMatchCount()));
        }
    }

    private static void printProfit(Profit profit) {
        System.out.printf(LottoMessage.PROFIT, profit.profit());
        if (profit.isLossProfit()) {
            System.out.println(LottoMessage.LOSS);
        }
    }

    private static void newLine() {
        System.out.println();
    }
}
