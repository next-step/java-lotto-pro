package study.lotto.view;

import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.model.Rank;
import study.lotto.model.RankStatistics;

import java.util.EnumMap;

public class LottoWinningStatisticsView {

    private static final int STANDARD_VALUE = 1;
    private static final String INCOME_RATE_GUIDE_TEMPLATE_MESSAGE = "총 수익률은 %.2f입니다.";
    public static final String LOSS_GUIDE_MESSAGE = "(기준이 1이기 떄문에 결과적으로 손해라는 의미임)";
    public static final String RANK_STATISTICS_GUIDE_MESSAGE = "%d 일치 (%d원)- %d개\n";
    public static final String TITLE_MESSAGE = "당첨 통계\n---------";

    private LottoWinningStatisticsView() {
    }

    public static void resolve(final WinningStatisticsResponseDto winningStatistics) {
        printTitle();
        printRankStatistics(winningStatistics);
        printIncomeRate(winningStatistics);
    }

    private static void printIncomeRate(final WinningStatisticsResponseDto winningStatistics) {
        final double incomeRate = winningStatistics.getIncomeRate();
        System.out.printf(INCOME_RATE_GUIDE_TEMPLATE_MESSAGE, incomeRate);
        if (incomeRate < STANDARD_VALUE) {
            System.out.println(LOSS_GUIDE_MESSAGE);
        }
    }

    private static void printRankStatistics(final WinningStatisticsResponseDto winningStatistics) {
        for (Rank rank : Rank.getRanksOrderByWinningMoney()) {
            final EnumMap<Rank, Integer> rankStatistics = winningStatistics.getRankStatistics();
            System.out.printf(RANK_STATISTICS_GUIDE_MESSAGE, rank.getCountOfMatch(), rank.getWinningMoney(), rankStatistics.getOrDefault(rank, RankStatistics.DEFAULT_COUNT));
        }
    }

    private static void printTitle() {
        System.out.println(TITLE_MESSAGE);
    }
}
