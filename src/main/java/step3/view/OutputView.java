package step3.view;

import step3.constant.OutputMessage;
import step3.model.LottoBuyCount;
import step3.model.LottoResult;
import step3.model.LottoReward;

import java.util.List;
import java.util.Map;


public class OutputView {
    public static void printLottoBuyCount(LottoBuyCount count) {
        System.out.printf(OutputMessage.OUTPUT_LOTTO_BUY_COUNT, count);
    }

    public static void printBuyLottoResult(List<LottoResult> lottoResults) {
        lottoResults.forEach(System.out::println);
    }

    public static void printLottoStatistics(Map<Integer, Integer> lottoWinningStatistics, double lottoProfitPercent) {
        System.out.println();
        System.out.println(OutputMessage.OUTPUT_GAME_RESULT);
        System.out.println(OutputMessage.OUTPUT_STATISTICS_LINE);
        lottoWinningStatistics.forEach(OutputView::printLottoStatistic);
        System.out.printf(OutputMessage.OUTPUT_WINNERS_PROFIT_PERCENT, lottoProfitPercent);
    }

    private static void printLottoStatistic(int matchCount, int count) {
        if (matchCount > 2) {
            System.out.printf(OutputMessage.OUTPUT_WINNERS_PROFIT_MESSAGE, matchCount, LottoReward.getLottoReward(matchCount).getMoney(), count);
        }
    }
}
