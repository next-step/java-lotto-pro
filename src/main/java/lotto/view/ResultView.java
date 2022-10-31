package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoConstant;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.profit.Profit;
import lotto.domain.win.WinRanking;
import lotto.message.LottoMessage;

public class ResultView {
    private ResultView() {
    }

    public static void printPurchaseResult(List<Lotto> lottos) {
        System.out.printf(LottoMessage.PURCHASE_RESULT, lottos.size());
        newLine();
        printLottos(lottos);
    }

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        newLine();
    }

    public static void printResult(List<Lotto> lottos, WinningLotto winningLotto) {
        newLine();
        System.out.println(LottoMessage.WINNING_STATISTIC);
        System.out.println(LottoMessage.DIVIDER_LINE);
        printWinResults(lottos, winningLotto);
        printProfit(Profit.of(lottos, winningLotto));
    }

    private static void printWinResults(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<WinRanking, Integer> winningCountByWinRanking = winningLotto.winResults(lottos);
        for (WinRanking winRanking : WinRanking.winnableRankings()) {
            System.out.printf(
                    (LottoMessage.WINNING_STATISTIC_RESULT) + "%n",
                    winRanking.getMatchCount(),
                    addBonusNumberMatchingMessageOrEmpty(winRanking),
                    winRanking.getWinningMoney(),
                    winningCountByWinRanking.getOrDefault(winRanking, LottoConstant.EMPTY_WINNING_COUNT)
            );
        }
    }

    private static String addBonusNumberMatchingMessageOrEmpty(WinRanking winRanking) {
        if (winRanking.isSecond()) {
            return LottoMessage.BONUS_NUMBER_MATCHING;
        }
        return LottoMessage.EMPTY_SPACE;
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
