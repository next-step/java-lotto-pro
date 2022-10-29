package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoConstant;
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

    public static void printResult(Lottos lottos, List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        newLine();
        System.out.println(LottoMessage.WINNING_STATISTIC);
        System.out.println(LottoMessage.DIVIDER_LINE);
        printWinResults(lottos, winningNumbers, bonusNumber);
        printProfit(Profit.of(lottos, winningNumbers, bonusNumber));
    }

    private static void printWinResults(Lottos lottos, List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        Map<WinRanking, Integer> winningCountByWinRanking = lottos.winResults(winningNumbers, bonusNumber);
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
