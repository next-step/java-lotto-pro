package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningStatistic;
import lotto.domain.WinningStatistics;

public class ResultView {
    private static final String NOTICE_BUY_QUANTITY = "개를 구매했습니다.";
    private static final String NOTICE_WINNING_STATISTICS_RESULT = "%d개 일치 (%d원)- %d개";
    private static final String NOTICE_WINNING_STATISTICS = "당첨 통계\n---------";

    public void printBuyMessage(int quantity) {
        System.out.println(quantity + NOTICE_BUY_QUANTITY);
    }

    public void printLottoList(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatistics(WinningStatistics statistics) {
        System.out.println(NOTICE_WINNING_STATISTICS);
        List<WinningStatistic> statisticList = statistics.getWinningStatistic();
        for (WinningStatistic winningStatistic : statisticList) {
            System.out.println(String.format(NOTICE_WINNING_STATISTICS_RESULT, winningStatistic.getWinningRank().getMatchCount(), winningStatistic.getWinningRank().getReward(), winningStatistic.getCount()));
        }
    }
}
