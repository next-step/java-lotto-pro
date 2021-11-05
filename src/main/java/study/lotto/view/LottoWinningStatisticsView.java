package study.lotto.view;

import study.lotto.model.Rank;
import study.lotto.model.RankStatistics;
import study.lotto.model.WinningStatistics;

public class LottoWinningStatisticsView {

    private static final int STANDARD_VALUE = 1;
    private static final String INCOME_RATE_GUIDE_TEMPLATE_MESSAGE = "총 수익률은 %f 입니다.";
    public static final String LOSS_GUIDE_MESSAGE = "(기준이 1이기 떄문에 결과적으로 손해라는 의미임)";
    public static final String RANK_STATISTICS_GUIDE_MESSAGE = "%d 일치 (%d원)- %d개\n";
    public static final String TITLE_MESSAGE = "당첨 통계\n---------";

    public void resolve(WinningStatistics winningStatistics) {
        printTitle();
        printRankStatistics(winningStatistics);
        printIncomeRate(winningStatistics);
    }

    private void printIncomeRate(WinningStatistics winningStatistics) {
        final double incomeRate = winningStatistics.getIncomeRate();
        System.out.printf(INCOME_RATE_GUIDE_TEMPLATE_MESSAGE, incomeRate);
        if (incomeRate < STANDARD_VALUE) {
            System.out.println(LOSS_GUIDE_MESSAGE);
        }
    }

    private void printRankStatistics(WinningStatistics winningStatistics) {
        final RankStatistics rankStatistics = winningStatistics.getRankStatistics();
        for (Rank rank : Rank.getRanksOrderByWinningMoney()) {
            System.out.printf(RANK_STATISTICS_GUIDE_MESSAGE, rank.getCountOfMatch(), rank.getWinningMoney(), rankStatistics.countByRank(rank));
        }
    }

    private void printTitle() {
        System.out.println(TITLE_MESSAGE);
    }
}
