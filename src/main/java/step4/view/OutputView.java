package step4.view;

import step4.model.LottoBuyCount;
import step4.model.Lottos;
import step4.model.Rank;

import java.util.Map;


public class OutputView {

    public static final String OUTPUT_LOTTO_BUY_COUNT = "수동으로 %s장, 자동으로 %s개를 구매했습니다.\n";
    public static final String OUTPUT_GAME_RESULT = "당첨 통계";
    public static final String OUTPUT_STATISTICS_LINE = "---------";
    public static final String OUTPUT_WINNERS_PROFIT_PERCENT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";
    public static final String OUTPUT_WINNERS_PROFIT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    public static final String OUTPUT_WINNERS_PROFIT_SECOND_GRADE_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개\n";

    public static void printLottoBuyCount(LottoBuyCount manualBuyCount, LottoBuyCount autoBuyCount) {
        System.out.printf(OUTPUT_LOTTO_BUY_COUNT, manualBuyCount, autoBuyCount);
    }

    public static void printBuyLottoResult(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printLottoStatistics(Map<Rank, Integer> lottoWinningStatistics, double lottoProfitPercent) {
        System.out.println();
        System.out.println(OUTPUT_GAME_RESULT);
        System.out.println(OUTPUT_STATISTICS_LINE);
        lottoWinningStatistics.forEach(OutputView::printLottoStatistic);
        System.out.printf(OUTPUT_WINNERS_PROFIT_PERCENT, lottoProfitPercent);
    }

    private static void printLottoStatistic(Rank rank, int matchCount) {
        if (rank == Rank.MISS) {
            return;
        }
        String printMessage = OUTPUT_WINNERS_PROFIT_MESSAGE;
        if (rank == Rank.SECOND) {
            printMessage = OUTPUT_WINNERS_PROFIT_SECOND_GRADE_MESSAGE;
        }

        System.out.printf(printMessage, rank.getCountOfMatch(), rank.getWinningMoney(), matchCount);
    }
}