package lotto.view;

import lotto.domain.LottoResult;
import lotto.enums.LottoRank;

import java.util.HashMap;

public class ResultView {

    private static final String LOTTO_PURCHASE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DASH = "---------";
    private static final String REWARD_MATCH_LOTTO = "%d개 일치%s(%d원) - %d개";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String TOTAL_PROFIT_PERCENT = "총 수익률은 %.02f입니다.";
    private static final String TOTAL_PROFIT_RESULT = "(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String PROFIT = "이익";
    private static final String LOSS = "손해";
    private static final String SPACE = " ";

    private ResultView() {

    }

    public static void lottoPurchase(int customLottoCount, int autoLottoCount, String purchaseLottoTickets) {
        System.out.println();
        System.out.println(String.format(LOTTO_PURCHASE, customLottoCount, autoLottoCount));
        System.out.println(purchaseLottoTickets);
    }

    public static void winningResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(DASH);
        HashMap<LottoRank, Integer> lottoResultMap = lottoResult.getLottoResultMap();
        for (LottoRank lottoRanking : lottoResultMap.keySet()) {
            statisticsResult(lottoRanking, lottoResultMap);
        }
    }

    private static void statisticsResult(LottoRank lottoRank, HashMap<LottoRank, Integer> winningStatistic) {
        if (!lottoRank.equals(LottoRank.NONE)) {
            System.out.println(String.format(REWARD_MATCH_LOTTO,
                    lottoRank.getMatchCount(), bonusMatch(lottoRank), lottoRank.getReward(), winningStatistic.get(lottoRank)));
        }
    }

    private static String bonusMatch(LottoRank lottoRank) {
        if (LottoRank.SECOND == lottoRank) {
            return BONUS_MATCH;
        }
        return SPACE;
    }

    public static void StatisticsPercent(double statisticsPercent) {
        System.out.print(String.format(TOTAL_PROFIT_PERCENT, statisticsPercent));
        System.out.print(String.format(TOTAL_PROFIT_RESULT, checkStatisticsResult(statisticsPercent)));
    }

    private static String checkStatisticsResult(double profitPercent) {
        if (profitPercent < 1) {
            return LOSS;
        }
        return PROFIT;
    }

}
