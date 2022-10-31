package step4.view;

import step4.constant.OutputMessage;
import step4.model.LottoBuyCount;
import step4.model.LottoResult;
import step4.model.Rank;

import java.util.List;
import java.util.Map;


public class OutputView {
    public static void printLottoBuyCount(LottoBuyCount count) {
        System.out.printf(OutputMessage.OUTPUT_LOTTO_BUY_COUNT, count);
    }

    public static void printBuyLottoResult(List<LottoResult> lottoResults) {
        lottoResults.forEach(System.out::println);
    }

    public static void printLottoStatistics(Map<Rank, Integer> lottoWinningStatistics, double lottoProfitPercent) {
        System.out.println();
        System.out.println(OutputMessage.OUTPUT_GAME_RESULT);
        System.out.println(OutputMessage.OUTPUT_STATISTICS_LINE);
        lottoWinningStatistics.forEach(OutputView::printLottoStatistic);
        System.out.printf(OutputMessage.OUTPUT_WINNERS_PROFIT_PERCENT, lottoProfitPercent);
    }

    private static void printLottoStatistic(Rank rank, int matchCount) {
        if (rank == Rank.MISS) {
            return;
        }
        String printMessage = OutputMessage.OUTPUT_WINNERS_PROFIT_MESSAGE;
        if (rank == Rank.SECOND) {
            printMessage = OutputMessage.OUTPUT_WINNERS_PROFIT_SECOND_GRADE_MESSAGE;
        }

        System.out.printf(printMessage, rank.getCountOfMatch(), rank.getWinningMoney(), matchCount);
    }
}